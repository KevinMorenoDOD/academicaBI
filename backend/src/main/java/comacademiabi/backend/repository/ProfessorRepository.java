package comacademiabi.backend.repository;

import comacademiabi.backend.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findByEmail(String email);

    List<Professor> findByDepartment(String department);

    List<Professor> findByAvailableTrue();
}
