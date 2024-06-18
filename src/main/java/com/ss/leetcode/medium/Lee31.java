package com.ss.leetcode.medium;

/**
 * 12385764
 *
 * @author Senn
 * @create 2022/1/22 10:20
 */
public class Lee31 {
    public void nextPermutation(int[] nums) {
        int n = 0;
        if (nums == null || (n = nums.length) == 0) return;
        // 从后往前查找第一次出现 nums[i] < nums[i+1] 的位置
        int idx1 = n - 2;
        for (; idx1 >= 0 && nums[idx1] >= nums[idx1 + 1]; idx1--) ;
        // if i == -1 nums 则整体逆序
        if (idx1 >= 0) {
            // 此时 nums[i+1, n-1] 降序, 查找其中 大于nums[i] 的最大下标，可以直接 从后往前 逆向找
            // 因为有序 可以练习一下二分查找
            int idx2 = 0;
            for (int i = nums.length - 1; i > idx1; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
            // 交换 i j
            swap(nums, idx1, idx2);
        }
        // 此时 nums[i+1, n-1] 仍然降序，将其改为升序，只需要反转即可。
        reverse(nums, idx1 + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
