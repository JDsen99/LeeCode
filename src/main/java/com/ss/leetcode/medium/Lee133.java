package com.ss.leetcode.medium;


import com.ss.struct.Node;

import java.util.*;

/**
 * @author Senn
 * @create 2022/2/15 11:48
 */
public class Lee133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(clone, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, lookup));
        }
        return clone;
    }

    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbor : temp.neighbors) {
                if (!lookup.containsKey(neighbor)) {
                    lookup.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                lookup.get(temp).neighbors.add(lookup.get(neighbor));
            }
        }
        return clone;
    }
}
