package com.Medical.HealthCard.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Medicine_Details")
public class MedicineDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String medicineId;
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
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HC_Details_ID",referencedColumnName ="healthCardDetailsID")
    @JsonBackReference
    private HeathCardDetailsEntity heathCardDetailsEntity;


}
