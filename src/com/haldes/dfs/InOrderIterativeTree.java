package com.haldes.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterativeTree {
    public static boolean state = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.getSampleTree();

        inOrderTraversal(root);


    }


    public static void inOrderTraversal(TreeNode root){

/*
            5
           / \
          4   8
         /  \  \
        1    2  9

        in-order : 1,4,2,5,8,9
*/

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(true){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                if(stack.empty()) {
                    break;
                }
                 TreeNode temp = stack.pop();
                 System.out.println(temp.val);
                 curr = temp.right;
            }

        }


    }
}
