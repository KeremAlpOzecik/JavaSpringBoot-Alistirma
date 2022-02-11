package com.example.demo.controller;

import com.example.demo.Student.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){return studentService.getStudents();}
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
      studentService.addNewStudent(student);
    }
    @PutMapping(path = "{StudentId}")
    public void updateStudent(@PathVariable("StudentId")Long StudentId,
                              @RequestParam(required = false)String name,
                              @RequestParam(required = false)String email){
        studentService.updateStudent(StudentId,name,email);
    }
    @DeleteMapping(path = "{StudentId}")
    public void deleteStudent(@PathVariable("StudentId") long StudentId){
        studentService.deleteStudent(StudentId);

    }
}
