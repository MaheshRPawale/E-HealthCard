package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthCardDetailRepo extends JpaRepository<HeathCardDetailsEntity,String> {

    //HeathCardDetails findByDoctorId(String doctorId);
    //HeathCardDetail findByDate(Date Date)

    public List<HeathCardDetailsEntity> findAllByHealthCardId(String healthCardId);

    }
