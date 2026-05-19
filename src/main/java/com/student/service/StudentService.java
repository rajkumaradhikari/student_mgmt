package com.student.service;

import com.student.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

//    List<Student> getAllStudents();

    Page<Student> getAllStudents(int page, int size);
    Student getStudentById(int id);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);
}
