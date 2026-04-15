package com.student.repository;

import com.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    // Custom methods (optional)
    Student findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existByEmail(String email);
}
