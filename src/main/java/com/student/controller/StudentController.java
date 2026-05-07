package com.student.controller;


import com.student.model.Student;
import com.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    // Constructor Injection
    public StudentController(StudentService service) {
        this.service = service;
    }

    // Save Student
    @PostMapping
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student,
                                         BindingResult result) {

        // Validation Check
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Student savedStudent = service.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {

        Student student = service.getStudentById(id);

        if (student == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Student not found with id: " + id);
        }

        return ResponseEntity.ok(student);
    }

    // Update Student
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,
                                           @Valid @RequestBody Student student,
                                           BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Student updatedStudent = service.updateStudent(id, student);

        if (updatedStudent == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Student not found with id: " + id);
        }

        return ResponseEntity.ok(updatedStudent);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

//        delete =service.deleteStudent(id);
//
//        if (!deleted) {
//            return ResponseEntity
//                    .badRequest()
//                    .body("Student not found with id: " + id);
//        }

        return ResponseEntity.ok("Student deleted successfully");
    }
}
