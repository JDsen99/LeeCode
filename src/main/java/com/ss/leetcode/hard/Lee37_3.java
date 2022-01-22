package com.ss.leetcode.hard;

/**
 * @author Senn
 * @create 2022/1/22 9:54
 */
public class Lee37_3 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }

        if (board[row][col] != '.') {
            return backtrack(board,row,col + 1);
        }
        for (int num = 1; num <= 9; num++) {
            if (visited(board, row, col, (char)(num + '0'))) {
                board[row][col] = (char)('0' + num);

                if(backtrack(board, row, col + 1)) {
                    return true;
                }
                //暂时没有找到可行解 执行回退
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean visited(char[][] board, int row, int col, char targetNum) {
        for(int i = 0; i < 9; ++i) {
            //当前行是否已有该数
            if(board[row][i] == targetNum) {
                return false;
            }

            //当前列是否已有该数
            if(board[i][col] == targetNum) {
                return false;
            }

            //当前九宫格是否已有该数
            if(board[row - (row % 3) + i / 3][col - (col % 3) + i % 3] == targetNum) {
                return false;
            }
        }
        return true;
    }

    boolean[][] row = new boolean[9][10]; //标记x行存在的数字
    boolean[][] col = new boolean[9][10]; //标记y列存在的数字
    boolean[][][] block = new boolean[3][3][10]; //标记z块存在的数字
    boolean flag = true; //为false时表示当前填充出现问题
    public void solveSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) { //先标记好初始化存在过的数字
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                row[i][num] = true;
                col[j][num] = true;
                block[i / 3][j / 3][num] = true;
            }
        }
        dfs(board, 0, 0);
    }
    void dfs(char[][] board, int x, int y) {
        if (y >= 9) { //填充完当前行的所有列
            if (x + 1 <= 8) { //还没填充到最后一行
                dfs(board, x + 1, 0);
            } else { //已经填充完所有行和列
                flag = true;
            }
            return;
        }
        if (board[x][y] == '.') { //需要填充
            for (int num = 1; num <= 9; num++) { //尝试填充列表1~9
                if (row[x][num] || col[y][num] || block[x / 3][y / 3][num]) continue; //num被使用过
                board[x][y] = (char)('0' + num);
                row[x][num] = col[y][num] = block[x / 3][y / 3][num] = true;
                dfs(board, x, y + 1);
                if (flag) return; //填充完毕，直接返回
                row[x][num] = col[y][num] = block[x / 3][y / 3][num] = false;
                board[x][y] = '.';
            }
            flag = false; //出现问题，9个数字都不能正确填充，标记flag为false
        } else { //不需填充
            dfs(board, x, y + 1);
        }
    }

}
