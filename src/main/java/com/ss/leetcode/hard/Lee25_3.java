package com.ss.leetcode.hard;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/18 9:35
 */
public class Lee25_3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            ListNode last = start.next;
            end.next = null;
            start.next = reverseNode(last);
            last.next = next;
            start = last;
            end = last;
        }
        return pre.next;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
