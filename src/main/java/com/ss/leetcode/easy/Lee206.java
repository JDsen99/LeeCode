package com.ss.leetcode.easy;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/2/7 11:43
 */
public class Lee206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return pre.next;
    }
}
