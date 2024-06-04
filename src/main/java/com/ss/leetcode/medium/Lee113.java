package com.ss.leetcode.medium;

import com.ss.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lee113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(root.left, targetSum, list);
        dfs(root.right, targetSum, list);
        list.remove(list.size() - 1);
    }
}
