package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import com.Medical.HealthCard.Entity.MedicineDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineDetailsEntityRepo extends JpaRepository<MedicineDetailsEntity,Integer> {

/*
    @Query("Select * from medic")
    public List<MedicineDetailsEntity> findByHealthCardDetailId(int healthCardDetailsId);
*/

}
