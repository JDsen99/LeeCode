package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/28 10:32
 */
public class Lee50 {
    public double myPow(double x, int n) {
        if (x == 0.0F) return 0.0D;
        long b = n;
        double res = 1.0D;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
