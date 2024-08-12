package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.ShopkeeperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopkeeperRepo extends JpaRepository<ShopkeeperEntity,String> {
}
