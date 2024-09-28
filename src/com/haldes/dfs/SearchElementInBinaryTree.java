package com.haldes.dfs;

public class SearchElementInBinaryTree {

    public static boolean state = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.getSampleTree();

        getSearchElementInBinaryTree(root,18);
        System.out.println("final result is : " + state);

    }


    public static void getSearchElementInBinaryTree(TreeNode root, int target){

/*
            5
           / \
          4   8
         /  \  \
        1    2  9

*/
        if(root == null) return;

        if(root.val == target) {
            state = true;
        }
        System.out.println(root.val +" # " + state +" ## ");//+ cnt);
        getSearchElementInBinaryTree(root.left, target);
        getSearchElementInBinaryTree(root.right, target);

        return;

    }
}
