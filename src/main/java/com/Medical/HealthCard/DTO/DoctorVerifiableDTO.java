package com.Medical.HealthCard.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorVerifiableDTO {

    //private String validationId;
    @NotNull(message = "Doctor Name is null")
    private String doctorName;
    @NotNull(message = "Registration key is null")
    private String regKey;

    

}
