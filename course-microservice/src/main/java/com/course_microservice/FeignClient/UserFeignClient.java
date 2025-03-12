package com.course_microservice.FeignClient;

import models.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;
@FeignClient(name = "authentication-microservice", url = "http://localhost:8081")
public interface UserFeignClient {
    @GetMapping("/user/teacher/{id}")
    Teacher getTeacherById(@PathVariable("id") UUID id);

    @PostMapping("/teacher/save")
    Teacher saveTeacher(@RequestBody Teacher teacher);
}
