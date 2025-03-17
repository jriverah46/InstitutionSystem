package com.authentication_microservice.FeigClients;

import com.authentication_microservice.Models.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "course-microservice",url = "http://localhost:8002")
public interface CoursesFeignClient {
    @PostMapping("/courses/selected")
    public List<CourseDto> listSelectedCourses(@RequestBody List<String> courseNames);
}
