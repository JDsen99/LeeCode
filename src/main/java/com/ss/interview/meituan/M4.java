package com.ss.interview.meituan;

import java.util.*;

/**
 * 5
 * 1 2 2 3 4
 * 2 1 3 4 5
 * 1
 * @author Senn
 * @date 2022/8/6 10:28
 */
public class M4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Map<Integer, Map<Integer, Boolean>> result = new TreeMap<>();
        for (int i = 1; i <= len; i++) {
            int i1 = sc.nextInt();
            Map<Integer, Boolean> list = result.getOrDefault(i1, new HashMap<>());
            if (!list.containsKey(i)) {
                list.put(i, true);
            }
            result.put(i1, list);
        }
        for (int i = 1; i <= len; i++) {
            int i1 = sc.nextInt();
            Map<Integer, Boolean> list = result.getOrDefault(i1, new HashMap<>());
            if (!list.containsKey(i)) {
                list.put(i, false);
            }
            result.put(i1, list);
        }
        long num = -1;
        for (Map.Entry<Integer, Map<Integer, Boolean>> integerMapEntry : result.entrySet()) {
            Map<Integer, Boolean> value = integerMapEntry.getValue();
            if (value.size() > len / 2) {
                long count = value.values().stream().filter(aBoolean -> aBoolean).count();
                long count1 = value.values().stream().filter(aBoolean -> !aBoolean).count();
                if (num == -1) {
                   if (count > len / 2 || count1 > len / 2) {
                       num = 0;
                   }else {
                       num = Math.abs(count - count1);
                   }
                }else {
                    num = Math.min(Math.abs(count - count1), num);
                }
            }
        }
        System.out.println(num);
    }
}
