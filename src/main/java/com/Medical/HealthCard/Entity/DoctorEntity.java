package com.Medical.HealthCard.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Doctor_Details")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String doctorId;
    @Column(length = 200,name = "doctor_Name")
    private String doctorName;
    private String qualification;
    private String specification;
    private String hospitalId;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalContactNumber;
    private boolean isValidDoctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userCredentialId")
    UserCredential userCredential;
    //verification Credential to be part







}
