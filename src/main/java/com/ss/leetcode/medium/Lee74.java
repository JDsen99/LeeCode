package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/7 10:21
 */
public class Lee74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (matrix[mid][0] > target) right = mid - 1;
            if (matrix[mid][0] < target) left = mid;
            if (matrix[mid][0] == target) return true;
        }

        int row = left;
        left = 0;
        right = matrix[0].length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (matrix[row][mid] > target) right = mid - 1;
            if (matrix[row][mid] < target) left = mid;
            if (matrix[row][mid] == target) return true;
        }
        if (matrix[row][left] == target) return true;
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length - 1, columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }
}
