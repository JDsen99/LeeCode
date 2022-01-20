package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/20 11:29
 */
public class Lee67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int up = 0;
        int n = Math.max(a.length(),b.length());
        for (int i = 0; i <n ; i++) {
            up += i < a.length()? a.charAt(a.length() - i - 1) - '0': 0;
            up += i < b.length()? b.charAt(b.length() - i - 1) - '0': 0;
            res.append((char) (up % 2 + '0'));
            up /= 2;
        }
        if (up > 0) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
