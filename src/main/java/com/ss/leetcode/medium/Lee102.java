package com.ss.leetcode.medium;

import com.ss.struct.ListNode;
import com.ss.struct.TreeNode;

import java.util.*;

/**
 * @author Senn
 * @create 2022/2/11 11:44
 */
public class Lee102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }

        return res;
    }
}
