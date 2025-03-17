package com.authentication_microservice.Models;

import java.util.List;
import java.util.UUID;

public class EnrollmentRequestDto {
    private UUID idStudent;
    private List<CourseDto> courses;

    public UUID getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(UUID idStudent) {
        this.idStudent = idStudent;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
