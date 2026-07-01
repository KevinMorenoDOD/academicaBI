package comacademiabi.backend.controller;

import comacademiabi.backend.model.Period;
import comacademiabi.backend.service.PeriodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {

    private final PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping
    public ResponseEntity<List<Period>> getAllPeriods() {
        return ResponseEntity.ok(periodService.getAllPeriods());
    }

    @GetMapping("/id/{periodId}")
    public ResponseEntity<Period> getPeriodById(@PathVariable int periodId) {
        return ResponseEntity.ok(periodService.getPeriodById(periodId));
    }

    @PostMapping
    public ResponseEntity<Period> createPeriod(@RequestBody Period period) {
        Period created = periodService.createPeriod(period);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Period> updatePeriod(@RequestBody Period period) {
        return ResponseEntity.ok(periodService.updatePeriod(period));
    }

    @PatchMapping("/unavailable/{periodId}")
    public ResponseEntity<Period> unavailablePeriod(@PathVariable int periodId) {
        return ResponseEntity.ok(periodService.unavailablePeriod(periodId));
    }
}
