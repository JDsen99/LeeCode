package com.ss.interview.jd;

import java.util.*;

/**
 * @author Senn
 * @create 2022/3/19 15:08
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int p = sc.nextInt();
            List<Pair<Integer, Integer>> list = map.get(v);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new Pair<>(u, p));
            map.put(v, list);

            List<Pair<Integer, Integer>> list1 = map.get(u);
            if (list1 == null) {
                list1 = new ArrayList<>();
            }
            list1.add(new Pair<>(v, p));
            map.put(u, list1);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            Map<Integer,Integer> usedMap = new HashMap<>();
            usedMap.put(i, i);
            res = Math.max(res, dfs(map.get(i), usedMap, n, map));
        }
        System.out.println(res);
    }

    private static int dfs(List<Pair<Integer, Integer>> list, Map<Integer, Integer> usedMap, int n, Map<Integer, List<Pair<Integer, Integer>>> map) {
        int res = 0;
        for (Pair<Integer, Integer> pair : list) {
            if (!usedMap.containsKey(pair.key)) {
                usedMap.put(pair.key,pair.key);
                List<Pair<Integer, Integer>> list1 = map.get(pair.key);
                res = Math.max(res, Math.min(dfs(list1, usedMap, n, map), pair.value));
                usedMap.remove(pair.key);
            }
        }
        return res;
    }

    static class Pair<K, V>{
        K key;
        V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
