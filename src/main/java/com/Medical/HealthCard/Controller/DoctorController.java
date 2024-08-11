package com.Medical.HealthCard.Controller;

import com.Medical.HealthCard.DTO.*;
import com.Medical.HealthCard.Repository.Verifable;
import com.Medical.HealthCard.Service.DoctorService;
import com.Medical.HealthCard.Service.HealthCardDetailService;
import com.Medical.HealthCard.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<DoctorDTO> createNewDoctReg(@Valid @RequestBody DoctorCredentialDTO doctorCredentialDTO
    )
    {

        DoctorDTO doctorDTO = DoctorDTO.builder()
                .doctorName(doctorCredentialDTO.getDoctorName())
                .qualification(doctorCredentialDTO.getQualification())
                .specification(doctorCredentialDTO.getSpecification())
                .hospitalId(doctorCredentialDTO.getHospitalId())
                .hospitalAddress(doctorCredentialDTO.getHospitalAddress())
                .hospitalContactNumber(doctorCredentialDTO.getHospitalContactNumber())
                .hospitalName(doctorCredentialDTO.getHospitalName())
                .doctorRegKey(doctorCredentialDTO.getDoctorRegKey())
                //.validDoctor(doctorCredentialDTO.isValidDoctor())
                .build();

        UserCredentailDTO doctorCredential = UserCredentailDTO.builder()
                .userName(doctorCredentialDTO.getUserName())
                .password(doctorCredentialDTO.getPassword())
                .build();


        final DoctorDTO createdDoctor = doctorService.createDoctor(doctorDTO);
        doctorService.saveUserCredential(doctorCredential);
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

    //Login
    @GetMapping("/login")
    public ResponseEntity<DoctorDTO> loginDoctor(
            @RequestBody LoginDTO loginDTO
    ){
        DoctorDTO doctorDTO = doctorService.login(loginDTO);
        return new ResponseEntity<>(doctorDTO,HttpStatus.OK);

    }



    //Craete patient


    @PostMapping("/createPatient")
    public  ResponseEntity<PatientDTO> createPatient(

         @Valid  @RequestBody PatientDTO patientDTO

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

            @PathVariable(name = "healthCardDeatilId") String healthCardID,
            @RequestBody HealthCardDetailsDTO healthCardDetailsDTO

    ){


        final HealthCardDetailsDTO healthCardDetailsDTO1 = healthCardDetailService.updateHealthCard(healthCardDetailsDTO, healthCardID);
        return new ResponseEntity<>(healthCardDetailsDTO1,HttpStatus.OK);
    }


    //GetListOfHealthCardDeatails
    @GetMapping("/getHCDetails")
    public ResponseEntity<List<HealthCardDetailsDTO>> gethealthCardDetails(
            @RequestParam String healthCardId
    ){
        final List<HealthCardDetailsDTO> allHealthCardDetailsByHealthCard = healthCardDetailService.getAllHealthCardDetailsByHealthCard(healthCardId);
        return new ResponseEntity<>(allHealthCardDetailsByHealthCard,HttpStatus.OK);

    }

    @PostMapping("/AddVerifyDocotor")
    public ResponseEntity<DoctorVerifiableDTO> createDoctorVerifiableData(

            @Valid @RequestBody DoctorVerifiableDTO doctorVerifiableDTO

    ){

        final DoctorVerifiableDTO doctorVerifiableData = doctorService.addDataVerifiable(doctorVerifiableDTO);
        return  new ResponseEntity<>(doctorVerifiableData,HttpStatus.OK);

        

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
