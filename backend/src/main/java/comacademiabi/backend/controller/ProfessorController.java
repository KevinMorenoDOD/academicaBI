package comacademiabi.backend.controller;

import comacademiabi.backend.model.Professor;
import comacademiabi.backend.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @GetMapping("/id/{professorId}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable int professorId) {
        return ResponseEntity.ok(professorService.getProfessorById(professorId));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Professor> getProfessorByEmail(@PathVariable String email) {
        return ResponseEntity.ok(professorService.getProfessorByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor created = professorService.createProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.updateProfessor(professor));
    }

    @PatchMapping("/unavailable/{professorId}")
    public ResponseEntity<Professor> unavailableProfessor(@PathVariable int professorId) {
        return ResponseEntity.ok(professorService.unavailableProfessor(professorId));
    }
}
