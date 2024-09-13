package com.haldes.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
public class VisibleTreeNode {

    static int cnt = 0;
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int visibleTreeNode(Node<Integer> root) {
        // WRITE YOUR BRILLIANT CODE HERE

        dfs(root, root.val);
        return cnt ;
    }

    public static int dfs(Node<Integer> root, Integer state){

        if(root == null) return 0;

        if(root.val >= state) cnt++;

        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        System.out.println(root.val +" # " + left +" # " + right +" # " + state +" ## "+ cnt);
        return root.val;

    }

    // this function builds a tree from input; you don't have to modify it
    // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String q1 = "5 4 3 x x 8 x x 6 x x"; // 3
        String q2 = "9 8 11 x x 20 x x 6 x x"; // 3
        String q3 = "3 1 3 x x 3 x x 1 2 5 x x x x"; //4
        Node<Integer> root = buildTree(splitWords(q3).iterator(), Integer::parseInt);
        scanner.close();
        int res = visibleTreeNode(root);
        System.out.println(res);
    }
}
