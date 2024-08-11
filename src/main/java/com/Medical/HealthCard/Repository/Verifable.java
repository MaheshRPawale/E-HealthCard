package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.DoctorValidateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Verifable extends JpaRepository<DoctorValidateInfo,String> {

    public DoctorValidateInfo findByRegKey(String regKey);


}
