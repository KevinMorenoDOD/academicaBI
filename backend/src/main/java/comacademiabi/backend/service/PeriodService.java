package comacademiabi.backend.service;

import comacademiabi.backend.model.Period;
import comacademiabi.backend.repository.PeriodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {

    private final PeriodRepository periodRepository;

    public PeriodService(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    public List<Period> getAllPeriods() {
        return periodRepository.findAll();
    }

    public Period createPeriod(Period period) {
        Period saved = periodRepository.save(period);
        return saved;
    }

    public Period getPeriodById(int id) {
        Period period = periodRepository.findById(id).orElseThrow(() -> new RuntimeException("period not found by id: " + id));
        return period;
    }

    public Period updatePeriod(Period period) {
        Period periodUpdated = periodRepository.findById(period.getId()).orElseThrow(() -> new RuntimeException("period not found by id: " + period.getId()));

        periodUpdated.setCode(period.getCode());
        periodUpdated.setStartDate(period.getStartDate());
        periodUpdated.setEndDate(period.getEndDate());
        Period saved = periodRepository.save(periodUpdated);

        return saved;
    }

    public Period unavailablePeriod(int id) {
        Period periodUpdated = periodRepository.findById(id).orElseThrow(() -> new RuntimeException("period not found by id: " + id));

        periodUpdated.setActive(false);
        Period saved = periodRepository.save(periodUpdated);

        return saved;
    }
}
