package comacademiabi.backend.repository;

import comacademiabi.backend.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodRepository extends JpaRepository<Period,Integer>{
    List<Period> findByActiveTrue();
    List<Period> findByActiveFalse();
}
