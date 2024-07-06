package com.Medical.HealthCard.DTO;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {


    private String patientName;
    private String patientMail;
    private String patientContact;
    private String patientHCID;

    //private ArrayList<HeathCardDetailsEntity> listOfHealthCardDetails=new ArrayList<HeathCardDetailsEntity>();



}
