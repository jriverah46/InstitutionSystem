package com.enrollment_microservice.Service;

import com.enrollment_microservice.Persistence.Entity.EnrollmentEntity;
import com.enrollment_microservice.Persistence.Repository.EnrollmentRepository;
import com.enrollment_microservice.models.CourseDto;
import com.enrollment_microservice.models.EnrollmentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    public EnrollmentEntity enroll(EnrollmentRequestDto enrollmentRequestDto){
        EnrollmentEntity enrollmentEntity=new EnrollmentEntity();
        enrollmentEntity.setStudentId(enrollmentRequestDto.getIdStudent());
        enrollmentEntity.setCourses(enrollmentRequestDto.getCourses());

        enrollmentEntity=enrollmentRepository.save(enrollmentEntity);

       return enrollmentEntity;

    }

    public Boolean isEnroll(UUID idStudent, UUID idCourse){
        EnrollmentEntity enrollment=enrollmentRepository.findByStudentId(idStudent);
        List<CourseDto> courses=enrollment.getCourses();
        for (CourseDto course:courses) {
            if (course.getId().equals(idCourse)){
                return true;
            }
        }
        return false;
    }

    public EnrollmentEntity getEnrollmentByIdStudent(UUID idStudent){
        EnrollmentEntity enrollment=enrollmentRepository.findByStudentId(idStudent);
        return  enrollment;
    }
}
