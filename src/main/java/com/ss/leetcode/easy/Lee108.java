package com.ss.leetcode.easy;

import com.ss.struct.TreeNode;

/**
 * @author Senn
 * @create 2022/1/23 11:13
 */
public class Lee108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root。
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, low, mid - 1);
        root.right = dfs(nums, mid + 1, high);
        return root;
    }
}
