package com.student.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private String email;
    private String password;

    // Constructor
    public Student(int id, String name, String course, String email, String password) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Course: " + course +
                ", Email: " + email;
        // ⚠️ Don't print password for security
    }
}