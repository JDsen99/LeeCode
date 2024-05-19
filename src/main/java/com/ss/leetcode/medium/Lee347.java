package com.ss.leetcode.medium;

import java.util.*;

public class Lee347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll()[0];
        }
        return topK;
    }
}
