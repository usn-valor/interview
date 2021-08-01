package Interview.Lesson_7.service;

import Interview.Lesson_7.student.Student;
import Interview.Lesson_7.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public Optional<Student> findById(long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void save(String name, Integer mark) {
        studentRepository.save(new Student(name, mark));
    }

    @Transactional
    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
