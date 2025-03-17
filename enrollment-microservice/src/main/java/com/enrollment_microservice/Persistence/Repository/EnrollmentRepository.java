package com.enrollment_microservice.Persistence.Repository;

import com.enrollment_microservice.Persistence.Entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, UUID> {
    EnrollmentEntity findByStudentId(UUID studentId);
}
