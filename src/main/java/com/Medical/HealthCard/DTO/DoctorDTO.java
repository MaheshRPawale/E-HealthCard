package com.Medical.HealthCard.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDTO {


    private String doctorName;
    private String qualification;
    private String specification;
    private String hospitalId;
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalContactNumber;
    private boolean validDoctor;

    //verification Credential to be part



}
