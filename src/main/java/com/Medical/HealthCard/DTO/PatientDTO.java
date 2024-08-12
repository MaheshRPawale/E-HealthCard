package com.Medical.HealthCard.DTO;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class PatientDTO {

    @NotBlank(message = "Patient is blank")
    @NotNull(message = "Patient is null")
    private String patientName;
    @NotBlank(message = "Patient's mail is blank")
    private String patientMail;
    @NotBlank(message = "Patient's conntact is blank")
    private String patientContact;

    private String patientHCID;

    //private ArrayList<HeathCardDetailsEntity> listOfHealthCardDetails=new ArrayList<HeathCardDetailsEntity>();



}
