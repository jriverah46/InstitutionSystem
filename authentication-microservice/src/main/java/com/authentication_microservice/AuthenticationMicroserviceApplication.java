package com.authentication_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {"com.authentication_microservice.Persistence.Entity", "org.example.userdtos"})
public class AuthenticationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationMicroserviceApplication.class, args);
	}

}
