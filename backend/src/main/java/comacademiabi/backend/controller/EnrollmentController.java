package comacademiabi.backend.controller;

import comacademiabi.backend.model.Enrollment;
import comacademiabi.backend.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/id/{enrollmentId}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable int enrollmentId) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(enrollmentId));
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment created = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Enrollment> updateEnrollment(@RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(enrollment));
    }

    @PatchMapping("/withdraw/{enrollmentId}")
    public ResponseEntity<Enrollment> withdrawEnrollment(@PathVariable int enrollmentId) {
        return ResponseEntity.ok(enrollmentService.withdrawEnrollment(enrollmentId));
    }
}
