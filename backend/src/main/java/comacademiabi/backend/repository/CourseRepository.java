package comacademiabi.backend.repository;

import comacademiabi.backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer>{
    List<Course> findByAvailableTrue();
    List<Course> findByAvailableFalse();
    Optional<Course> findByCode(String code);
    List<Course> findByProgram_Id(Integer id);
    List<Course> findByProgram_IdAndAvailableTrue(Integer id);
}
