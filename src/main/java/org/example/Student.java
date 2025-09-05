package org.example;

import java.util.List;

public class Student {
    String name;
    double gpa;
    List<String> courses;

    public Student(String name, double gpa, List<String> courses) {
        this.name = name;
        this.gpa = gpa;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return name + " (GPA: " + gpa + ", Courses: " + courses.size() + ")";
    }
}
