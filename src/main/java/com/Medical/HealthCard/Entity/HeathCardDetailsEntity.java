package com.Medical.HealthCard.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String healthCardDetailsID;
    @JsonFormat(pattern = "yyyy-mm-dd",shape = JsonFormat.Shape.STRING)
    private Date createdDate;
    @Column(length = 1000)
    private String description;
    @Column(length =500)
    private String remark;
    @Column(length =500)
    private String allergy;
    private String healthCardId;
    ///Relations
    @OneToMany(mappedBy = "heathCardDetailsEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<MedicineDetailsEntity> medicineList=new ArrayList<MedicineDetailsEntity>();






}
