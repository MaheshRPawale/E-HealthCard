package com.Medical.HealthCard.Service;

import com.Medical.HealthCard.DTO.PatientDTO;

public interface PatientService {


    public PatientDTO createPatient(PatientDTO patientDTO);
    public PatientDTO updatePatient(PatientDTO patientDTO,String patientId);
    public PatientDTO getPatientDetail(String patientId);

    // Book Appointment

    // View Appointment



}
