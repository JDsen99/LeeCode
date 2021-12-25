package com.ss;

import com.ss.main.ListNode;

/**
 * @author Senn
 * @create 2021/12/25 16:13
 */
public class Lee2_1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //前置条件判断
        if (l1 == null || l2 == null) return null;
        //新建列表
        ListNode result = new ListNode();
        ListNode pre = result;
        int sum = 0;
        while (l1 != null && l2 != null) {

            ListNode temp = new ListNode();
            int tempNum = l1.val + l2.val;

            temp.val = ( sum + tempNum )% 10;
            sum = ( sum + tempNum ) / 10;

            pre.next = temp;
            pre = pre.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                ListNode temp = new ListNode();

                temp.val = ( sum + l1.val ) % 10;
                sum = ( sum + l1.val ) / 10;

                pre.next = temp;
                pre = pre.next;

                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                ListNode temp = new ListNode();

                temp.val = ( sum + l2.val ) % 10;
                sum = ( sum + l2.val ) / 10;

                pre.next = temp;
                pre = pre.next;

                l2 = l2.next;
            }
        }
        if (sum == 1) pre.next = new ListNode(1, null);
        return result.next;
    }
    public ListNode lee(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
