package com.ss.leetcode.medium;

import com.ss.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Lee662 {

    Map<Integer, Integer> levelMinMap = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode root, int depth, int index) {
        if (root == null) return 0;
        levelMinMap.put(depth, index);
        return Math.max(index - levelMinMap.get(depth) + 1,
                Math.max(
                        dfs(root.left, depth + 1, index * 2),
                        dfs(root.right, depth + 1, index * 2 + 1)));
    }
}
