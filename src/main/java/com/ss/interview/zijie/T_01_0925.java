package com.ss.interview.zijie;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/25 19:20
 */
public class T_01_0925 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            int[] tem = nums[i];
            int m = Math.abs(tem[1] - tem[0]);
            if (m <= 0) {
                System.out.println(0);
                continue;
            }
            int step = 0;
            int index = 1;
            while (m > 0) {
                if (m - 2 * index >= 0) {
                    m -= 2 * index;
                    index++;
                    step += 2;
                }else {
                    if (Math.abs(m - index) <= 1) {
                        m = 0;
                        step++;
                    }else {
                        m = m - index;
                        step++;
                    }
                }
            }
            System.out.println(step);
        }
    }
}
