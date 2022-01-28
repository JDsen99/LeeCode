package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/28 11:09
 */
public class Lee155 {
    private Node node;

//    public MinStack() {
//
//    }

    public void push(int x) {
        if (node == null){
            node = new Node(x, x);
        }else {
            // node = new Node(x, Math.min(x, node.min), node);
            Node next = new Node(x, Math.min(x, node.min));
            next.prev = node;
            node = next;
        }
    }

    public void pop() {
        node = node.prev;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    private class Node {
        int val;
        int min;
        Node prev;

        private Node(int val, int min){
            this.val = val;
            this.min = min;
        }

        private Node(int val, int min, Node prev){
            this.val = val;
            this.min = min;
            this.prev = prev;
        }
    }
}
