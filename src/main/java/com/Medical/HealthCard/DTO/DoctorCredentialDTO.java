package com.Medical.HealthCard.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public  class DoctorCredentialDTO {





    @NotNull(message = "Doctor Name is Null")
    @NotEmpty(message = "Doctor Name is Empty")
    private String doctorName;
    @NotNull(message = "User Name is Null")
    @NotEmpty(message = "User Name is Empty")
    private String userName;
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
    @NotNull(message = "Password is Null")
    @NotEmpty(message = "Password is Empty")
    private String password;
    //private boolean validDoctor;
    @NotBlank(message = "Doctor register Key is blank")
    @NotNull(message = "Doctor is null")
    @Max(value = 30)
    private String doctorRegKey;
    //verification Credential to be part

}
