package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/7 11:21
 */
public class Lee78 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(1, nums, new ArrayList<>());
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            dfs(j + 1,nums, list);
            list.remove(list.size() - 1);
        }
    }
}
