package com.student.service.impl;

import com.student.exception.StudentNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    //get all student with chunk of list
    @Override
    public Page<Student> getAllStudents(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }


    @Override
    public Student getStudentById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update fields (adjust based on your Student model)
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }

    @Override
    public void deleteStudent(int id) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        repository.delete(existingStudent);
    }
}
