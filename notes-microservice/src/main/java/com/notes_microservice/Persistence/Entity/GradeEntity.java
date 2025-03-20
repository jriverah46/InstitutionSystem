package com.notes_microservice.Persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID idStudent;
    private UUID idCourse;

    private Double grade1;
    private Double grade2;
    private Double grade3;

    private Double finalGrade;

    public GradeEntity(UUID idStudent, UUID idCourse, Double grade1, Double grade2, Double grade3, Double finalGrade) {
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.finalGrade = finalGrade;
    }
}
