package com.ss.leetcode.easy;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/28 11:31
 */
public class Lee160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode aNode = headA;
        ListNode bNode = headB;
        while (aNode != bNode) {
            aNode = aNode == null ? headB : aNode.next;
            bNode = bNode == null ? headA : bNode.next;
        }
        return aNode;
    }
}
