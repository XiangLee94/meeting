package com.meeting.datastructure.tree;

public class Test {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
    public static int maxProfit(int[] prices) {
        int maxValue = 0;
        int temp = prices[0];
        for (int a : prices) {
            if (a > temp)
                maxValue += a - temp;
            temp = a;
        }
        return maxValue;
    }
}


class Solution {

}