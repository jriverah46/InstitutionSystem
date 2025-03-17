package com.notes_microservice.models;

import java.util.UUID;

public class SaveGradesRequesDto {
    private UUID idStudent;
    private UUID idCourse;

    private Double grade1;
    private Double grade2;
    private Double grade3;

    public UUID getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(UUID idStudent) {
        this.idStudent = idStudent;
    }

    public UUID getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(UUID idCourse) {
        this.idCourse = idCourse;
    }

    public Double getGrade1() {
        return grade1;
    }

    public void setGrade1(Double grade1) {
        this.grade1 = grade1;
    }

    public Double getGrade2() {
        return grade2;
    }

    public void setGrade2(Double grade2) {
        this.grade2 = grade2;
    }

    public Double getGrade3() {
        return grade3;
    }

    public void setGrade3(Double grade3) {
        this.grade3 = grade3;
    }
}
