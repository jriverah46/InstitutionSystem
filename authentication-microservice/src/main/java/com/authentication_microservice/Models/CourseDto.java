package com.authentication_microservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

public class CourseDto {
    private UUID id;
    private String courseName;
    @Embedded
    private Schedule schedule;
    private UUID idTeacher;
    private String teacherName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public UUID getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(UUID idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
