package com.ss.interview.baidu;

import java.util.*;

/**
 * @author Senn
 * @create 2022/3/19 15:08
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        char[] chars = next.toCharArray();
        int len = chars.length;
        int l0 = -1;
        int l1 = -1;
        int r0 = -1;
        int r1 = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1' && l1 == -1) l1 = i;
            if (chars[i] == '0' && l0 == -1) l0 = i;
        }
        for (int i = len - 1; i > 0; i--) {
            if (chars[i] == '1' && r1 == -1) r1 = i;
            if (chars[i] == '0' && r0 == -1) r0 = i;
        }
        int l = -1, r = -1;
        int len0 = r0 - l0 + 1;
        int len1 = r1 - l1 + 1;
        if (len1 > len0) {
            l = l1;
            r = r1;
        }else {
            l = l0;
            r = r0;
        }
        System.out.print(l + 1 + " ");
        System.out.print(r + " ");
        System.out.print(l + 2 + " ");
        System.out.print(r + 1 + " ");
    }
}
