package by.newhardskills.datajpa.services;

import by.newhardskills.datajpa.domain.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    long getCountOfAllStudents();

}
