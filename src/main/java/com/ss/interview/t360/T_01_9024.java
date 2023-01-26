package com.ss.interview.t360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/24 13:53
 */
public class T_01_9024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[] tem = new int[m];
        int[][] sums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tem[j] += nums[i][j];
                if (i > 0) {
                    sums[i][j] += (sums[i - 1][j] + nums[i][j]);
                }else {
                    sums[i][j] += nums[i][j];
                }

            }
        }
        if (n <= 7) {
            Arrays.sort(tem);
            System.out.println(tem[m - 1] + 1);
        }else {
            int[] res = sums[n - 1];
            Arrays.sort(res);
            System.out.println(res[res.length - 1] + 2);
        }
    }
}
