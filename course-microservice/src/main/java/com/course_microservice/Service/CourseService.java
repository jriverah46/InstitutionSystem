package com.course_microservice.Service;

import com.course_microservice.FeignClient.UserFeignClient;
import com.course_microservice.Persistence.Entity.CourseEntity;
import com.course_microservice.Persistence.Repository.CourseRepository;
import models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private UserFeignClient userFeignClient;
    @Autowired
    public CourseService(CourseRepository courseRepository, UserFeignClient userFeignClient) {
        this.courseRepository = courseRepository;
        this.userFeignClient = userFeignClient;
    }

    public CourseEntity saveCourse(CourseEntity course){
        CourseEntity newCourse= courseRepository.save(course);
        return newCourse;
    }

    //assign a teacher to the course
    public CourseEntity assignTeacher(UUID courseId, Teacher teacher){
        CourseEntity course=courseRepository.findCourseById(courseId);
        course.setIdTeacher(userFeignClient.getTeacherById(teacher.getId()).getId());
        return course;
    }

    //create course with teacher
    public CourseEntity createCourseWithTeacher(CourseEntity course,Teacher teacher){
        Teacher newTeacher= userFeignClient.saveTeacher(teacher);
        course.setIdTeacher(newTeacher.getId());

        return saveCourse(course);

    }


}
