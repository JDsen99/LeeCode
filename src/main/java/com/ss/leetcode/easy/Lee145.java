package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Senn
 * @create 2022/1/27 11:13
 */
public class Lee145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                pre = root;
                root = null;
            } else {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
