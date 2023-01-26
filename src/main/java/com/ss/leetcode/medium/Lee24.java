package com.ss.leetcode.medium;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/21 10:14
 */
public class Lee24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while (end.next != null && end.next.next != null) {
            end = end.next.next;
            start.next.next = end.next;
            end.next = start.next;
            start.next = end;
            start = start.next.next;
            end = start;
        }
        return pre.next;
    }

}
