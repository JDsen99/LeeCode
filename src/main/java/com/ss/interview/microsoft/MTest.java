package com.ss.interview.microsoft;

/**
 * @author Senn
 * @create 2022/2/27 19:13
 */
public class MTest {
    public int solution(String S) {
        char[] chars = S.toCharArray();
        int length = chars.length;
        int[] dp = new int[length + 1];
        boolean[] used = new boolean[length + 1];
        used[0] = true;
        for (int i = 1; i <= chars.length; i++) {
            if (chars[i - 1] == '^' || chars[i - 1] == 'v') {
                used[i] = used[i - 1];
                dp[i] = dp[i - 1] + 1;
            }else if (chars[i - 1] == '<'){
                used[i] = used[i - 1];
                dp[i] = used[i - 1] ? dp[i - 1] + 1 : dp[i - 1];
            }else if (chars[i - 1] == '>'){
                used[i] = false;
                dp[i] = dp[i - 1];
                if (i == length) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        return dp[length];
    }
}
