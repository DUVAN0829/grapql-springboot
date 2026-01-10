package co.duvan.lambda.app.controllers;

import co.duvan.lambda.app.dtos.InputStudent;
import co.duvan.lambda.app.entities.Course;
import co.duvan.lambda.app.entities.Student;
import co.duvan.lambda.app.services.CourseService;
import co.duvan.lambda.app.services.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudentController {

    //* Vars
    private final StudentService services;
    private final CourseService courseService;

    //* Constructor
    public StudentController(StudentService services, CourseService courseService) {
        this.services = services;
        this.courseService = courseService;
    }

    //* Methods
    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument String id) {

        Long studentId = Long.parseLong(id);

        return services.findbyId(studentId).orElseThrow();

    }

    @QueryMapping(name = "findAll")
    public List<Student> findAll() {
        return this.services.findAll();
    }

    @MutationMapping(name = "createStudent")
    public Student createStudent(@Argument InputStudent student) {

        Course course = this.courseService.findbyId(Long.parseLong(student.getCourseId())).orElseThrow();

        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setLastname(student.getLastname());
        student1.setCourse(course);

        this.services.save(student1);

        return student1;

    }

    @MutationMapping(name = "deleteStudent")
    public String deleteStudent(@Argument String id) {

        Long studentId = Long.parseLong(id);

        this.services.deleteById(studentId);

        return "User delete by successfully :D";

    }

}
