package com.haldes.dfs;

public class SizeOfABinaryTree {
    public static boolean state = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.getSampleTree();

        getSizeOfABinaryTree(root);
        System.out.println("final result is : " + state);

    }


    public static int getSizeOfABinaryTree(TreeNode root){

/*
            5
           / \
          4   8
         /  \  \
        1    2  9

*/
        if(root == null) return 0;


        int left = getSizeOfABinaryTree(root.left);
        int right = getSizeOfABinaryTree(root.right);
        int currLength = Math.max(left, right) + 1;
        System.out.println(root.val +" # " + left +" # " + right +" # " + state +" ## "+ currLength);
        return Math.max(left, right) + 1;

    }
}
