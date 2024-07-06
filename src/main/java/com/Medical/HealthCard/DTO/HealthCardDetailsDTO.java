package com.Medical.HealthCard.DTO;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import com.Medical.HealthCard.Entity.MedicineDetailsEntity;
import com.Medical.HealthCard.Entity.PatientEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HealthCardDetailsDTO {


    private Date createdDate;
    private String description;
    private String remark;
    private String allergy;
    //private String healthCardId;

    //Realations
    private ArrayList<MedicineDetailsDTO> medicineList=new ArrayList<MedicineDetailsDTO>();


    private PatientEntity patientEntity;


}
