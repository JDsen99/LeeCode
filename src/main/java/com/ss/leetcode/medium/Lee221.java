package com.ss.leetcode.medium;

public class Lee221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 1) {
            return matrix[0][0] == '1' ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j, i, j, matrix));
            }
        }
        return res;
    }

    private int dfs(int i1, int j1, int i2, int j2, char[][] matrix) {
        if (i2 < 0 || i2 >= matrix.length || j2 < 0 || j2 >= matrix.length) {
            return 0;
        }

        int res = 0;
        if (check(i1, j1, i2, j2, matrix)) {
            res = (i2 - i1 + 1) * (j2 - j1 + 1);
            res = Math.max(dfs(i1, j1, i2 + 1, j2 + 1, matrix), res);
        } else {
            return 0;
        }
        return res;

    }

    private boolean check(int i, int j, int i2, int j2, char[][] matrix) {
        for (int k = i; k < i2; k++) {
            for (int l = j; l < j2; l++) {
                if (matrix[k][l] != '1') {
                    return false;
                }
            }
        }
        return true;
    }
}
