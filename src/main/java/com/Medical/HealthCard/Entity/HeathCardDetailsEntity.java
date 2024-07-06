package com.Medical.HealthCard.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="HealthCard_Detauils")
public class HeathCardDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int healthCardDetailsID;
    private Date createdDate;
    @Column(length = 1000)
    private String description;
    @Column(length =500)
    private String remark;
    @Column(length =500)
    private String allergy;
    private String healthCardId;
    ///Relations
    @OneToMany(mappedBy = "heathCardDetailsEntity",cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    List<MedicineDetailsEntity> medicineList=new ArrayList<MedicineDetailsEntity>();

    @ManyToOne
    @JoinColumn(name = "patient_Id")
    private PatientEntity patientEntity;















}
