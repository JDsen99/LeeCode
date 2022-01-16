package com.ss.leetcode.easy;

/**
 * 最 长 公共前缀
 *
 * @author Senn
 * @create 2022/1/16 15:03
 */
public class Lee14 {
    /**
     *  1ms
     */
    public String longestCommonPrefix2(String[] strs) {
        int length = strs.length;
        if (length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }

    /**
     *  4ms
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        for (String str : strs) {
            if (str.length() == 0) {
                return "";
            }
        }
        String temp = "";
        int len = 1;
        boolean flag = true;
        while (flag && strs[0].length() >= len) {
            temp = strs[0].substring(0, len++);
            for (String str : strs) {
                if (!str.startsWith(temp)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ? temp : strs[0].substring(0, len - 2);
    }


}
