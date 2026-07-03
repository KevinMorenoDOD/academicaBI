package comacademiabi.backend.controller;

import comacademiabi.backend.model.Student;
import comacademiabi.backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/id/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/code/{studentCode}")
    public ResponseEntity<Student> getStudentByStudentCode(@PathVariable String studentCode) {
        return ResponseEntity.ok(studentService.getStudentByStudentCode(studentCode));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student created = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @PatchMapping("/dropout/{studentId}")
    public ResponseEntity<Student> dropoutStudent(@PathVariable int studentId) {
        return ResponseEntity.ok(studentService.dropoutStudent(studentId));
    }
}
