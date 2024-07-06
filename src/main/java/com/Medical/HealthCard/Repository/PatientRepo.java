package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity,String> {

}
