package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/18 12:20
 */
public class Lee53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            res = Math.max(res, sum);
            if (sum < 0) sum = 0;
        }
        return res;
    }
}
