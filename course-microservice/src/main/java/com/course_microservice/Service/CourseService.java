package com.course_microservice.Service;

import com.course_microservice.FeignClient.UserFeignClient;
import com.course_microservice.Persistence.Entity.CourseEntity;
import com.course_microservice.Persistence.Repository.CourseRepository;
import com.course_microservice.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    // lIST OF COURSES

    public List<CourseEntity>getAllCourses(){
        List<CourseEntity>courses=courseRepository.findAll();
        return courses;
    }
    //get course by id
    public CourseEntity getCourseById(UUID idCourse){
        CourseEntity course=courseRepository.findCourseById(idCourse);
        return course;
    }
    //get course by course name
    public CourseEntity getCourseByCoursename(String courseName){
        CourseEntity course=courseRepository.findCourseByCourseName(courseName);
        return course;
    }

    //making a list of courses
    public List<CourseEntity>getListSelectedCourses(List<String>courseNames){
        List<CourseEntity>courses=new ArrayList<>();
        for (String coursename : courseNames) {
            CourseEntity course = getCourseByCoursename(coursename);
            if (course!=null) {
                courses.add(course);
            }
        }

        return courses;
    }

    //assign a teacher to the course
    public CourseEntity assignTeacher(UUID courseId, Teacher teacher){
        CourseEntity course=courseRepository.findCourseById(courseId);
        course.setIdTeacher(userFeignClient.getTeacherById(teacher.getId()).getId());
        course.setTeacherName(userFeignClient.getTeacherById(teacher.getId()).getName());
        return course;
    }

    //create course with teacher
    public CourseEntity createCourseWithTeacher(CourseEntity course,Teacher teacher){
        Teacher newTeacher= userFeignClient.saveTeacher(teacher);
        course.setIdTeacher(newTeacher.getId());
        course.setTeacherName(newTeacher.getName());

        return saveCourse(course);

    }


}
