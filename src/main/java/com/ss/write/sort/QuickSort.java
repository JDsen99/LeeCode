package com.ss.write.sort;

/**
 * @author Senn
 * @create 2022/2/20 16:53
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {46,16,53,90,12,10,46};
        new QuickSort().sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort1(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int left, int right, int[] nums) {
        if (left >= right) return;
        int i = left - 1;
        int j = right + 1;
        int x = nums[left + right >> 1];
        //边界
        while (i < j) {
            //寻找 区域不符合的值
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            //满足条件 则交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //左侧递归 快排
        quickSort(left, j, nums);
        //右侧递归 快排
        quickSort(j + 1, right, nums);
    }

    private void quickSort1(int left, int right, int[] nums) {
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
        quickSort1(left, j, nums);
        quickSort1(j + 1, right, nums);
    }
}
