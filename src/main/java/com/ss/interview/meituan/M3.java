package com.ss.interview.meituan;

import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 9:43
 */
public class M3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int[] sum = new int[n + 1];
        int[][] mx1 = new int[m1][2];
        int[][] mx2 = new int[m2][2];
        for (int i = 0; i < m1; i++) {
            mx1[i][0] = sc.nextInt();
        }
        for (int i = 0; i < m1; i++) {
            mx1[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m2; i++) {
            mx2[i][0] = sc.nextInt();
        }
        for (int i = 0; i < m2; i++) {
            mx2[i][1] = sc.nextInt();
        }
        for(int[] arr : mx1) {
            int i = arr[0],j = arr[1];
            sum[i]++;
            sum[j + 1] --;
        }
        for(int[] arr : mx2) {
            int i = arr[0],j = arr[1];
            sum[i]++;
            sum[j + 1] --;
        }
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
        }
        int res = 0;
        for (int i : sum) {
            if (i == 2) res++;
        }
        System.out.println(res);
    }
}
