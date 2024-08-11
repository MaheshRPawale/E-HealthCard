package com.Medical.HealthCard.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Doctor_verify_Info")
public class DoctorValidateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String validationId;
    private String doctorName;
    @Column(unique = true)
    private String regKey;


}
