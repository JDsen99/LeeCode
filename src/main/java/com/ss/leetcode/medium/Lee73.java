package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/7 10:02
 */
public class Lee73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] col = new boolean[m];
        boolean row = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (matrix[i][j] == 0) {
                    col[j] = true;
                    row = true;
                }
            }
            if (row) {
                for (int j = 0; j < m ; j++) {
                     matrix[i][j] = 0;
                }
            }
        }
        for (int i1 = 0; i1 < col.length; i1++) {
            if (col[i1]) {
                for (int i = 0; i < n; i++) {
                    matrix[i][i1] = 0;
                }
            }
        }

    }
}
