package com.Medical.HealthCard.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ShopKeeperDetails")
public class ShopkeeperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shopkeeperId;
    @Column(length = 200,name = "shopkeeper Name")
    private String shopkeeperName;
    private String shopName;

}
