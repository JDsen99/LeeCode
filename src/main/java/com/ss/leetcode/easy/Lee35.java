package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/18 12:05
 */
public class Lee35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) /2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return l;
    }
}
