package com.ss.interview.meituan;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/8/13 16:09
 */
public class M5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (num[i] - index * t >= 0) {
                index++;
            }
        }
        System.out.println(n - index + 1);
    }
}
