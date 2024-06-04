package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/24 10:41
 */
public class Lee39 {
    int[] candidates;

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        res = new ArrayList<>();
        dfs(0, new ArrayList<>(), target);
        return res;
    }

    private void dfs(int index, ArrayList<Integer> list, int target) {
        if (target < 0 || index > candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

}
