package com.ss.interview.jd;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/3 19:59
 */
public class J1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        if (num.length < 2) {
            System.out.println(0);
            return;
        }
        Arrays.sort(num);
        int last = num[n - 1];
        int i = n - 1;
        for (; i >= 0; i--) {
            if (num[i] != last) {
                System.out.println(i + 1);
                break;
            }
        }
        if (i < 0) {
            System.out.println(0);
        }
    }
}
