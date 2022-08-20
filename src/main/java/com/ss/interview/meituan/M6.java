package com.ss.interview.meituan;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author Senn
 * @date 2022/8/13 16:30
 */
public class M6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            q.addFirst(num[i]);
            q.addFirst(q.removeLast());
            q.addFirst(q.removeLast());
        }
        q.stream().forEach((i) -> System.out.print(i + "\t"));
    }
}
