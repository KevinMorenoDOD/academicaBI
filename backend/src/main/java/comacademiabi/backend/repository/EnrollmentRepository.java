package comacademiabi.backend.repository;

import comacademiabi.backend.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findByStudent_Id(Integer studentId);
    List<Enrollment> findBySection_Id(Integer sectionId);
    Optional<Enrollment> findByStudent_IdAndSection_Id(Integer studentId, Integer sectionId);
    List<Enrollment> findByStatus(String status);
}
