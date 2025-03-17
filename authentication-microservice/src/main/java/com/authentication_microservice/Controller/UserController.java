package com.authentication_microservice.Controller;

import com.authentication_microservice.Models.EnrollmentDto;
import com.authentication_microservice.Models.EnrollmentRequestDto;
import com.authentication_microservice.Models.GradeDto;
import com.authentication_microservice.Models.SaveGradeRequesDto;
import com.authentication_microservice.Persistence.Entity.UserEntity;
import com.authentication_microservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity>getUserById(@PathVariable("id") UUID id){
        UserEntity user=userService.getByUserId(id);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("/teacher/{id}")
    public ResponseEntity<UserEntity>getTeacher(@PathVariable("id") UUID id){
        UserEntity teacher=userService.getTeacher(id);
        if (teacher==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacher);
    }
    //enrolling courses from user
    @PostMapping("/enroll-from-user/{idStudent}")
    public ResponseEntity<EnrollmentDto> enroll(@RequestBody List<String>courseNames,@PathVariable("idStudent") UUID idStudent){
       EnrollmentDto enrollmentDto= userService.enrollStudentToCourses(idStudent,courseNames);
       return  ResponseEntity.ok(enrollmentDto);
    }

    //saving notes from user
    @PostMapping("/grade/save")
    public ResponseEntity<GradeDto>saveGrades(@RequestBody SaveGradeRequesDto saveGradeRequesDto){
        GradeDto gradeDto= userService.saveGrades(saveGradeRequesDto);
        return ResponseEntity.ok(gradeDto);
    }


}
