package com.Medical.HealthCard.Service.Impl;

import com.Medical.HealthCard.DTO.DoctorDTO;
import com.Medical.HealthCard.DTO.DoctorVerifiableDTO;
import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.Entity.DoctorEntity;
import com.Medical.HealthCard.Entity.DoctorValidateInfo;
import com.Medical.HealthCard.Entity.PatientEntity;
import com.Medical.HealthCard.Repository.DoctorDetailsRepo;
import com.Medical.HealthCard.Repository.PatientRepo;
import com.Medical.HealthCard.Repository.Verifable;
import com.Medical.HealthCard.Service.DoctorService;
import com.Medical.HealthCard.Uitls.ExceptionXHandlers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @Autowired
    public Verifable verifable;


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

        // validate doctor
        DoctorDTO doctorDTOReturn=null;
        String doctorRegKey=doctorDTO.getDoctorRegKey();
        final boolean validateDoctor = validateDoctor(doctorRegKey,doctorDTO.getDoctorName());
        if(validateDoctor){
            doctorEntity.setValidDoctor(validateDoctor);
            final DoctorEntity saveDoctorDetails = doctorDetailsRepo.save(doctorEntity);
            doctorDTOReturn = modelMapper.map(saveDoctorDetails, DoctorDTO.class);
        }
        else
            throw new ExceptionXHandlers("Doctor Register key "+doctorRegKey+" is not valid");
        return doctorDTOReturn;
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
    public DoctorVerifiableDTO addDataVerifiable(DoctorVerifiableDTO doctorVerifiableDTO) {

        final DoctorValidateInfo doctorVerifiable = modelMapper.map(doctorVerifiableDTO, DoctorValidateInfo.class);
        final DoctorValidateInfo saveData = verifable.save(doctorVerifiable);
        return modelMapper.map(saveData, DoctorVerifiableDTO.class);
       // return doctorVerifySavedData;
    }

    @Override
    public String createHCOfPatient(String patientId, HealthCardDetailsDTO healthCardDetailsDTO) {

        final PatientEntity patientEntity = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Patient is not found with provided ID"));



        return null;
    }
    private boolean validateDoctor(String doctorRegKey , String doctorName){
        final DoctorValidateInfo byRegKey = verifable.findByRegKey(doctorRegKey);
        if(byRegKey!=null)
         return byRegKey.getDoctorName().equalsIgnoreCase(doctorName);
        else
            return false;
    }




}
