package com.ss.interview.meituan;

import java.util.*;

/**
 * @author Senn
 * @date 2022/9/3 10:51
 */
public class M3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 1; i < n; i++) {
            num[i] = sc.nextInt();
        }
        char[] chars = sc.next().toCharArray();
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            set.add(chars[i - 1]);
            for (int j = i; j < n; j++) {
                if (list.contains(num[j])) {
                    list.add(j + 1);
                    set.add(chars[j]);
                }
            }
            System.out.print(set.size() + "\t");
            set.clear();
            list.clear();
        }
    }
}
