package com.ss.interview.jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 15:07
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int k = d;
        int tan = b * d;
        int res = 0;
        while (a > 0 && k >0) {
            tan -= a;
            k = (tan + b - 1) / b;
            a -= k * c;
            res ++;
        }
        if (k > 0) {
            System.out.println("-1");
        }else {
            System.out.println(res);
        }
    }
}
