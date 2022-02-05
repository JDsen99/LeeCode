package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/5 11:13
 */
public class Lee59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int index = 0;
        int temp = 1;
        while (true) {

            index = left;
            while (up <= down && index <= right) {
                res[up][index++] = temp++;
            }
            if (++up > down) break;
            index = up;
            while (right >= left && index <= down) {
                res[right][index++] = temp++;
            }
            if (++right < left) break;
            index = right;
            while (down >= up && index >= left) {
                res[down][index--] = temp++;
            }
            if (++down < up) break;
            index = down;
            while (left >= right && index >= up) {
                res[left][index--] = temp++;
            }
            if (++left > right) break;
        }
        return res;
    }
}
