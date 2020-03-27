package com.meeting.algorithm.classical;

/**
 * 最大公约数和最小公倍数算法
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(8, 4));
        System.out.println(maxMul(4, 6));
    }

    /**
     * 辗转相除（欧几里得）法
     * 原理：两个正整数a和b（a > b），它们的最大公约数gcd等于a除以b的余数r和b之间的最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * 更相减损术
     * 原理：两个正整数a和b（a > b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。依次递归下去，直到两个数相等，这相等两个数的值就是所求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd0(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd0(a - b, b);
        } else {
            return gcd0(b - a, a);
        }
    }

    /**
     * 设y=k*y1, x=k*y2,则f(x,y)=k*f(x1,y1);
     * <p>
     * 若x=p*x1,p是素数，且y%p!=0(即y不能被p整除)，有f(x,y)=f(p*x1, y)=f(x1,y);
     * <p>
     * 取p=2，则有三种情况：x y均为偶数；x y一偶一奇；x y均为奇数，对于第三种情况，就用思路2，用差来表示。
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd1(int a, int b) {
        if (a < b)
            return gcd1(b, a);
        if (b == 0)
            return a;
        if (a % 2 == 0 && b % 2 == 0)
            return gcd1(a >> 1, b >> 1) << 1;
        if (a % 2 == 0 && b % 2 != 0)
            return gcd1(a >> 1, b);
        if (a % 2 != 0 && b % 2 == 0)
            return gcd1(a, b >> 1);
        if (a % 2 != 0 && b % 2 != 0)
            return gcd1(b, a - b);
        return 1;
    }


    /**
     * 最小公倍数公式 两数乘积除以两数最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int maxMul(int a, int b) {
        return a * b / gcd0(a, b);
    }
}
