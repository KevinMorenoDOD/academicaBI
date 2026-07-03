package comacademiabi.backend.controller;

import comacademiabi.backend.model.Attendance;
import comacademiabi.backend.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }

    @GetMapping("/id/{attendanceId}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable int attendanceId) {
        return ResponseEntity.ok(attendanceService.getAttendanceById(attendanceId));
    }

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance created = attendanceService.createAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        return ResponseEntity.ok(attendanceService.updateAttendance(attendance));
    }
}
