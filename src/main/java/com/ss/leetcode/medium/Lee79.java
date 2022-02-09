package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/9 10:00
 */
public class Lee79 {

    int[][] direction  = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    boolean[][] used;

    char[][] board;

    char[] words;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.words = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        used = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == words[0]) {
                    used[i][j] = true;
                    if (dfs(i,j,1)){
                        return true;
                    }else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j,int index) {
        if (index == words.length) return true;
        for (int[] d : direction) {
            int row = i + d[0];
            int col = j + d[1];

            if (!inArea(row, col)) continue;

            if (used[row][col]) continue;

            if (board[row][col] != words[index]) continue;

            used[row][col] = true;
            if (dfs(row, row, index + 1)){
                return true;
            }else {
                used[row][col] = false;
            }
        }
        return false;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < this.board.length && col >= 0 && col < this.board[0].length;
    }
}
