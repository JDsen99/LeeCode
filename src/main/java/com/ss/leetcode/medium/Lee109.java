package com.ss.leetcode.medium;

import com.ss.struct.ListNode;
import com.ss.struct.TreeNode;

public class Lee109 {

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        return buildTree(head, 0, n - 1);
    }

    private TreeNode buildTree(ListNode head, int left, int right) {
        if (left > right) return null;
        int mid = left + right >> 1;
        int mi = mid - left;
        ListNode cur = head;
        while (mi-- > 0) cur = cur.next;
        TreeNode treeNode = new TreeNode(cur.val);
        treeNode.left = buildTree(head, left, mid - 1);
        treeNode.right = buildTree(cur.next, mid + 1, right);
        return treeNode;
    }
}
