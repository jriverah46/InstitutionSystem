package com.authentication_microservice.Models;

import java.util.UUID;

public class GradeDto {
    private UUID id;
    private UUID idStudent;
    private UUID idCourse;

    private Double grade1;
    private Double grade2;
    private Double grade3;

    private Double finalGrade;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Double finalGrade) {
        this.finalGrade = finalGrade;
    }
}
