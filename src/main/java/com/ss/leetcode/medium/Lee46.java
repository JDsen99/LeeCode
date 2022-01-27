package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/26 10:55
 */
public class Lee46 {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        dfs(new  boolean[nums.length],new ArrayList<>());
        return res;
    }

    private void dfs(boolean[] used, ArrayList<Integer> list) {

        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                dfs(used,list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
