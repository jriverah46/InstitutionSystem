package com.course_microservice.Controller;

import com.course_microservice.Persistence.Entity.CourseEntity;
import com.course_microservice.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/all")
    public ResponseEntity<List<CourseEntity>>listAllCourses(){
        List<CourseEntity>courses=courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    @PostMapping("/save-course")
    public ResponseEntity<CourseEntity>saveCourse(@RequestBody CourseEntity course){
        CourseEntity newCourse=courseService.saveCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @PostMapping("/selected")
    public ResponseEntity<List<CourseEntity>> getSelectedCourses(@RequestBody List<String> courseNames) {
        List<CourseEntity> courses = courseService.getListSelectedCourses(courseNames);
        return ResponseEntity.ok(courses);
    }

}
