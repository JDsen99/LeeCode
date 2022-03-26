package com.ss.interview.t360;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 15:08
 */
public class T3 {
    public static void main(String[] args) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("1", "2");
        map.get("1");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] ints = new int[N][2];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
            sum += ints[i][1];
        }
        if (K >= N) {
            System.out.println(sum);
            System.exit(0);
        }
        int[][] dp = new int[N][K + 1];
        dp[0][0] = ints[0][1];
        int max = 0;
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[j][i - 1] > 0) {
                    for (int k = j + 1; k < N; k++) {
                        if (ints[k][0] - ints[j][0] <= M) {
                            dp[k][i] = Math.max(dp[k][i], dp[j][i - 1] + ints[k][1]);
                            max = Math.max(dp[k][i], max);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
