package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/21 11:01
 */
public class Lee69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0;
        int right = x / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid < x / mid) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
