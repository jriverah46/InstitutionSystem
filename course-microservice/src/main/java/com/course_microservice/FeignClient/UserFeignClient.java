package com.course_microservice.FeignClient;

import com.course_microservice.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;
@FeignClient(name = "authentication-microservice")
public interface UserFeignClient {
    @GetMapping("/teacher/{id}")
    User getTeacherById(@PathVariable("id") UUID id);


    @PostMapping("/teacher/save")
    User saveTeacher(@RequestBody User user);
}
