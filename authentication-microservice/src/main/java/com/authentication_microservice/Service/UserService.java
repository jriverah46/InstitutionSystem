package com.authentication_microservice.Service;

import com.authentication_microservice.Persistence.Entity.UserEntity;
import com.authentication_microservice.Persistence.Entity.UserType;
import com.authentication_microservice.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getByUserId(UUID userId){
        UserEntity userEntity=userRepository.findUserById(userId);
        return userEntity;
    }

    //getting teacher by id
    public UserEntity getTeacher(UUID userId){
        UserEntity userEntity=userRepository.findUserById(userId);
        if (userEntity.getUserType().equals(UserType.teacher)){
            return userEntity;
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
}