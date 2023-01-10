package by.newhardskills.datajpa.repositories;

import by.newhardskills.datajpa.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
