package com.ss.leetcode.medium;

public class Lee215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(0, nums.length - 1, nums);
        return nums[nums.length - k];
    }

    private void quickSort(int left, int right, int[] nums) {
        if (left >= right) return;
        int i = left - 1;
        int j = right + 1;
        int x = nums[left + right >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(left, j, nums);
        quickSort(j + 1, right, nums);
    }
}
