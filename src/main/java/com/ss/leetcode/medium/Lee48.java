package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/27 10:31
 */
public class Lee48 {

    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        //对角线 翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int left = 0;
        int right = n -1;
        int row = 0;
        while (row < n) {
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left ++;
                right --;
            }
            row++;
            left = 0;
            right = n -1;
        }
    }
}
