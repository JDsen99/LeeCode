package com.ss.interview.zijie;

import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/29 15:45
 */
public class T1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String str = "abcdefgh";
        char[] chars = str.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            swap(l++, r--, chars);
        }
        System.out.println(new String(chars));
    }
    private static void swap(int left, int right, char[] s) {
        s[left] ^= s[right];
        s[right] ^= s[left];
        s[left] ^= s[right];
    }
}
