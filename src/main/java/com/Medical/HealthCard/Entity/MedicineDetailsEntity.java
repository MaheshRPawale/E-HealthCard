package com.Medical.HealthCard.Entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Medicine_Details")
public class MedicineDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medicineId;
    @Column(length = 200)
    private String medicineName;
    private int quantity;
    private boolean morningYN;
    @Column(length = 100)
    private String morningRemark;
    private boolean afternYN;
    @Column(length = 100)
    private String afternRemark;
    private boolean nightYN;
    @Column(length = 100)
    private String nightRemark;

    //Relations
    @ManyToOne
    @JoinColumn(name = "HC_Details_ID")
    HeathCardDetailsEntity heathCardDetailsEntity;





}
