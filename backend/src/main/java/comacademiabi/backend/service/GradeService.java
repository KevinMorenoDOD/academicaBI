package comacademiabi.backend.service;

import comacademiabi.backend.model.Grade;
import comacademiabi.backend.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade createGrade(Grade grade) {
        Grade saved = gradeRepository.save(grade);
        return saved;
    }

    public Grade getGradeById(int id) {
        Grade grade = gradeRepository.findById(id).orElseThrow(() -> new RuntimeException("grade not found by id: " + id));
        return grade;
    }

    public Grade updateGrade(Grade grade) {
        Grade gradeUpdated = gradeRepository.findById(grade.getId()).orElseThrow(() -> new RuntimeException("grade not found by id: " + grade.getId()));

        gradeUpdated.setPartialNumber(grade.getPartialNumber());
        gradeUpdated.setScore(grade.getScore());
        Grade saved = gradeRepository.save(gradeUpdated);

        return saved;
    }
}
