package com.ss.leetcode.hard;

/**
 * 正则表达式匹配
 * @author Senn
 * @create 2022/1/16 9:49
 */
public class Lee10_3 {

    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; //两边为空，匹配
        //p为空s不为空 肯定不匹配  s为空p不为空可匹配
        for (int i = 1; i < p.length() + 1; i++) {
            if (cp[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (cp[j - 1] == '*'){
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        //匹配0次 考虑此区间   i -> j-2
                        // 匹配一次 考虑区间 i-1 -> j-2
                        // 匹配多次 考虑区间 i-1 -> j
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        //不符合条件 直接比对 区间 i -> j-2 即  a* 匹配0个字符
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
