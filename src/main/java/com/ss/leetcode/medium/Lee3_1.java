package com.ss.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Senn
 * @create 2021/12/25 16:42
 */
public class Lee3_1 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i  - left + 1);
        }
        return res;
    }
}
