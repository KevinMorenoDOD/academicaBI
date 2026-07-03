package comacademiabi.backend.service;

import comacademiabi.backend.model.Enrollment;
import comacademiabi.backend.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        Enrollment saved = enrollmentRepository.save(enrollment);
        return saved;
    }

    public Enrollment getEnrollmentById(int id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("enrollment not found by id: " + id));
        return enrollment;
    }

    public Enrollment updateEnrollment(Enrollment enrollment) {
        Enrollment enrollmentUpdated = enrollmentRepository.findById(enrollment.getId()).orElseThrow(() -> new RuntimeException("enrollment not found by id: " + enrollment.getId()));

        enrollmentUpdated.setFinalGrade(enrollment.getFinalGrade());
        enrollmentUpdated.setStatus(enrollment.getStatus());
        Enrollment saved = enrollmentRepository.save(enrollmentUpdated);

        return saved;
    }

    public Enrollment withdrawEnrollment(int id) {
        Enrollment enrollmentUpdated = enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("enrollment not found by id: " + id));

        enrollmentUpdated.setStatus("withdrawn");
        Enrollment saved = enrollmentRepository.save(enrollmentUpdated);

        return saved;
    }
}
