package comacademiabi.backend.repository;

import comacademiabi.backend.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    List<Grade> findByEnrollment_Id(Integer enrollmentId);

    @Query("SELECT g FROM Grade g WHERE g.enrollment.id = :enrollmentId ORDER BY g.partialNumber ASC")
    List<Grade> findByEnrollment_IdOrderedByPartialNumberAsc(@Param("enrollmentId") Integer enrollmentId);
}
