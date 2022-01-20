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
        dfs(new StringBuilder(),0,0,n,res);
        return res;
    }

    private void dfs(StringBuilder stringBuilder, int left, int right, int len,List<String> res) {
        if (left == len && right == len) {
            res.add(stringBuilder.toString());
            return;
        }
        if (left < right) return;
        if (left < len) {
            stringBuilder.append("(");
            dfs(stringBuilder,left + 1, right, len, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right < len) {
            stringBuilder.append(")");
            dfs(stringBuilder,left, right + 1, len, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
