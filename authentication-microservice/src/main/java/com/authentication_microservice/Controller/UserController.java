package com.authentication_microservice.Controller;

import com.authentication_microservice.Persistence.Entity.UserEntity;
import com.authentication_microservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserEntity>getTeacher(@PathVariable UUID id){
        UserEntity teacher=userService.getTeacher(id);
        if (teacher==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacher);
    }


}
