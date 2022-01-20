package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/20 10:48
 */
public class Lee58 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ' && res == 0)
                continue;
            if(chars[i] == ' ' && res != 0)
                break;
            res ++;
        }
        return res;
    }
}
