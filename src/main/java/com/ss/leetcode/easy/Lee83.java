package com.ss.leetcode.easy;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/21 11:22
 */
public class Lee83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        pre.next = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
        }
        return pre.next;
    }
}
