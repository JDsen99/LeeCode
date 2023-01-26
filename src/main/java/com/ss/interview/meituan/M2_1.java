package com.ss.interview.meituan;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/9/3 10:12
 */
public class M2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            queue.add(num[i]);
        }
        for (int i = 0; i < n; i++) {
            int k = num[i];
            PriorityQueue<Integer> temp = new PriorityQueue<>(queue);
            temp.remove(k);
            int size = temp.size();
            for (int j = 0; j < size; j++) {
                if (temp.poll() != j) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
