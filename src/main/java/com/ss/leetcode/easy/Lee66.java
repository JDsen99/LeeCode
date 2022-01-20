package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/20 11:13
 */
public class Lee66 {
    public int[] plusOne(int[] digits) {
        int up = 1;
        for (int i =  digits.length - 1; i >= 0; i--) {
            digits[i]++;
            up = digits[i] / 10;
            digits[i] = digits[i] % 10;
            if (up == 0) {
                break;
            }
            if (i == 0 && up > 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
