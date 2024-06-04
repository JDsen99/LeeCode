package com.ss.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/3/28 19:40
 */
public class T2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            Integer remove = list.remove(6 % list.size());
            System.out.println(remove);
        }
    }
}
