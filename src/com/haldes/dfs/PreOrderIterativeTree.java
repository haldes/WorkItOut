package com.haldes.dfs;

import java.util.Stack;

public class PreOrderIterativeTree {
    public static boolean state = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.getSampleTree();

        preOrderTraversal(root);


    }


    public static void preOrderTraversal(TreeNode root){

/*
            5
           / \
          4   8
         /  \  \
        1    2  9

*/
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
             TreeNode curr = stack.pop();

             System.out.println(curr.val);

             if(curr.right != null){
                 stack.push(curr.right);
             }

             if(curr.left != null){
                 stack.push(curr.left);
             }
        }

    }
}
