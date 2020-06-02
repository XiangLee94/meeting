package com.meeting.algorithm.solution;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int a = 0;
        for(int num :nums){
            a ^= num;
        }

        int b = 0;
        for(int i = 1; i <=nums.length;i ++){
            b ^= i;
        }
        return a^b;

    }
}
