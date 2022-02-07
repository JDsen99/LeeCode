package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/2/7 11:30
 */
public class Lee205 {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[256];
        char[] reverMap = new char[256];

        char[] str = s.toCharArray();
        char[] target = t.toCharArray();

        for (int i = 0; i < str.length; i++) {
            if (map[str[i]] == '\0' && reverMap[target[i]] == '\0') {
                map[str[i]] = target[i];
                reverMap[target[i]] = str[i];
            } else {
                if (map[str[i]] != target[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
