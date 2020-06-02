package com.meeting.algorithm.solution;


import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        inOrd(root);
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val <= min) return false;
            else min = val;
        }
        return true;
    }

    public void inOrd(TreeNode root) {
        if (root != null) {
            inOrd(root.left);
            list.add(root.val);
            inOrd(root.right);
        }
    }


}
