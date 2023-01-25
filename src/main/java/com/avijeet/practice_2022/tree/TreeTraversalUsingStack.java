package com.avijeet.practice_2022.tree;

import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class TreeTraversalUsingStack {
    static void inOrder(Node root) {
        Stack<Node> s = new Stack<>();
//        s.add(root);
        Node curr = root;
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                process(curr);
                curr = curr.right;
            }
        }

    }

    static void preOrder(Node root) {
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                process(curr);
                s.push(curr.right);
                curr = curr.left;
            } else {
                curr = s.pop();
            }
        }
    }

    static void postOrder(Node root) {
        Stack<Node> s = new Stack<>();
//        Node curr = root;
        s.push(root);
        Set<Node> processedNodes= new HashSet<>();
        while (!s.isEmpty()) {
            Node curr = s.peek();
            if ((curr.left== null || processedNodes.contains(curr.left)) && (curr.right == null|| processedNodes.contains(curr.right)) ) {
                processedNodes.add(curr);
                process(curr);
                s.pop();
            }else {
                if (curr.right != null && !processedNodes.contains(curr.right)) {
                    s.push(curr.right);
                }
                if (curr.left != null && !processedNodes.contains(curr.left)) {
                    s.push(curr.left);
                }
            }
        }
    }

    public static void process(Node a) {
        System.out.print(a.val + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
    }
}
