package com.meeting.algorithm.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution974 {
    public static int subarraysDivByK(int[] A, int K) {
        int count = 0;
        int preSum = 0;
        Map<Integer, Integer> preMap = new HashMap<>();

        for (int a : A) {
            preSum += a;
            preSum %= K;
            if (preSum < 0) preSum = preSum + K;
            int value = preMap.getOrDefault(preSum, 0);
            if (value > 0) {
                count += value;
            }
            preMap.put(preSum, value + 1);
        }
        return count;

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK(a, 5));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int value  = k == 0 ? 0 : sum % k;
            Integer index = preMap.get(value);
            if (index != null) {
                if (i - index > 1)
                    return true;
                continue;
            }
            preMap.put(value, i);
        }
        return false;
    }
}
