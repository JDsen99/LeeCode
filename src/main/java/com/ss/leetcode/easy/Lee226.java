package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Senn
 * @create 2022/2/9 11:48
 */
public class Lee226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
    /**
     * 层序遍历方式反转
     */
    public TreeNode invertTreeByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
