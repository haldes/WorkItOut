package com.haldes.trees.core;

public class TreeADT {
    public Node root;

    public void add(Integer val){
        root = addNode(root, val);
    }

    private Node addNode(Node root, Integer val){
        if(root == null){
            root = new Node(val, null, null);
            return root;
        }

        if(val < root.val)
            root.left = addNode(root.left, val);
        else if(val > root.val)
            root.right = addNode(root.right, val);
        return root;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}

class Node {
    public Integer val;
    public Node left;
    public Node right;

    public Node(Integer val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}