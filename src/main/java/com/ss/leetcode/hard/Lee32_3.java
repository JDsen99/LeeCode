package com.ss.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Senn
 * @create 2022/1/21 9:35
 */
public class Lee32_3 {
    /**
     * 自己想的 很慢 很大
     * @param s s
     * @return s
     */
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i > 0){
                for (int j = i; j >= 0; j--) {
                    if (s.charAt(j) == '(' && !dp[j]){
                        dp[i] = true;
                        dp[j] = true;
                        break;
                    }
                }
            }
        }
        int res = 0;
        int temp = 0;
        for (boolean b : dp) {
            if (b) {
                temp++;
            }else {
                res = Math.max(temp,res);
                temp = 0;
            }
        }
        return res;
    }

    /**
     * 栈
     * @param s  s
     * @return s
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res,i - stack.peek());
                }
            }
        }
        return res;
    }
}
