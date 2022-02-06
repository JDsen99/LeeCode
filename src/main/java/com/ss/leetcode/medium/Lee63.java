package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/6 10:28
 */
public class Lee63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m + 1][n + 1];
        res[0][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j] != 0) res[i][j] = 0;
                res[i][j] = res[i][j - 1] + res[i - 1][j];
            }
        }
        return res[m][n];
    }
}
