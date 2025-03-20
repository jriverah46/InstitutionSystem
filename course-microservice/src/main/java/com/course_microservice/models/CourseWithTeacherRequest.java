package com.course_microservice.models;

import com.course_microservice.Persistence.Entity.CourseEntity;

import java.util.UUID;

public class CourseWithTeacherRequest {
    private CourseEntity course;
    private UUID teacherId;

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }
}
