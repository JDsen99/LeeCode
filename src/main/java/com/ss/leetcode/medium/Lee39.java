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
        getSum(new ArrayList<>(),0,target);
        return res;
    }
    private void getSum(List<Integer> list,int index, int value) {
        if (value < 0 || index >= candidates.length) return;
        if (value == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            getSum(list,i,value - candidates[i]);
            list.remove(list.size() - 1);
        }

    }
}
