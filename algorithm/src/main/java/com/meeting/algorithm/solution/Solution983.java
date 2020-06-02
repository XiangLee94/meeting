package com.meeting.algorithm.solution;

public class Solution983 {

    public int mincostTickets(int[] days, int[] costs) {
        int maxDays = days[days.length - 1];
        int pos = 0;
        int[] dp = new int[maxDays + 1];
        //从1开始是为了防止取i-1的时候越界，同时索引0的值就是0
        for (int i = 1; i <= maxDays; i++) {
            if (i == days[pos]) {
                int oneDayAgo = i - 1 > 0 ? i - 1 : 0;
                int sevenDayAgo = i - 7 > 0 ? i - 7 : 0;
                int thirtyDatAgo = i - 30 > 0 ? i - 30 : 0;
                //1天前加买一天的，7天前加买7天的，30天前加买30天的，取这三个里边最小的
                dp[i] = Math.min(dp[oneDayAgo] + costs[0], Math.min(dp[sevenDayAgo] + costs[1], dp[thirtyDatAgo] + costs[2]));
                pos++;
            } else {
                //若是当天不需要买票，就是昨天总价·
                dp[i] = dp[i - 1];
            }
        }
        return dp[maxDays];
    }
}
