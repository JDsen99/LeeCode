package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/25 10:50
 */
public class Lee40 {
    int[] candidates;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(new ArrayList<>(), 0, target);
        return res;
    }

    private void dfs(ArrayList<Integer> list, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {

            if (target - candidates[i] < 0) {
                return;
            }

            if (target - candidates[i] >= 0) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                dfs(list,i + 1, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
