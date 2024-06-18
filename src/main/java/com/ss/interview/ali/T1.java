package com.ss.interview.ali;

import java.util.Arrays;

public class T1 {
    public static void main(String[] args) {
        // 0 1 1 1  = 5
        // 1 0 1 0 = 10    [1] [0] [1] [0] [1 0] [1 0 1] [0 1] [1 0 1 0] [0 1 0] [1 0]
        // 一个 由 0 1 组成的数组，求 相邻 不同的 子数组的 个数
        // 动态规划一下 dp[i] = 当前下标的 子数组个数
        int[] arr = new int[]{1, 0, 1, 0};
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                dp[i] += dp[i - 1];
        }
            res += dp[i];
        }
        System.out.println(res);
    }
}
