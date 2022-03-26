package com.ss.interview.t360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 15:08
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] mk = new int[m][2];
        for (int i = 0; i < m; i++) {
            mk[i][0] = sc.nextInt();
            mk[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            if (mk[i][0] == 0) {
                quickSort(0, mk[i][1] - 1, arr, 0);
            }else {
                quickSort(0, mk[i][1] - 1, arr, 1);
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    private static void quickSort(int left, int right, int[] nums, int flag) {
        if (left >= right) return;
        int i = left - 1;
        int j = right + 1;
        int x = nums[left + right >> 1];
        //边界
        while (i < j) {
            //寻找 区域不符合的值
            if (flag == 0) {
                do i++; while (nums[i] < x);
                do j--; while (nums[j] > x);
            }else {
                do i++; while (nums[i] > x);
                do j--; while (nums[j] < x);
            }

            //满足条件 则交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //左侧递归 快排
        quickSort(left, j, nums, flag);
        //右侧递归 快排
        quickSort(j + 1, right, nums, flag);
    }
}
