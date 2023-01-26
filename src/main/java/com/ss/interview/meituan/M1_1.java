package com.ss.interview.meituan;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/3 10:03
 */
public class M1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if ( b < 11) {
            System.out.println(11 - a);
        } else {
            System.out.println(b - a + 2);
        }
    }
}
