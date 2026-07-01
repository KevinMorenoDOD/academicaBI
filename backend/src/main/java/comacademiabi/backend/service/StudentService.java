package comacademiabi.backend.service;

import comacademiabi.backend.model.Student;
import comacademiabi.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        Student saved = studentRepository.save(student);
        return saved;
    }

    public Student getStudentById(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found by id: " + id));
        return student;
    }

    public Student getStudentByStudentCode(String studentCode) {
        Student student = studentRepository.findByStudentCode(studentCode).orElseThrow(() -> new RuntimeException("student not found by student code: " + studentCode));
        return student;
    }

    public Student getStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("student not found by email: " + email));
        return student;
    }

    public Student updateStudent(Student student) {
        Student studentUpdated = studentRepository.findById(student.getId()).orElseThrow(() -> new RuntimeException("student not found by id: " + student.getId()));

        studentUpdated.setStudent_code(student.getStudent_code());
        studentUpdated.setFull_name(student.getFull_name());
        studentUpdated.setEmail(student.getEmail());
        studentUpdated.setProgram(student.getProgram());
        Student saved = studentRepository.save(studentUpdated);

        return saved;
    }

    public Student dropoutStudent(int id) {
        Student studentUpdated = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found by id: " + id));

        studentUpdated.setStatus("dropout");
        Student saved = studentRepository.save(studentUpdated);

        return saved;
    }
}
