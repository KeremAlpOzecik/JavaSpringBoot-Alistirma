package com.example.demo.repos;

import com.example.demo.Student.Student;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);


}
