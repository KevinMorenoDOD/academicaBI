package comacademiabi.backend.controller;

import comacademiabi.backend.model.Program;
import comacademiabi.backend.repository.ProgramRepository;
import comacademiabi.backend.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(programService.getProgramById())
    }

    @PostMapping
    public ResponseEntity<Program> createProgram(@RequestBody Program program){
        return ResponseEntity.ok(programService.createProgram(program));
    }


}
