package com.ss.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Senn
 * @create 2022/1/16 11:36
 */
public class Lee13 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<String, Integer> romans = new HashMap<>();
        romans.put("M", 1000);
        romans.put("CM", 900);
        romans.put("D", 500);
        romans.put("CD", 400);
        romans.put("C", 100);
        romans.put("XC", 90);
        romans.put("L", 50);
        romans.put("XL", 40);
        romans.put("X", 10);
        romans.put("IX", 9);
        romans.put("V", 5);
        romans.put("IV", 4);
        romans.put("I", 1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer i1 = romans.get(s.substring(i, i + 1));
            Integer i2 = romans.getOrDefault(s.substring(i, i + 2), 0);
            if (i1 > i2) {
                res += i1;
            } else {
                res += i2;
                i++;
            }
        }
        return res;
    }

    /**
     * 解法2
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int pre = getValue(s.charAt(0));
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            int now = getValue(s.charAt(i));
            if (pre < now) {
                res -= pre;
            }else {
                res += pre;
            }
            pre = now;
        }
        return res + pre;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
