package com.Medical.HealthCard.Service;

import com.Medical.HealthCard.DTO.*;

public interface DoctorService {

    /**
     *  A. Part for CRUD operations
     */
    //create doctor
    public DoctorDTO createDoctor(DoctorDTO doctorDTO);
    //update doctor
    public DoctorDTO updateDoctor(String doctorId, DoctorDTO doctorDTO);
    //delete
    public boolean deleteDoctor(String doctorId);
    //verify
    public  boolean verify();

    public DoctorDTO login(LoginDTO loginDTO);
    public DoctorVerifiableDTO addDataVerifiable(DoctorVerifiableDTO doctorVerifiableDTO);
    /***
     *  B Part for functionality as well be added
     */

    public String createHCOfPatient(String PatientId, HealthCardDetailsDTO healthCardDetailsDTO);


    public void saveUserCredential(UserCredentailDTO userCredentailDTO);


}
