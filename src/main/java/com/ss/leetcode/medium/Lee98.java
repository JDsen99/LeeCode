package com.ss.leetcode.medium;

import com.ss.struct.TreeNode;

/**
 * @author Senn
 * @create 2022/2/11 11:28
 */
public class Lee98 {
    private int pre = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
