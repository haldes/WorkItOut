package com.haldes.dfs;

import com.haldes.dfs.TreeNode;


public class MaxElementBinaryTree {

    static int state = -1;

    public static void main(String[] args) {
        //TreeNode root = getSampleTree();
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.getSampleTree();

        getMaxElementBinaryTree(root);
        System.out.println("final answer : " + state);
    }

    public static int getMaxElementBinaryTree(TreeNode root)  {

/*
            5
           / \
          4   8
         /  \  \
        1    2  9

*/

        if(root == null) return 0;

        //System.out.println(root.val);
        if( root.val > state) {
            state = root.val;
        }
        int left = getMaxElementBinaryTree(root.left);
        int right = getMaxElementBinaryTree(root.right);
        System.out.println(root.val +" # " + left +" # " + right +" # " + state +" ## ");//+ cnt);
        return root.val;
    }

}

