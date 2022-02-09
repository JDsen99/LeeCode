package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/9 10:53
 */
public class Lee81 {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[mid] > nums[left]) {
                if (nums[mid] > target && target >=  nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
