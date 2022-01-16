package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/16 15:38
 */
public class Lee9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return x == temp / 10 || x == temp;
    }
}
