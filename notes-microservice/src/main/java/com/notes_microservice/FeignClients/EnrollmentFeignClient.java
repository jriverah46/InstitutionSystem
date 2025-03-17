package com.notes_microservice.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "enrollment-microservice",url = "http://localhost:8004")
public interface EnrollmentFeignClient {
    @GetMapping("/enrollment/is-enrolled")
    boolean isEnrolled(@RequestParam UUID idStudent, @RequestParam UUID idCourse);
}
