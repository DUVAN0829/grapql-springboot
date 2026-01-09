package co.duvan.lambda.app.repositories;

import co.duvan.lambda.app.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
