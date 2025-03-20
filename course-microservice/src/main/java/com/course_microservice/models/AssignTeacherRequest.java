package com.course_microservice.models;

import java.util.UUID;

public class AssignTeacherRequest {
    private UUID idCourse;
    private UUID idTeacher;

    public UUID getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(UUID idCourse) {
        this.idCourse = idCourse;
    }

    public UUID getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(UUID idTeacher) {
        this.idTeacher = idTeacher;
    }
}
