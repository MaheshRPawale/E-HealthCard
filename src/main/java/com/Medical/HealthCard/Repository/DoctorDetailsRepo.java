package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.DoctorEntity;
import com.Medical.HealthCard.Entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDetailsRepo extends JpaRepository<DoctorEntity,String>
{
  //public DoctorEntity findByUsername(String username);
  public DoctorEntity findByUserCredential(UserCredential userCredential);

}
