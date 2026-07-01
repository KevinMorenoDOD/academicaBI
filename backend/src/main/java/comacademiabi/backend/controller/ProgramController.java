package comacademiabi.backend.controller;

import comacademiabi.backend.model.Program;
import comacademiabi.backend.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {


    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public ResponseEntity<List<Program>> getAllPrograms() {
        return ResponseEntity.ok(programService.getAllPrograms());
    }

    @GetMapping("/id/{programId}")
    public ResponseEntity<Program> getProgramById(@PathVariable int programId) {
        return ResponseEntity.ok(programService.getProgramById(programId));
    }

    @GetMapping("/name/{programName}")
    public ResponseEntity<Program> getProgramByName(@PathVariable String programName) {
        return ResponseEntity.ok(programService.getProgramByName(programName));
    }

    @PostMapping
    public ResponseEntity<Program> createProgram(@RequestBody Program program){
        Program created = programService.createProgram(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Program> updateProgram(@RequestBody Program program){
        return ResponseEntity.ok(programService.updateProgram(program));
    }

    @PatchMapping("/unavailable/{programId}")
    public ResponseEntity<Program> unavalableProgram(@PathVariable int programId){
        return ResponseEntity.ok(programService.unavailableProgram(programId));
    }
}
