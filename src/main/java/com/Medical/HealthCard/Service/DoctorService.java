package com.Medical.HealthCard.Service;

import com.Medical.HealthCard.DTO.DoctorDTO;
import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.DTO.PatientDTO;

import javax.swing.plaf.PanelUI;

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


    /***
     *  B Part for functionality as well be added
     */

    public String createHCOfPatient(String PatientId, HealthCardDetailsDTO healthCardDetailsDTO);



}
