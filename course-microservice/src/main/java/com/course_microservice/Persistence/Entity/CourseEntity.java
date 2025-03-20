package com.course_microservice.Persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "course_name")
    private String courseName;
    @Embedded
    private Schedule schedule;
    private UUID idTeacher;
    private String teacherName;

    public CourseEntity(String courseName, Schedule schedule, UUID idTeacher, String teacherName) {
        this.courseName = courseName;
        this.schedule = schedule;
        this.idTeacher = idTeacher;
        this.teacherName = teacherName;
    }

    public CourseEntity(String courseName, Schedule schedule) {
        this.courseName = courseName;
        this.schedule = schedule;
    }
}
