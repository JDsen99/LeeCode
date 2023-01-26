package com.ss.interview.t360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/24 13:53
 */
public class T_02_9024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] indexs = new int[m];
        for (int i = 0; i < m; i++) {
            indexs[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int tar = indexs[i];
            int[] temp = new int[n];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < tar) {
                    temp[index++] = nums[j];
                }
            }
            temp[index++] = tar;
            for (int j = 0; j < n; j++) {
                if (nums[j] > tar) {
                    temp[index++] = nums[j];
                }
            }
            nums = temp;
        }
        Arrays.stream(nums).forEach(s -> System.out.print(s + "\t"));
    }
}
