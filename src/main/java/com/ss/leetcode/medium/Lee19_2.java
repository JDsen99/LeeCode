package com.ss.leetcode.medium;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/20 10:13
 */
public class Lee19_2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while (n-- > 0) {
            end = end.next;
        }
        while (end.next != null) {
            end = end.next;
            start = start.next;
        }
        start = start.next;
        return pre.next;
    }

}
