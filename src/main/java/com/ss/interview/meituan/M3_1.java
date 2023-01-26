package com.ss.interview.meituan;

import java.util.*;

/**
 * @author Senn
 * @date 2022/9/3 11:34
 */
public class M3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 1; i < n; i++) {
            num[i] = sc.nextInt();
        }
        char[] chars = sc.next().toCharArray();
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Node node = map.getOrDefault(i + 1, new Node());
            node.c = chars[i];
            List<Node> lists = node.getLists();
            for (int j = 1; j < n; j++) {
                if (num[j] == i + 1) {
                    Node orDefault = map.getOrDefault(j + 1, new Node());
                    lists.add(orDefault);
                    map.put(j + 1, orDefault);
                }
            }
            map.put(i + 1, node);
        }
        for (int i = 0; i < chars.length; i++) {
            Set<Character> set = new HashSet<>();
            bfs(map.get(i + 1), set);
            System.out.print(set.size() + "\t");
        }

    }

    private static void bfs(Node node, Set<Character> set) {
        if (node == null) return;
        set.add(node.c);
        List<Node> lists = node.getLists();
        for (int i = 0; i < lists.size(); i++) {
            bfs(lists.get(i), set);
        }
    }

    private static class Node{
        char c;
        List<Node> lists;
        public List<Node> getLists() {
            if (lists == null) {
                lists = new ArrayList<>();
            }
            return lists;
        }
    }
}
