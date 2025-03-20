package com.authentication_microservice.Persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String email;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
    public UserEntity(String email, String name, String password, UserType userType) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }
}
