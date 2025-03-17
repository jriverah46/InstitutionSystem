package com.notes_microservice.Persistence.Repository;

import com.notes_microservice.Persistence.Entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GradeRespository extends JpaRepository<GradeEntity, UUID> {
    List<GradeEntity> findAllGradeByIdStudent(UUID idStudent);
}
