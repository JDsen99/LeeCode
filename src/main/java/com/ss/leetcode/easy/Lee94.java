package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/22 12:09
 */
public class Lee94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
