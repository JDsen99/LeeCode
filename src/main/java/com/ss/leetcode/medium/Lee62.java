package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/6 10:21
 */
public class Lee62 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ( j == 1 || i == 1) {
                    res[i][j] = 1;
                    continue;
                }
                res[i][j] = res[i][j - 1] + res[i - 1][j];
            }
        }
        return res[m][n];
    }
}
