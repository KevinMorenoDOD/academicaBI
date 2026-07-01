package comacademiabi.backend.service;

import comacademiabi.backend.model.Course;
import comacademiabi.backend.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        Course saved = courseRepository.save(course);
        return saved;
    }

    public Course getCourseById(int id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("course not found by id: " + id));
        return course;
    }

    public Course getCourseByCode(String code) {
        Course course = courseRepository.findByCode(code).orElseThrow(() -> new RuntimeException("course not found by code: " + code));
        return course;
    }

    public Course updateCourse(Course course) {
        Course courseUpdated = courseRepository.findById(course.getId()).orElseThrow(() -> new RuntimeException("course not found by id: " + course.getId()));

        courseUpdated.setCode(course.getCode());
        courseUpdated.setName(course.getName());
        courseUpdated.setCredits(course.getCredits());
        courseUpdated.setProgram(course.getProgram());
        Course saved = courseRepository.save(courseUpdated);

        return saved;
    }

    public Course unavailableCourse(int id) {
        Course courseUpdated = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("course not found by id: " + id));

        courseUpdated.setAvailable(false);
        Course saved = courseRepository.save(courseUpdated);

        return saved;
    }
}
