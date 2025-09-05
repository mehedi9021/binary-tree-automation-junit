package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BinaryTree {
    private TreeNode root;
    private Comparator<Student> comparator;

    public BinaryTree(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public void insert(Student student) {
        if (root == null) {
            root = new TreeNode(student);
        } else {
            insertRec(root, student);
        }
    }

    private void insertRec(TreeNode node, Student student) {
        if (comparator.compare(student, node.student) < 0) {
            if (node.left == null) {
                node.left = new TreeNode(student);
            } else {
                insertRec(node.left, student);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(student);
            } else {
                insertRec(node.right, student);
            }
        }
    }

    public List<Student> inOrderTraversal() {
        List<Student> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(TreeNode node, List<Student> result) {
        if (node != null) {
            inOrderRec(node.left, result);
            result.add(node.student);
            inOrderRec(node.right, result);
        }
    }
}
