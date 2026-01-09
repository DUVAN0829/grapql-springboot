package co.duvan.lambda.app.services;

import co.duvan.lambda.app.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findbyId(Long id);

    List<Student> findAll();

    Student save(Student student);

    void deleteById(Long id);

}
