package com.ss.leetcode.medium;

public class Lee240 {


    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0;
        int y = m - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }else if (matrix[x][y] < target) {
                x++;
            }else {
                y--;
            }
        }
        return false;
    }

    /**
     * [1 2 3]
     * [4 5 6]
     * [7 8 9]
     * 算法错误
     */
    public boolean searchMatrixError(int[][] matrix, int target) {
        int index = matrix[0].length - 1;
        for (int i = 0; i < matrix[0].length - 1; i++) {
            if (target >= matrix[0][i] && target < matrix[0][i + 1]) {
                index = i;
            }
        }
        int left = 0;
        int right = matrix.length;
        while (left < right) {
            int mid = left + right >> 1;
            if (matrix[mid][index] == target) {
                return true;
            } else if (matrix[mid][index] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
