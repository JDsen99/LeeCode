package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/29 10:43
 */
public class Lee168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            sb.append((char) columnNumber % 26 + 'A');
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
