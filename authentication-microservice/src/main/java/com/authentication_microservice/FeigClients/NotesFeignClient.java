package com.authentication_microservice.FeigClients;

import com.authentication_microservice.Models.GradeDto;
import com.authentication_microservice.Models.SaveGradeRequesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notes-microservice",url = "http://localhost:8003")
public interface NotesFeignClient {
    @PostMapping("grades/save")
    public GradeDto saveGrade(@RequestBody SaveGradeRequesDto saveGradeRequesDto);
}
