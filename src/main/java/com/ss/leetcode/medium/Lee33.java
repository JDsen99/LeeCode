package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/22 10:45
 */
public class Lee33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int res = -1;
        if (target >= nums[0]) {
            for (int i = 0; i < length - 1; i++) {
                if (nums[i] > nums[i + 1]) break;
                if(target == nums[i]) {
                    res = i;
                    break;
                }
            }
        }else {
            for (int i = length - 1; i > 0; i--) {
                if (nums[i] < nums[i - 1]) break;
                if(target == nums[i]) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }

    public int search2(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] < nums[right]) {
                if (target > nums[mid]  && target < nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
