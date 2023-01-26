package com.ss.interview.sort;

/**
 * @author Senn
 * @create 2022/2/20 17:24
 */
public class MergeSort {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }
    private void mergeSort(int left, int right, int[] nums) {
        //边界判断
        if (left >= right) return;
        //中值
        int mid = left + right >> 1;
        //左右
        mergeSort(left, mid, nums);
        mergeSort(mid + 1, right, nums);
        //临时数组下标
        int k = 0;
        int i = left;
        //中值 左边
        int j = mid + 1;
        //临时数组
        int[] temp = new int[right - left + 1];
        //两边合并
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        //剩余的合并
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        //临时数组 更新到 原数组
        for (i = left, j = 0; i <= right; i++, j++) nums[i] = temp[j];
    }
}
