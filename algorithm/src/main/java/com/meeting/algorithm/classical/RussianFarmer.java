package com.meeting.algorithm.classical;

public class RussianFarmer {
    public static int mul(int a, int b) {
        int sum = 0;
        while (b != 1) {
            if ((b & 1) != 0) {
                sum += a;
            }
            a = a << 1;
            b = b >> 1;
        }
        sum += a;
        return sum;

    }
}
