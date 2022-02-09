package com.ss.leetcode.medium;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/2/9 11:20
 */
public class Lee82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }else {
            ListNode cur = head.next.next;
            while (cur != null && head.val == cur.val) {
                cur = cur.next;
            }
            return deleteDuplicates(cur);
        }
    }

}
