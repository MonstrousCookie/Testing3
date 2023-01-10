package by.newhardskills.datajpa.services.impl;

import by.newhardskills.datajpa.domain.entities.Student;
import by.newhardskills.datajpa.repositories.StudentRepository;
import by.newhardskills.datajpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public long getCountOfAllStudents() {
        return studentRepository.count();
    }

}
