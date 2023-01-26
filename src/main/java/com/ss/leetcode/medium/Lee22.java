package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/20 10:26
 */
public class Lee22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int left, int right, int n, StringBuilder stringBuilder, List<String> res) {
        if (left == n && right == n) {
            res.add(stringBuilder.toString());
            return;
        }
        if (right > left) return;
        if (left < n) {
            stringBuilder.append("(");
            dfs(left + 1, right, n, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right < n) {
            stringBuilder.append(")");
            dfs(left, right + 1, n, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
