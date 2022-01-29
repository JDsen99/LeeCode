package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/29 10:03
 */
public class Lee55 {
    public boolean canJump(int[] nums) {
        int end = nums[0];

        int index = 1;
        while (index < nums.length && index <= end) {
            if (nums[index] > end) {
                end = index + nums[index];
            }
            if (end >= nums.length) return true;
        }
        return false;
    }
}
