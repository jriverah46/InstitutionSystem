package com.authentication_microservice.Persistence.Repository;

import com.authentication_microservice.Persistence.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
UserEntity findUserById(UUID userId);

}
