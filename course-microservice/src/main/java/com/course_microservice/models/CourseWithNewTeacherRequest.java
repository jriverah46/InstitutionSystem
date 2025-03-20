package com.course_microservice.models;

import com.course_microservice.Persistence.Entity.CourseEntity;


public class CourseWithNewTeacherRequest {
    private CourseEntity course;
    private User user;

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
