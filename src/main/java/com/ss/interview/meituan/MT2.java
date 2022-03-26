package com.ss.interview.meituan;

import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/12 17:00
 */
public final class MT2 {

    public final int test() {
        int n = 3;
        int m = 10;
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        //第一行进行处理
        for (int i = 0; i < n; i++) {
            if (arr[0][i] != 0) {
                dp[0][i] =  Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //这一行位置 是炸弹 则数字最大。
                if (arr[i][j] != 0) {
                    dp[i][j] =  Integer.MAX_VALUE;
                }else {
                    //前一行 对应位置是为炸弹
                    if (arr[i - 1][j] != 0) {
                        //由最小的转换而来 + 1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][0],dp[i - 1][1]), dp[i - 1][3]) + 1;
                    }else {
                        //前一行 没有炸弹
                        dp[i][j] =  dp[i - 1][j];
                    }
                }
            }
        }
        // dp 最后一行 判断最小值
        return  Math.min(Math.min(dp[m - 1][0],dp[m - 1][1]), dp[m - 1][3]);
    }

    public final int test(int i) {
        return i;
    }
}
