package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/23 10:23
 */
public class Lee34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums.length == 0) return res;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ( left + right ) / 2;

            if (nums[mid] == target) {
                int num = mid;
                while (num < right && nums[num + 1] == target) {
                    num++;
                }
                res[1] = num;
                num = mid;
                while (num > left && nums[num - 1] == target) {
                    num--;
                }
                res[0] = num;
                return res;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return res;
    }

}
