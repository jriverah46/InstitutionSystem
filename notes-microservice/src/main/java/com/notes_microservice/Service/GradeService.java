package com.notes_microservice.Service;

import com.notes_microservice.FeignClients.EnrollmentFeignClient;
import com.notes_microservice.Persistence.Entity.GradeEntity;
import com.notes_microservice.Persistence.Repository.GradeRespository;
import com.notes_microservice.models.SaveGradesRequesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GradeService {
    @Autowired
    private GradeRespository gradeRespository;
    @Autowired
    private EnrollmentFeignClient enrollmentFeignClient;

    public GradeEntity saveGrades(SaveGradesRequesDto saveGradesRequesDto){
        if (enrollmentFeignClient.isEnrolled(saveGradesRequesDto.getIdStudent(),saveGradesRequesDto.getIdCourse())==false){
            throw new RuntimeException("the student is not in the course");
        }

        GradeEntity grades=new GradeEntity();
        grades.setIdStudent(saveGradesRequesDto.getIdStudent());
        grades.setIdCourse(saveGradesRequesDto.getIdCourse());
        grades.setGrade1(saveGradesRequesDto.getGrade1());
        grades.setGrade2(saveGradesRequesDto.getGrade2());
        grades.setGrade3(saveGradesRequesDto.getGrade3());

        grades.setFinalGrade((grades.getGrade1() + grades.getGrade2() + grades.getGrade3())/3);

        return gradeRespository.save(grades);
    }

    public List<GradeEntity> getGradesByIdStudent(UUID idStudent){
        List<GradeEntity> listgradeByIdStudent=gradeRespository.findAllGradeByIdStudent(idStudent);
        return listgradeByIdStudent;

    }
}
