package com.Medical.HealthCard.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public  class DoctorDTO {

    @NotNull(message = "Doctor Name is Null")
    @NotEmpty(message = "Doctor Name is Empty")
    private String doctorName;
    @NotEmpty(message = "Qualification is empty ")
    @NotBlank(message = "Qualification is blank")
    private String qualification;
    @NotEmpty(message = "Specification is empty")
    private String specification;
    private String hospitalId;
    @NotBlank(message = "hospital name is blank ")
    private String hospitalName;
    @NotBlank(message = "Hospital address is blank ")
    private String hospitalAddress;
    @NotBlank(message = "Hopital Contract Number is blank ")
    private String hospitalContactNumber;
    private boolean validDoctor;
    @NotBlank(message = "Doctor register Key is blank")
    @NotNull(message = "Doctor is null")
    private String doctorRegKey;
    //verification Credential to be part

}
