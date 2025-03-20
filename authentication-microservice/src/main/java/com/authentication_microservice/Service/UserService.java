package com.authentication_microservice.Service;

import com.authentication_microservice.FeigClients.CoursesFeignClient;
import com.authentication_microservice.FeigClients.EnrollmentFeignClient;
import com.authentication_microservice.FeigClients.NotesFeignClient;
import com.authentication_microservice.Models.*;

import com.authentication_microservice.Persistence.Entity.UserEntity;
import com.authentication_microservice.Persistence.Entity.UserType;
import com.authentication_microservice.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CoursesFeignClient coursesFeignClient;
    @Autowired
    private EnrollmentFeignClient enrollmentFeignClient;
    @Autowired
    private NotesFeignClient notesFeignClient;

    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);

    }

    public UserEntity getByUserId(UUID userId){
        UserEntity userEntity=userRepository.findUserById(userId);
        return userEntity;
    }

    //getting teacher by id
    public UserEntity getTeacher(UUID userId){
        UserEntity teacher=userRepository.findUserById(userId);

        if (teacher.getUserType().equals(UserType.teacher)){
            return teacher;
        }
        else {
            throw new IllegalArgumentException("the user is not a teacher");
        }
    }
    //saving teacher
    public UserEntity saveTeacher(UserEntity teacher){
        if (teacher.getUserType().equals(UserType.teacher)){
            UserEntity newTeacher= userRepository.save(teacher);
            return newTeacher;}
        else {
            throw new IllegalArgumentException("the user is not a teacher");
        }
    }

    //save student

    public UserEntity saveStudent(UserEntity userEntity) {
        if (userEntity.getUserType().equals(UserType.student)) {
            UserEntity student = userRepository.save(userEntity);
            return student;
        }
        else {
            throw new IllegalArgumentException("the user is not a teacher");
        }
    }

    //enrolling student in courses
    public EnrollmentDto enrollStudentToCourses(UUID idStudent, List<String>courseNames){
        List<CourseDto>courses=coursesFeignClient.listSelectedCourses(courseNames);

        EnrollmentRequestDto enrollmentRequestDto=new EnrollmentRequestDto();
        enrollmentRequestDto.setIdStudent(idStudent);
        enrollmentRequestDto.setCourses(courses);

        EnrollmentDto enroll=enrollmentFeignClient.enroll(enrollmentRequestDto);
        return enroll;

    }

    //searching the student enrollment by his id
    public EnrollmentDto enrollmentByStudent(UUID idStudent){
        EnrollmentDto enrollment= enrollmentFeignClient.enrollmentByStudent(idStudent);
        return enrollment;
    }

    //saving notes from user
    public GradeDto saveGrades(SaveGradeRequesDto saveGradeRequesDto){
        if (!userRepository.findUserById(saveGradeRequesDto.getIdStudent()).getUserType().equals(UserType.teacher)){
            throw new IllegalArgumentException("ONLY TEACHER CAN PUT NOTES");
        }
        GradeDto gradeDto=notesFeignClient.saveGrade(saveGradeRequesDto);
        return gradeDto;
    }


}