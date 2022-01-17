package com.ss.leetcode.medium;

import java.util.Arrays;

/**
 * 最接近三数之和
 * @author Senn
 * @create 2022/1/17 10:35
 */
public class Lee16_2 {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
                if (target > sum) l ++;
                if (target < sum) r --;
                if (target == sum) return res;
            }
        }
        return res;
    }
}
