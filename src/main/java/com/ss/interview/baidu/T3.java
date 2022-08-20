package com.ss.interview.baidu;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 15:08
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int res = 0;
            for (int j = 1; j < num / j; j++) {
                if (num % j == 0) {
                    if (gcd(j, num / j) == 1) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
    static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
