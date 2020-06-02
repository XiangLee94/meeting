package com.meeting.algorithm.solution;

public class Solution45 {
    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(jump(a));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 0;
        int to = nums.length - 1;
        while (to > 0) {
            for (int i = 0; i < to; i++) {
                if ((i + nums[i]) >= to) {
                    step++;
                    to = i;
                    break;
                }
            }
        }
        return step;
    }

}
