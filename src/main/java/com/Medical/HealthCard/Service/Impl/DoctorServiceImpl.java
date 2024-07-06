package com.Medical.HealthCard.Service.Impl;

import com.Medical.HealthCard.DTO.DoctorDTO;
import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.Entity.DoctorEntity;
import com.Medical.HealthCard.Entity.PatientEntity;
import com.Medical.HealthCard.Repository.DoctorDetailsRepo;
import com.Medical.HealthCard.Repository.PatientRepo;
import com.Medical.HealthCard.Service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.random.RandomGenerator;

@Service
public class DoctorServiceImpl implements DoctorService {

    // DI Part
    @Autowired
    public DoctorDetailsRepo doctorDetailsRepo;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public PatientRepo patientRepo;

    @Override
    public DoctorDTO createDoctor( DoctorDTO doctorDTO) {
        final DoctorEntity doctorEntity = modelMapper.map(doctorDTO, DoctorEntity.class);
       // Generate hospital ID
        String hospitalId= String.valueOf(UUID.randomUUID());
        doctorEntity.setHospitalId(hospitalId);
        /****
         * Req data -> DTO (Save) doctorDTO obj
         * Repositor JPA (Entity) covert into doctorEntity obj
         *  1. GETTER SETTER
         *  2. USE MODEL MAPPER
          */
        final DoctorEntity saveDoctorDetails = doctorDetailsRepo.save(doctorEntity);
       return modelMapper.map(saveDoctorDetails,DoctorDTO.class);

    }

    @Override
    public DoctorDTO updateDoctor(String doctorId,DoctorDTO doctorDTO) {
        final DoctorEntity doctorEntity = doctorDetailsRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("doctor is not found by provided Id"));
        doctorEntity.setDoctorName(doctorDTO.getDoctorName());
        doctorEntity.setQualification(doctorDTO.getQualification());
        doctorEntity.setSpecification(doctorDTO.getSpecification());
        doctorEntity.setHospitalId(doctorDTO.getHospitalId());
        doctorEntity.setHospitalName(doctorDTO.getHospitalName());
        doctorEntity.setHospitalAddress(doctorDTO.getHospitalAddress());
        doctorEntity.setHospitalContactNumber(doctorDTO.getHospitalContactNumber());
        doctorEntity.setValidDoctor(doctorDTO.isValidDoctor());
        final DoctorEntity savedDoctor = doctorDetailsRepo.save(doctorEntity);
        return modelMapper.map(savedDoctor,DoctorDTO.class);
    }

    @Override
    public boolean deleteDoctor(String doctorId) {
        doctorDetailsRepo.deleteById(doctorId);
        return true;
    }

    @Override
    public boolean verify() {
        return false;
    }

    @Override
    public String createHCOfPatient(String patientId, HealthCardDetailsDTO healthCardDetailsDTO) {

        final PatientEntity patientEntity = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Patient is not found with provided ID"));



        return null;
    }
}
