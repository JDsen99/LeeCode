package com.ss.leetcode.easy;

import com.ss.struct.ListNode;

import java.util.List;

/**
 * @author Senn
 * @create 2022/1/27 11:04
 */
public class Lee141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
