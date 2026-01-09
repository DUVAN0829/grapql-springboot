package co.duvan.lambda.app.services;

import co.duvan.lambda.app.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Optional<Course> findbyId(Long id);

    List<Course> findAll();

    Course save(Course course);

    void deleteById(Long id);

}
