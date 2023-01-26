package com.ss.interview.wangyi;

import java.util.*;

/**
 * 6
 * 3 1 3 4 3 4
 * 3
 * @author Senn
 * @date 2022/8/20 16:22
 */
public class W4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            List<Integer> list = map.getOrDefault(num[i], new ArrayList<>());
            if (!list.isEmpty()) {
                for (Integer integer : list) {
                    for (int j = integer; j < i; j++) {
                        if (num[j] < num[i]) {
                            result++;
                        }
                    }
                }
            }
            list.add(i);
            map.put(num[i], list);
        }
        System.out.println(result);
    }
}
