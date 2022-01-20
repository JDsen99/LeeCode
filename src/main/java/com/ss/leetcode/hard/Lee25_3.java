package com.ss.leetcode.hard;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/18 9:35
 */
public class Lee25_3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode pre = temp;
        ListNode end = temp;

        while(end.next != null) {
            for (int i = 0; i < k && end.next != null; i++) {
                end = end.next;
            }
            if (end.next == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseNode(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return temp.next;
    }

    private ListNode reverseNode(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
