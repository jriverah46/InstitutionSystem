package com.course_microservice.Persistence.Repository;

import com.course_microservice.Persistence.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    CourseEntity findCourseById(UUID id);
    CourseEntity findCourseByCourseName(String courseName);


}
