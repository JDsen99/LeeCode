package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/16 11:30
 */
public class Lee12 {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < 13) {
            while (num >= values[index]) {
                num -= values[index];
                sb.append(romans[index]);
            }
            index ++;
        }
        return sb.toString();
    }
}
