package comacademiabi.backend.service;

import comacademiabi.backend.exception.ResourceNotFoundException;
import comacademiabi.backend.model.Program;
import comacademiabi.backend.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public Program createProgram(Program program) {
        Program saved = programRepository.save(program);
        return saved;
    }

    public List<Program> getAllPrograms() {
        List<Program> program = programRepository.findAll();
        return program;
    }

    public Program getProgramById(int id) {
        Program program = programRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("program not found by id: " + id));
        return program;
    }

    public Program getProgramByName(String programName) {
        Program program = programRepository.findByName(programName).orElseThrow(() -> new ResourceNotFoundException("program not found by program name: " + programName));
        return program;
    }

    public Program updateProgram(Program program) {
        Program programUpdated = programRepository.findById(program.getId()).orElseThrow(() -> new ResourceNotFoundException("program not found by id: " + program.getId()));

        programUpdated.setName(program.getName());
        programUpdated.setFaculty(program.getFaculty());
        Program saved = programRepository.save(programUpdated);

        return saved;
    }

    public Program unavailableProgram(int id) {
        Program programUpdated = programRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("program not found by id: " + id));

        programUpdated.setAvailable(false);
        Program saved = programRepository.save(programUpdated);

        return saved;
    }
}
