package com.Medical.HealthCard.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;

    @OneToOne(mappedBy = "userCredential")
    DoctorEntity doctorEntity;



}
