package com.ss.leetcode.hard;

/**
 * @author Senn
 * @create 2022/1/27 10:16
 */
public class Lee52 {
    boolean[] col;
    boolean[] dg;
    boolean[] udg;
    int res = 0;
    public int totalNQueens(int n) {
        col = new boolean[n];
        dg = new boolean[2 * n + 1];
        udg = new boolean[2 * n + 1];
        dfs(0,n);
        return res;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            res ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || dg[row + i] || udg[n - row + i - 1]) continue;
            col[i] = dg[row + i] = udg[n - row + i - 1] = true;
            dfs(row + 1, n);
            col[i] = dg[row + i] = udg[n - row + i - 1] = false;
        }
    }
}
