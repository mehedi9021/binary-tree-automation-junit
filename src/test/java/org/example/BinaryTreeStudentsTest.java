package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.List;

public class BinaryTreeStudentsTest {

    Comparator<Student> gpaComparator = Comparator
            .comparingDouble((Student s) -> s.gpa)
            .thenComparingInt(s -> s.courses.size());

    Comparator<Student> courseComparator = Comparator
            .comparingInt((Student s) -> s.courses.size())
            .thenComparingDouble(s -> s.gpa);

    @Test
    void testGpaAndCourseSorting() {
        BinaryTree tree = new BinaryTree(gpaComparator);

        Student alice = new Student("Alice", 3.5, List.of("Math", "Science"));
        Student bob = new Student("Bob", 3.8, List.of("Math", "English", "History"));
        Student charlie = new Student("Charlie", 3.5, List.of("Math"));
        Student diana = new Student("Diana", 3.9, List.of("Science", "History"));
        Student eve = new Student("Eve", 3.8, List.of("Math", "Science", "Art"));

        tree.insert(alice);
        tree.insert(bob);
        tree.insert(charlie);
        tree.insert(diana);
        tree.insert(eve);

        List<Student> result = tree.inOrderTraversal();

        assertEquals("Charlie", result.get(0).name);
        assertEquals("Alice", result.get(1).name);
        assertEquals("Bob", result.get(2).name);
        assertEquals("Eve", result.get(3).name);
        assertEquals("Diana", result.get(4).name);
    }

    @Test
    void testEmptyTree() {
        BinaryTree tree = new BinaryTree(gpaComparator);
        assertTrue(tree.inOrderTraversal().isEmpty());
    }

    @Test
    void testSingleStudent() {
        BinaryTree tree = new BinaryTree(gpaComparator);
        Student alice = new Student("Alice", 3.5, List.of("Math", "Science"));
        tree.insert(alice);

        List<Student> result = tree.inOrderTraversal();
        assertEquals(1, result.size());
        assertEquals("Alice", result.getFirst().name);
    }

    @Test
    void testCourseSorting() {
        BinaryTree tree = new BinaryTree(courseComparator);

        Student alice = new Student("Alice", 3.5, List.of("Math", "Science"));
        Student charlie = new Student("Charlie", 3.5, List.of("Math"));
        Student zara = new Student("Zara", 3.5, List.of("English", "Science", "Math"));

        tree.insert(alice);
        tree.insert(charlie);
        tree.insert(zara);

        List<Student> result = tree.inOrderTraversal();

        assertEquals("Charlie", result.get(0).name);
        assertEquals("Alice", result.get(1).name);
        assertEquals("Zara", result.get(2).name);
    }
}
