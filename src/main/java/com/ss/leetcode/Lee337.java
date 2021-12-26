package com.ss.leetcode;

import com.ss.struct.TreeNode;

public class Lee337 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int result = rab(root);
        System.out.println(result);
    }

    public static int rab(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    private static int[] helper(TreeNode root) {
        int[] res = new int[2];

        if (root == null) return res;

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
