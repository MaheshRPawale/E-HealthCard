package com.Medical.HealthCard.Repository;

import com.Medical.HealthCard.Entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredential,String> {

    UserCredential findByUserName(String usernssame);

}
