package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/27 11:01
 */
public class Lee136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
