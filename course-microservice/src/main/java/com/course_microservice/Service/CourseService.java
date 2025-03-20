package com.course_microservice.Service;

import com.course_microservice.FeignClient.UserFeignClient;
import com.course_microservice.Persistence.Entity.CourseEntity;
import com.course_microservice.Persistence.Repository.CourseRepository;
import com.course_microservice.models.User;
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
    public CourseEntity assignTeacher(UUID courseId, UUID teacherId){
        CourseEntity course=courseRepository.findCourseById(courseId);
        User user =userFeignClient.getTeacherById(teacherId);
        course.setIdTeacher(user.getId());
        course.setTeacherName(user.getName());

        return courseRepository.save(course);
    }

    //create course with new teacher
    public CourseEntity createCourseWithNewTeacher(CourseEntity course, User user){
        User newUserEntity = userFeignClient.saveTeacher(user);
        course.setIdTeacher(newUserEntity.getId());
        course.setTeacherName(newUserEntity.getName());

        return saveCourse(course);

    }

    public CourseEntity createCourseWithTeacher(CourseEntity course,UUID idTeacher){
        User teacher =userFeignClient.getTeacherById(idTeacher);
        course.setIdTeacher(teacher.getId());
        course.setTeacherName(teacher.getName());
        CourseEntity newCourse= courseRepository.save(course);
        return saveCourse(newCourse);

    }

    public User getTeacher(UUID id){
        User userEntity =userFeignClient.getTeacherById(id);
        return userEntity;
    }


}
