package com.ss.leetcode.hard;

import com.ss.struct.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并k个链表
 *
 * @author Senn
 * @create 2022/1/17 9:34
 */
public class Lee23_3 {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode newNode = new ListNode();
        ListNode tail = newNode;
        while (!pq.isEmpty()) {
            ListNode smallNode = pq.poll();
            tail.next = smallNode;
            tail = smallNode;
            if (smallNode.next != null) {
                pq.offer(smallNode.next);
            }
        }
        return newNode;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int low, int high) {
        if (low == high) return lists[low];
        int mid = low + (high - low) / 2;
        ListNode l1 = merge(lists, low, mid);
        ListNode l2 = merge(lists, mid + 1, high);
        return merge2List(l1, l2);
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = merge2List(l1.next, l2);
            return l1;
        }
        l2.next = merge2List(l1, l2.next);
        return l2;
    }

}
