package comacademiabi.backend.repository;

import comacademiabi.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByStudentCode(String studentCode);
    Optional<Student> findByEmail(String email);
    List<Student> findByProgram_Id(Integer programId);
    List<Student> findByStatus(String status);
}
