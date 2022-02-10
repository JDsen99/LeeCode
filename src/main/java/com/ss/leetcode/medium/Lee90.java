package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/10 11:07
 */
public class Lee90 {

    List<List<Integer>> res;

    int[] nums;

    int len;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        dfs(0,new ArrayList<>());
        return res;
    }

    private void dfs(int i, ArrayList<Integer> list) {
        if(i > len) return;
        res.add(new ArrayList<>(list));
        for (int j = i; j < len; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            list.add(nums[j]);
            dfs(j + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
