package com.ss.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Senn
 * @date 2023/1/14 13:45
 */

public class StringTest {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        String s4 = s3.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
    }

    @Test
    public void uncheckProblem1() {
        final String s1 = new String("abc");
        String s2 = s1.intern();
        String s3 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }
    @Test
    public void demo1() {
        String str = new String("a") + new String("2");
        int[] a = new int[1];
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    public synchronized void demo2() {
        String str = "We are happy.";
        String[] ss = str.split(" ");
        StringBuilder sb = new StringBuilder();
    }
}
