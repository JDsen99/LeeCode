package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/2/15 11:05
 */
public class Lee132 {
    int[] mins;
    int n;
    char[] cs;

    public int minCut(String s) {

        cs = s.toCharArray();
        n = cs.length;
        mins = new int[n];

        for (int i = 0; i < n; i++) {
            mins[i] = n;
        }

        for (int i = 0; i < n; i++) {

            expend(i, i);
            expend(i, i + 1);
        }
        return mins[n - 1];
    }

    public void expend(int left, int right) {

        while (left > -1 && right < n && cs[left] == cs[right]) {

            int i = --left, j = ++right;
            if (i == -1) {
                mins[j - 1] = 0;
            } else {
                int cur = mins[j - 1];
                int sub = mins[i] + 1;
                mins[j - 1] = Math.min(cur, sub);
            }
        }
    }
}
