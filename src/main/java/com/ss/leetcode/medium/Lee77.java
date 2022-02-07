package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/7 11:00
 */
public class Lee77 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(1, 0, n, k, new ArrayList<>());
        return res;
    }

    private void dfs(int i, int times, int n, int k, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int j = i; j <= n - (k - list.size()) + 1; j++) {
            list.add(j);
            dfs(j + 1,times + 1 , n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
