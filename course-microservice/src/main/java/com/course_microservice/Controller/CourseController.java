package com.course_microservice.Controller;

import com.course_microservice.Persistence.Entity.CourseEntity;
import com.course_microservice.Service.CourseService;
import com.course_microservice.models.AssignTeacherRequest;
import com.course_microservice.models.CourseWithNewTeacherRequest;
import com.course_microservice.models.CourseWithTeacherRequest;
import com.course_microservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.UUID;

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

    // Endpoint para crear un curso con su profesor
    @PostMapping("/save/with-new-teacher")
    public ResponseEntity<CourseEntity> createCourseWithNewTeacher(@RequestBody CourseWithNewTeacherRequest request) {
        CourseEntity createdCourse = courseService.createCourseWithNewTeacher(request.getCourse(), request.getUser());
        return ResponseEntity.ok(createdCourse);
    }


    @PostMapping("/save/with-teacher")
    public ResponseEntity<CourseEntity> createCourseWithTeacher(@RequestBody CourseWithTeacherRequest request) {
        CourseEntity createdCourse = courseService.createCourseWithTeacher(request.getCourse(), request.getTeacherId());
        return ResponseEntity.ok(createdCourse);
    }
    //endpoint to assign a teacher

    @PostMapping("/assign-teacher")
    public ResponseEntity<CourseEntity>assignTeacher(@RequestBody AssignTeacherRequest assignTeacherRequest){
        CourseEntity course=courseService.assignTeacher(assignTeacherRequest.getIdCourse(),assignTeacherRequest.getIdTeacher());
        return ResponseEntity.ok(course);
    }
    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<User>getTeacher(@PathVariable("id") UUID id){
        User userEntity =courseService.getTeacher(id);
        return ResponseEntity.ok(userEntity);
    }

}
