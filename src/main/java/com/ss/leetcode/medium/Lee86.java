package com.ss.leetcode.medium;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/2/9 11:28
 */
public class Lee86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead;
        return smallHead;
    }
}
