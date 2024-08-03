package com.Medical.HealthCard.Controller;

import com.Medical.HealthCard.DTO.PatientDTO;
import com.Medical.HealthCard.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/l")
public class PatientController {


    @Autowired
    private PatientService patientService;

    //craete
    @PostMapping("/create-Patient")
    public ResponseEntity<PatientDTO> createPatient(
            @RequestBody PatientDTO patientDTO
    )
    {
        final PatientDTO patient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }




    //update
    @PutMapping("/{patientId}/update-patient")
    public ResponseEntity<PatientDTO> updatePatient(
            @RequestBody PatientDTO patientDTO,
            @PathVariable(name = "patientId") String patientId

    ){
        final PatientDTO updatedPatientDTO = patientService.updatePatient(patientDTO, patientId);
        return new ResponseEntity<>(updatedPatientDTO,HttpStatus.OK);
    }


    //get patient details
    @GetMapping("/Get-Patient/{patientId}")
    public ResponseEntity<PatientDTO> getPatientDetials(
            @PathVariable(name = "patientId") String patientId
    ){
        final PatientDTO patientDetail = patientService.getPatientDetail(patientId);
        return new ResponseEntity<>(patientDetail,HttpStatus.OK);
    }
    //Appointment Rest API will be created


}
