package com.authentication_microservice.FeigClients;

import com.authentication_microservice.Models.EnrollmentDto;
import com.authentication_microservice.Models.EnrollmentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "enrollment-microservice",url = "http://localhost:8004")
public interface EnrollmentFeignClient {
    @PostMapping("/enrollment/enroll")
    public EnrollmentDto enroll(@RequestBody EnrollmentRequestDto enrollmentRequestDto);
}
