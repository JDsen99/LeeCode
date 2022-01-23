package com.ss.leetcode.easy;


import com.ss.struct.TreeNode;

/**
 * @author Senn
 * @create 2022/1/23 11:00
 */
public class Lee101 {

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        return isTrue(root.left,root.right);
    }
    private boolean isTrue(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isTrue(left.left,right.right) && isTrue(left.right,right.left);
    }
}
