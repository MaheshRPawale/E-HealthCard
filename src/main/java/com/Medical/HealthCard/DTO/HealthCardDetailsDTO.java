package com.Medical.HealthCard.DTO;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import com.Medical.HealthCard.Entity.MedicineDetailsEntity;
import com.Medical.HealthCard.Entity.PatientEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HealthCardDetailsDTO {

    private String healthCardDetailsID;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;
    private String description;
    private String remark;
    private String allergy;
    //private String healthCardId;

    //Realations
    private ArrayList<MedicineDetailsDTO> medicineList;


   // private PatientEntity patientEntity;


}
