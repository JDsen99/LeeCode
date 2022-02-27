package com.ss.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Senn
 * @create 2022/2/27 19:46
 */
public class M2Test {
    public int solution(String S, int[] X, int[] Y) {
        // write your code in Java SE 8
        Map<Integer,Integer> map = new HashMap<>();
        int len = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]){
                    if (Math.abs(X[i] * Y[i]) >= Math.abs(X[j] * Y[j])) {
                        len = Math.abs(X[i] * Y[i]);
                    }else {
                        len = Math.abs(X[j] * Y[j]);
                    }

                }
            }
        }
        int res = 0;
        for (int i = 0; i < X.length; i++) {
            if (Math.abs(X[i] * Y[i]) < len) res++;
        }
        return res;
    }
}
