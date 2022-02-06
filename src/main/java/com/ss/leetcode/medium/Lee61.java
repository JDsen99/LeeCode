package com.ss.leetcode.medium;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/2/6 9:38
 */
public class Lee61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = 0;
        ListNode tail = new ListNode();
        ListNode pre = head;
        while (pre != null) {
            tail = pre;
            pre = pre.next;
            n++;
        }
        k %= n;
        if (k == 0 ) return head;
        pre = head;
        while (pre != null && k-- >0) {
            pre = pre.next;
        }
        tail.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }
}
