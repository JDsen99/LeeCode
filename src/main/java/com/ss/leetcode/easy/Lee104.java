package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

/**
 * @author Senn
 * @create 2022/1/23 11:08
 */
public class Lee104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
