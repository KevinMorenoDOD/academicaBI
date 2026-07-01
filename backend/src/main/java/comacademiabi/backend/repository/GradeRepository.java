package comacademiabi.backend.repository;

import comacademiabi.backend.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    List<Grade> findByEnrollment_Id(Integer enrollmentId);
    List<Grade> findByEnrollment_IdOrderByPartialNumberAsc(Integer enrollmentId);
}
