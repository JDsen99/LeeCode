package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/29 10:50
 */
public class Lee171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res += columnTitle.charAt(i) - 'A' + 1;
            res *=26;
        }
        return res;
    }
}
