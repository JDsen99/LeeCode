package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/25 11:08
 */
public class Lee45 {

    public int jump(int[] nums) {
        int end = nums.length - 1;
        int res = 0;
        int target = nums[end];
        for (int i = 0; i < end;) {
            if (nums[i] >= end - i) {
                end = i;
                res ++;
                i = 0;
                if (end == 0) {
                    return res;
                }
            }else {
                i++;
            }
        }
        return res;
    }

    public int jump2(int[] nums) {
        int res = 0;
        int begin = 0;
        int end  = 0;
        while (end < nums.length - 1) {
            int temp = 0;
            for (int i = begin; i <= end; i++) {
                temp = Math.max(nums[i] + i , temp);
            }
            begin = end + 1;
            end = temp;
            res ++;
        }
        return res;
    }

}
