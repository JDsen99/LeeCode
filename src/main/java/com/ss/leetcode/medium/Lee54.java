package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/28 10:52
 */
public class Lee54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        while (true) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[up][col]);
            }
            if (++up > bottom) break;
            for (int row = up; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (--right < left) break;
            for (int col= right; col >= left; col--) {
                res.add(matrix[bottom][col]);
            }
            if (--bottom < up) break;
            for (int row = bottom; row >= up; row--) {
                res.add(matrix[row][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

}
