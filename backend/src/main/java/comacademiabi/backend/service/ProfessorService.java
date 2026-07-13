package comacademiabi.backend.service;

import comacademiabi.backend.exception.ResourceNotFoundException;
import comacademiabi.backend.model.Professor;
import comacademiabi.backend.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor createProfessor(Professor professor) {
        Professor saved = professorRepository.save(professor);
        return saved;
    }

    public Professor getProfessorById(int id) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("professor not found by id: " + id));
        return professor;
    }

    public Professor getProfessorByEmail(String email) {
        Professor professor = professorRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("professor not found by email: " + email));
        return professor;
    }

    public Professor updateProfessor(Professor professor) {
        Professor professorUpdated = professorRepository.findById(professor.getId()).orElseThrow(() -> new ResourceNotFoundException("professor not found by id: " + professor.getId()));

        professorUpdated.setFullName(professor.getFullName());
        professorUpdated.setEmail(professor.getEmail());
        professorUpdated.setDepartment(professor.getDepartment());
        Professor saved = professorRepository.save(professorUpdated);

        return saved;
    }

    public Professor unavailableProfessor(int id) {
        Professor professorUpdated = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("professor not found by id: " + id));

        professorUpdated.setAvailable(false);
        Professor saved = professorRepository.save(professorUpdated);

        return saved;
    }
}
