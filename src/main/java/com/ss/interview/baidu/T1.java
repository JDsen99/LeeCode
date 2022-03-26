package com.ss.interview.baidu;

import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 15:07
 */
public class T1 {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][n];
        int[][] res = new int[n * m][n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                spare(i, j , num[i][j], m, res);
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void spare(int i, int j, int number, int m, int[][] res) {
        for (int k = i * m; k < (i + 1) * m; k++) {
            for (int l = j * m; l < (j + 1) * m; l++) {
                res[k][l] = number;
            }
        }
    }
}
