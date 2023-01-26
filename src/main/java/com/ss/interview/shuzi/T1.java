package com.ss.interview.shuzi;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/10/15 18:08
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if (aChar >= 'A' && aChar <= 'Z') {
                res++;
            }
        }
        System.out.println(res);
    }
}
