package by.newhardskills.datajpa.rest;

import by.newhardskills.datajpa.domain.entities.Student;
import by.newhardskills.datajpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping // http://localhost:8080/student
    public List<Student> getAllStudents() {
      return studentService.getAllStudents();
    }

    @GetMapping("/count") // http://localhost:8080/student/count
    public Long getCountOfAllStudents() {
        return studentService.getCountOfAllStudents();
    }

}
