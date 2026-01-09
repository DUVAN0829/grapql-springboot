package co.duvan.lambda.app.services;

import co.duvan.lambda.app.entities.Student;
import co.duvan.lambda.app.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService  {

    //* Vars
    private final StudentRepository repository;

    //* Const
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    //* Implement Methods
    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findbyId(Long id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) this.repository.findAll();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

}














