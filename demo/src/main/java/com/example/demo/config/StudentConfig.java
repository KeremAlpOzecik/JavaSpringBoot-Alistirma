package com.example.demo.config;

import com.example.demo.Student.Student;
import com.example.demo.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JULY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           Student kerem= new Student("Kerem ALP","kerem-alp@hotmail.com", LocalDate.of(1999, JULY,2));
           Student alex= new Student("Alex de Souza","alexi@hotmail.com", LocalDate.of(1982, JULY,21));
           studentRepository.saveAll(List.of(kerem,alex));
        };

    }
}
