package com.student.service.impl;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {


    private StudentRepository repository;
    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public Student updateStudent(int id, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(int id) {

    }
}
