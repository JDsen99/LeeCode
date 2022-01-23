package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/23 10:53
 */
public class Lee36 {
    boolean[][] row = new boolean[9][10]; //标记x行存在的数字
    boolean[][] col = new boolean[9][10]; //标记y列存在的数字
    boolean[][][] block = new boolean[3][3][10]; //标记z块存在的数字
    boolean flag = true; //为false时表示当前填充出现问题
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) { //先标记好初始化存在过的数字
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (row[i][num] || col[j][num]) return false;
                row[i][num] = true;
                col[j][num] = true;
                if ( block[i / 3][j / 3][num]) return false;
                block[i / 3][j / 3][num] = true;
            }
        }
        return true;
    }
}
