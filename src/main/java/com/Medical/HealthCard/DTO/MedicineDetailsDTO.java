package com.Medical.HealthCard.DTO;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDetailsDTO {

    private String medicineName;
    private int quantity;
    private boolean morningYN;
    private String morningRemark;
    private boolean afternYN;
    private String afternRemark;
    private boolean nightYN;
    private String nightRemark;
    //private HealthCardDetailsDTO heathCardDetails;

}
