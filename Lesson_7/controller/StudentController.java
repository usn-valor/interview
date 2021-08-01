package Interview.Lesson_7.controller;

import Interview.Lesson_7.service.StudentService;
import Interview.Lesson_7.student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Student> listPage() {
        logger.info("List page requested");

        return studentService.findAll();
    }

    @GetMapping("/new")
    public String create() {
        logger.info("Create new Student request");

        model.addAttribute("student", new Student());
        return "created";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Long id) {
        logger.info("Student delete request");

        studentService.delete(id);
        return "deleted";
    }
}
