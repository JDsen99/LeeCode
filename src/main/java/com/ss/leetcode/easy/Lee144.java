package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/27 11:08
 */
public class Lee144 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }
    private void preorder(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

}
