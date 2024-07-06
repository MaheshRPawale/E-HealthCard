package com.Medical.HealthCard.Service.Impl;

import com.Medical.HealthCard.DTO.PatientDTO;
import com.Medical.HealthCard.Entity.PatientEntity;
import com.Medical.HealthCard.Repository.PatientRepo;
import com.Medical.HealthCard.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
   private ModelMapper modelMapper;



    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {

        final PatientEntity patientEntity = modelMapper.map(patientDTO, PatientEntity.class);
        String healthCardId= String.valueOf(UUID.randomUUID());
        patientEntity.setPatientHCID(healthCardId);
        final PatientEntity savedPatientEntity = patientRepo.save(patientEntity);
        return modelMapper.map(savedPatientEntity,PatientDTO.class);

    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO,String patientId) {
        final PatientEntity patientEntity = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException());
        patientEntity.setPatientContact(patientDTO.getPatientContact());
        patientEntity.setPatientMail(patientDTO.getPatientMail());
        patientEntity.setPatientName(patientDTO.getPatientName());
        /***
         *  Don't need to store all details.
         *  Patient HealthCard and patientId are not need to upadte
         *
         */
        final PatientEntity updatedPatient = patientRepo.save(patientEntity);
        return modelMapper.map(updatedPatient,PatientDTO.class);
    }

    @Override
    public PatientDTO getPatientDetail(String patientId){
        final PatientEntity patientEntity = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Patient is not found"));
        return modelMapper.map(patientEntity,PatientDTO.class);
    }
}
