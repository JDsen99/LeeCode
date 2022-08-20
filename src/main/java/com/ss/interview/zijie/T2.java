package com.ss.interview.zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/29 15:45
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0, 3, list);
        System.out.println(list);
    }

    private static void dfs(StringBuilder sb, int l, int r, int len, List<String> res) {
        if (r == len && l == len) {
            res.add(sb.toString());
            return;
        }

        if (l < r) {
            return;
        }

        if (l < len) {
            sb.append("(");
            dfs(sb, l + 1, r, len, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < len) {
            sb.append(")");
            dfs(sb, l, r + 1, len, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
