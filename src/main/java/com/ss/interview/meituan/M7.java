package com.ss.interview.meituan;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/8/13 16:49
 */
public class M7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 1; i < num.length; i++) {
            for (int j = i + 1; j  < num.length; j++) {
                if (num[i - 1] + num[j] == 3 * num[i]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}
