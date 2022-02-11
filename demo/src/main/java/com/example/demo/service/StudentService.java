package com.example.demo.service;

import com.example.demo.Student.Student;
import com.example.demo.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void deleteStudent(long StudentId){
       boolean exist= studentRepository.existsById(StudentId);
       if(!exist)
           throw new IllegalStateException("Student "+StudentId+" not find");
       studentRepository.deleteById(StudentId);
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentOptional=  studentRepository.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent())
           throw new IllegalStateException("e mail taken");
       studentRepository.save(student);
    }
    @Transactional
    public void updateStudent(Long StudentId,String name,String email) {
        Student student=studentRepository.findById(StudentId)
                .orElseThrow(()->new IllegalStateException(StudentId+" does not exist"));
        if(name !=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional=  studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
                throw new IllegalStateException("e mail taken");
            student.setEmail(email);
        }

    }
}
