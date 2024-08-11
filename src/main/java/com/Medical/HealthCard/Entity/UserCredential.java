package com.Medical.HealthCard.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredential {

    @Id
    private String userId;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String password;

    @OneToOne(mappedBy = "userCredential")
    DoctorEntity doctorEntity;



}
