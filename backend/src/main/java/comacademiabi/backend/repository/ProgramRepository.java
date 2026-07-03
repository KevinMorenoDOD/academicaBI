package comacademiabi.backend.repository;

import comacademiabi.backend.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program,Integer>{
    List<Program> findByAvailableTrue();
    List<Program> findByAvailableFalse();
    Optional<Program> findByName(String name);
    List<Program> findByFaculty(String faculty);
}
