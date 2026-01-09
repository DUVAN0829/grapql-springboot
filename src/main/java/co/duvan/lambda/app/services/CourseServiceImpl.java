package co.duvan.lambda.app.services;

import co.duvan.lambda.app.entities.Course;
import co.duvan.lambda.app.repositories.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    //* Vars
    private final CourseRepository repository;

    //* Constructor
    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    //* Implement Merhods
    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findbyId(Long id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) this.repository.findAll();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return this.repository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

}















