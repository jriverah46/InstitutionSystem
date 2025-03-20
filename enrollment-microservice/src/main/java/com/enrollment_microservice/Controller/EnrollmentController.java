package com.enrollment_microservice.Controller;

import com.enrollment_microservice.Persistence.Entity.EnrollmentEntity;
import com.enrollment_microservice.Service.EnrollmentService;
import com.enrollment_microservice.models.CourseDto;
import com.enrollment_microservice.models.EnrollmentRequestDto;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @PostMapping("/enroll")
    public ResponseEntity<EnrollmentEntity>enroll(@RequestBody EnrollmentRequestDto enrollmentRequestDto ){
        EnrollmentEntity enrollment=enrollmentService.enroll(enrollmentRequestDto);
        return ResponseEntity.ok(enrollment);
    }
    @GetMapping("/is-enrolled")
    public ResponseEntity<Boolean>isEnrolled(@RequestParam UUID idStudent,@RequestParam UUID idCourse){
        return ResponseEntity.ok(enrollmentService.isEnroll(idStudent,idCourse));
    }

    @PostMapping("/student-enrollment")
    public ResponseEntity<EnrollmentEntity>enollmentByStudent(@RequestBody UUID idStudent){
        return ResponseEntity.ok(enrollmentService.getEnrollmentByIdStudent(idStudent));
    }
}
