package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5, List.of("Math", "Science")));
        students.add(new Student("Bob", 3.8, List.of("Math", "English", "History")));
        students.add(new Student("Charlie", 3.5, List.of("Math")));
        students.add(new Student("Diana", 3.9, List.of("Science", "History")));
        students.add(new Student("Eve", 3.8, List.of("Math", "Science", "Art")));

        // GPA-based sorting
        Comparator<Student> gpaComparator = Comparator
                .comparingDouble((Student s) -> s.gpa)
                .thenComparingInt(s -> s.courses.size());

        BinaryTree gpaTree = new BinaryTree(gpaComparator);
        for (Student student : students) {
            gpaTree.insert(student);
        }

        System.out.println("Students sorted by GPA (default):");
        for (Student student : gpaTree.inOrderTraversal()) {
            System.out.println(student);
        }

        // Course count-based sorting
        Comparator<Student> courseComparator = Comparator
                .comparingInt((Student s) -> s.courses.size())
                .thenComparingDouble(s -> s.gpa);

        BinaryTree courseTree = new BinaryTree(courseComparator);
        for (Student student : students) {
            courseTree.insert(student);
        }

        System.out.println("\nStudents sorted by number of courses:");
        for (Student student : courseTree.inOrderTraversal()) {
            System.out.println(student);
        }
    }
}
