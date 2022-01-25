package com.ss.leetcode.hard;

/**
 * @author Senn
 * @create 2022/1/24 10:24
 */
public class Lee42_3 {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    res += leftMax - height[left];
                }else {
                    leftMax = height[left];
                }
                left++;
            }else {
                if (height[right] < rightMax) {
                    res += rightMax - height[right];
                }else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return res;
    }
}
