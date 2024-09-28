package com.haldes.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterativeTree {
    public static boolean state = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.getSampleTree();

        postOrderTraversal(root);


    }


    public static void postOrderTraversal(TreeNode root){

/*
            5
           / \
          4   8
         /  \  \
        1    2  9

        post-order : 1,2,4,9,8,5
*/
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        s1.add(root);

        while(!s1.empty()){
            TreeNode curr = s1.pop();

            s2.push(curr);
            if(curr.left != null) s1.push(curr.left);
            if(curr.right != null) s1.push(curr.right);
        }

        while(!s2.empty()) {
            ans.add(s2.pop().val);
        }
        System.out.println(ans);

    }
}
