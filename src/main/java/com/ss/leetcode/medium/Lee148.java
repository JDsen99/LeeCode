package com.ss.leetcode.medium;

import com.ss.struct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lee148 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = new Lee148().sortList(l1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            queue.offer(head);
            head = next;
        }
        ListNode pre = new ListNode();
        ListNode cur = pre;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        return pre.next;
    }
}
