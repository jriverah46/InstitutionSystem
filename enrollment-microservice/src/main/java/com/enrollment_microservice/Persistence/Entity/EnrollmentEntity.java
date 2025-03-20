package com.enrollment_microservice.Persistence.Entity;

import com.enrollment_microservice.models.CourseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnrollmentEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID studentId;
    @ElementCollection
    private List<CourseDto> courses;

    public EnrollmentEntity(UUID studentId, List<CourseDto> courses) {
        this.studentId = studentId;
        this.courses = courses;
    }
}
