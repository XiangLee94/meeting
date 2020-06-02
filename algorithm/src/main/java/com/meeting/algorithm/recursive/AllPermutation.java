package com.meeting.algorithm.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutation {

    public static void main(String[] args) {
        permute(new int[]{3, 3, 3, 0 });
        System.out.println(1);

    }

    public static List<List<Integer>> permute(int[] nums) {
        int[] visit = new int[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        back(result, visit, temp, nums);
        return result;
    }

    private static void back(List<List<Integer>> result, int[] visit, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 1)
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && visit[i-1] == 0)
                continue;
            visit[i] = 1;
            temp.add(nums[i]);
            back(result, visit, temp, nums);
            visit[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

}
