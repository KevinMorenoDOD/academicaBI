package comacademiabi.backend.repository;

import comacademiabi.backend.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Integer> {

    List<Section> findByCourse_Id(Integer courseId);
    List<Section> findByPeriod_Id(Integer periodId);
    List<Section> findByProfessor_Id(Integer professorId);
    List<Section> findByCourse_IdAndPeriod_Id(Integer courseId, Integer periodId);
}
