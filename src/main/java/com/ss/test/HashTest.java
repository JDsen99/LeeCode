package com.ss.test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Senn
 * @create 2022/3/5 16:14
 */
public class HashTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(7);
//        System.out.println(map.size());
        map.put("", "");
        Integer integer = new Integer(1);
        HashSet<String> set = new HashSet<>();
        set.add("a");
        map.remove("");
        int i = tableSizeFor(9);
        set.remove("");
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1 << 31);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }


}
