package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/9 10:41
 */
public class Lee80 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }
}
