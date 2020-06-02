package com.meeting.algorithm.solution;

public class Solution236 {

    public static void main(String[] args) {
        int i = 0, j = 0;
        int n = 1;
        while (n++ < 5) {
            System.out.println("j" + ++j);
            System.out.println("i" + i++);
        }
        System.out.println("i " + i);
        System.out.println("j " + j);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        return null;
    }
}
