package com.ss.write;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private ListNode<K, V> head;
    private ListNode<K, V> tail;
    private Map<K, ListNode<K, V>> nodeMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(this.capacity, 1); // 空间优化: 负载因子修改为 1
        this.head = new ListNode<>();
        this.tail = new ListNode<>();
        this.head.setNext(this.tail);
        this.tail.setPre(this.head);
    }

    public boolean setValue(K k, V v) {
        if (this.nodeMap.containsKey(k)) {
            ListNode<K, V> curNode = this.nodeMap.get(k);
            curNode.setV(v);
            // TODO move2head;
            move2Head(curNode);
            return true;
        }
        while (this.nodeMap.size() >= capacity) {
            removeTailNode();
        }
        ListNode<K, V> node = new ListNode<>(k, v);
        move2Head(node);
        ListNode<K, V> putedNode = this.nodeMap.put(k, node);
        return putedNode == null;
    }

    private void removeTailNode() {
        ListNode<K, V> tailNode = releaseTailNode();
        if (tailNode == this.head) {
            return;
        }
        this.nodeMap.remove(tailNode.getK());
    }

    private ListNode<K, V> releaseTailNode() {
        ListNode<K, V> tailPreNode = this.tail.getPre();
        // 首节点特殊处理
        if (tailPreNode == this.head) {
            return tailPreNode;
        }
        tailPreNode.getPre().setNext(this.tail);
        this.tail.setPre(tailPreNode.getPre());
        tailPreNode.setPre(null);
        tailPreNode.setNext(null);
        return tailPreNode;
    }

    private void move2Head(ListNode<K, V> curNode) {
        if (curNode == this.head || curNode == this.tail) {
            return;
        }
        // 断开节点
        curNode.getPre().setNext(curNode.getNext());
        curNode.getNext().setPre(curNode.getPre());
        // 赋值与head.next
        curNode.setNext(this.head.getNext());
        this.head.getNext().setPre(curNode);
        this.head.setNext(curNode);
        curNode.setPre(this.head);
    }

    public V getValue(K k) {
        ListNode<K, V> curNode = this.nodeMap.get(k);
        if (curNode == null) {
            return null;
        }
        move2Head(curNode);
        return curNode.getV();
    }

}

class ListNode<K, V> {
    private ListNode<K, V> pre;
    private ListNode<K, V> next;
    private K k;
    private V v;

    public ListNode() {
    }

    public ListNode(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public ListNode<K, V> getPre() {
        return pre;
    }

    public void setPre(ListNode<K, V> pre) {
        this.pre = pre;
    }

    public ListNode<K, V> getNext() {
        return next;
    }

    public void setNext(ListNode<K, V> next) {
        this.next = next;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}