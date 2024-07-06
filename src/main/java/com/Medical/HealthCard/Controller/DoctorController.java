package com.Medical.HealthCard.Controller;

import com.Medical.HealthCard.DTO.DoctorDTO;
import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.DTO.MedicineDetailsDTO;
import com.Medical.HealthCard.DTO.PatientDTO;
import com.Medical.HealthCard.Service.DoctorService;
import com.Medical.HealthCard.Service.HealthCardDetailService;
import com.Medical.HealthCard.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {



    @Autowired
    private DoctorService doctorService;

    @Autowired
    public PatientService patientService;

    @Autowired
    public HealthCardDetailService healthCardDetailService;

    @PostMapping("/new")
    public ResponseEntity<DoctorDTO> createNewDoctReg(
        @RequestBody DoctorDTO doctorDTO
    )
    {
        final DoctorDTO createdDoctor = doctorService.createDoctor(doctorDTO);
        return new ResponseEntity<>(createdDoctor, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public String deleteDoctor(
        @RequestParam(name = "doctorId")  String docString
    ){
        final boolean status = doctorService.deleteDoctor(docString);
        if (!status)
            return "doctor information is unable to delete";
        else
            return "doctor information is deleted";

    }
    @PutMapping("/update")
    public ResponseEntity<DoctorDTO> updateDoctorDetails(
            @RequestBody DoctorDTO doctorDTO,
            @RequestParam(name = "doctorId") String doctorId
    )
    {
        final DoctorDTO savedDoctorDTO = doctorService.updateDoctor(doctorId, doctorDTO);
        return new ResponseEntity<>(savedDoctorDTO,HttpStatus.OK);
    }

    //Craete patient


    @PostMapping("/createPatient")
    public  ResponseEntity<PatientDTO> createPatient(

            @RequestBody PatientDTO patientDTO


    ){
        final PatientDTO patient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    //Create healthCradDetails
    @PostMapping("/{healthCardId}/crateDetails")
    public ResponseEntity<HealthCardDetailsDTO> createHealthCardDetails(
            @PathVariable(name = "healthCardId") String healthCardID,
            @RequestBody HealthCardDetailsDTO healthCardDetailsDTO
    ){
        final HealthCardDetailsDTO healthcard = healthCardDetailService.createHealthcard(healthCardDetailsDTO, healthCardID);
        return new ResponseEntity<>(healthcard,HttpStatus.CREATED);

    }


//updateHealthCard
    @PostMapping("/{healthCardDeatilId}/updateDetails")
    public ResponseEntity<HealthCardDetailsDTO>  updateHealthCardDetail(

            @PathVariable(name = "healthCardDeatilId") int healthCardID,
            @RequestBody HealthCardDetailsDTO healthCardDetailsDTO

    ){


        final HealthCardDetailsDTO healthCardDetailsDTO1 = healthCardDetailService.updateHealthCard(healthCardDetailsDTO, healthCardID);
        return new ResponseEntity<>(healthCardDetailsDTO1,HttpStatus.OK);
    }


    //GetListOfHealthCardDeatails
    @GetMapping("/getHCDetails")
    public ResponseEntity<List<HealthCardDetailsDTO>> gethealthCardDetails(
            @RequestParam String hCDtlID
    ){
        final List<HealthCardDetailsDTO> allHealthCardDetailsByHealthCard = healthCardDetailService.getAllHealthCardDetailsByHealthCard(hCDtlID);
        return new ResponseEntity<>(allHealthCardDetailsByHealthCard,HttpStatus.OK);

    }

    //GetListOfMedicineDetails
/*    @GetMapping("/getHCDetails")
    public ResponseEntity<List<MedicineDetailsDTO>> getMedicineList(
            @RequestParam int hCDtlID
    ){
        final List<MedicineDetailsDTO> medicineDetails = healthCardDetailService.getMedicineDetails(hCDtlID);
        return new ResponseEntity<>(medicineDetails,HttpStatus.OK);

    }
*/



}
