package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/6 10:34
 */
public class Lee64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1 || i == 1) {
                    res[i][j] = res[i][j - 1] + res[i - 1][j] + grid[i - 1][j - 1];
                    continue;
                }
                res[i][j] = Math.min(res[i][j - 1], res[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        return res[m][n];
    }
    public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                }else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                }else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                }else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }


    int[][] res;

    /**
     * dfs
     * @param grid grid
     * @return int
     */
    public int minPathSum2(int[][] grid) {
        res = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, grid.length, grid[0].length);
    }

    private int dfs(int[][] grid, int i, int j, int x, int y) {
        if (i == x && j == y) return grid[x][y];

        if (i < 0 || i > x || j < 0 || j > y) return Integer.MAX_VALUE;

        if (res[i][j] != 0) return res[i][j];

        int right = dfs(grid, i, j+ 1, x, y);
        int down = dfs(grid, i + 1, j, x, y);

        return res[i][j] = Math.min(right, down) + grid[i][j];
    }
}
