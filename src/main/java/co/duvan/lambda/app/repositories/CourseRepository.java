package co.duvan.lambda.app.repositories;

import co.duvan.lambda.app.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
