package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/15 10:39
 */
public class Lee131 {
    public List<List<String>> partition(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0 ; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(dp, s, res, new ArrayList(), 0);
        return res;
    }

    private void dfs(boolean[][] dp, String s, List<List<String>> res, ArrayList<String> list, int index) {
        if (index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]){
                list.add(s.substring(index, i + 1));
                dfs(dp, s, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
