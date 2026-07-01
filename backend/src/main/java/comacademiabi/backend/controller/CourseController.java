package comacademiabi.backend.controller;

import comacademiabi.backend.model.Course;
import comacademiabi.backend.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/id/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable int courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<Course> getCourseByCode(@PathVariable String code) {
        return ResponseEntity.ok(courseService.getCourseByCode(code));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course created = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

    @PatchMapping("/unavailable/{courseId}")
    public ResponseEntity<Course> unavailableCourse(@PathVariable int courseId) {
        return ResponseEntity.ok(courseService.unavailableCourse(courseId));
    }
}
