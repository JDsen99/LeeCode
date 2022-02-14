package com.ss.leetcode.medium;

import com.ss.struct.TreeNode;

/**
 * @author Senn
 * @create 2022/2/14 10:27
 */
public class Lee129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int i) {
        if (root == null ) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }
}
