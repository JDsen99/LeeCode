package com.ss.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lee128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int len = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                len = 1;
                while (set.contains(++num)) len++;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
