package comacademiabi.backend.controller;

import comacademiabi.backend.model.Grade;
import comacademiabi.backend.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/id/{gradeId}")
    public ResponseEntity<Grade> getGradeById(@PathVariable int gradeId) {
        return ResponseEntity.ok(gradeService.getGradeById(gradeId));
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade created = gradeService.createGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.updateGrade(grade));
    }
}
