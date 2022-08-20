package com.ss.test;

/**
 * @author Senn
 * @create 2022/3/28 19:40
 */
public class T1 {

    public static void main(String[] args) {
        Integer integer = Integer.valueOf("11", 16);
        System.out.println(integer);
        check("11");
    }

    private static void check(String str) {
        char[] chars = str.toCharArray();
        int max = 0;
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                max = Math.max(max, aChar - '0');
            }
            if (aChar >= 'A' && aChar <= 'Z') {
                max = Math.max(max, aChar - 'A'  + 10);
            }
        }
        for (long i = Long.valueOf(str, max + 1); i <= Long.valueOf(str, 16); i++) {
            System.out.println((int)(i % (1e9 + 7)));
        }
    }
}
