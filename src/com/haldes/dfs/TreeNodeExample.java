package com.haldes.dfs;


public class TreeNodeExample {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode getSampleTreeTest() {

           /*
            5
           / \
          4   8
         /  \  \
        1    2  9

     */
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        root.left = four;
        root.right = eight;

        four.left = one;
        four.right = two;

        eight.right = nine;

        return root;
    }


    public static void main(String[] args) {

            TreeNode root = getSampleTreeTest();
            dfs(root);


        }

 /*
                  5
                 / \
                4   8
              /  \   \
             1    2   9

*/
        public static void dfs(TreeNode root){
            if(root == null) return;

            System.out.println("-->" + root.val);
            dfs(root.left);
            dfs(root.right);
            return;
        }



}