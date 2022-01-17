package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/17 11:48
 */
public class Lee27_0 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                if (index == i) index ++;
                else nums[index++] = nums[i];
        }
        return index;
    }
}
