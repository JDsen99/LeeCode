package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

/**
 * @author Senn
 * @create 2022/1/24 11:14
 */
public class Lee112 {
    int targetSum;
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return hasSum(root,0);
    }
    private boolean hasSum(TreeNode root, int value){

        if (flag) return flag;

        if (root.right == null && root.left == null) {
            if (value == targetSum) {
                flag = true;
                return flag;
            }
        }
        value += root.val;
        return hasSum(root.left,value) || hasSum(root.right,value);
    }
}
