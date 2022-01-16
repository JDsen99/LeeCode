package com.ss.leetcode.medium;

/**
 * 盛水最多的容器
 * @author Senn
 * @create 2022/1/16 11:10
 */
public class Lee11 {
    public int maxArea(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = height.length - 1;
        while(leftMax != rightMax) {
            int min = Math.min(height[leftMax], height[rightMax]);
            res = Math.max(res,min * (rightMax - leftMax));
            if (min == leftMax) {
                leftMax ++;
            }else {
                rightMax --;
            }
        }
        return res;
    }
}
