package com.ss.leetcode.easy;

/**
 * 去重
 * @author Senn
 * @create 2022/1/17 11:34
 */
public class Lee26_0 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            nums[index++] = nums[i];
        }
        return index;
    }
}
