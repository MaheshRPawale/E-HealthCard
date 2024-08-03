package com.Medical.HealthCard.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Patient_Details")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     private String patiendId;
    @Column(length = 200)
    private String patientName;
    @Column(length = 100)
    private String patientMail;
    @Column(length = 10)
    private String patientContact;
    @Column(name = "Patient_health_card_ID")
    private String patientHCID;
    //Relation
/*
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<HeathCardDetailsEntity> listOfHealthCardDetails=new ArrayList<HeathCardDetailsEntity>();
*/

}
