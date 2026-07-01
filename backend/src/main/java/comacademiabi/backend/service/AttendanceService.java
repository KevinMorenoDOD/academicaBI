package comacademiabi.backend.service;

import comacademiabi.backend.model.Attendance;
import comacademiabi.backend.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance createAttendance(Attendance attendance) {
        Attendance saved = attendanceRepository.save(attendance);
        return saved;
    }

    public Attendance getAttendanceById(int id) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new RuntimeException("attendance not found by id: " + id));
        return attendance;
    }

    public Attendance updateAttendance(Attendance attendance) {
        Attendance attendanceUpdated = attendanceRepository.findById(attendance.getId()).orElseThrow(() -> new RuntimeException("attendance not found by id: " + attendance.getId()));

        attendanceUpdated.setClass_date(attendance.getClass_date());
        attendanceUpdated.setPresent(attendance.getPresent());
        Attendance saved = attendanceRepository.save(attendanceUpdated);

        return saved;
    }
}
