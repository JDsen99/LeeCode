package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/26 11:04
 */
public class Lee47 {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(used, new ArrayList<>());
        return res;
    }

    private void dfs(boolean[] used, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            dfs(used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

}
