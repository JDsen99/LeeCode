package com.ss.leetcode.easy;

import com.ss.struct.ListNode;

/**
 * @author Senn
 * @create 2022/1/17 11:23
 */
public class Lee21_0 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1.next == null) return list1;
        if (list2.next == null) return list2;

        if (list1.val >= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
        }
        return list2;
    }
}
