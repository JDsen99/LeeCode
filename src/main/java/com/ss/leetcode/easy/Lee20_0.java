package com.ss.leetcode.easy;

import java.util.Stack;

/**
 * (){}[]匹配
 * @author Senn
 * @create 2022/1/17 10:56
 */
public class Lee20_0 {

    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty()) return false;
                if (c != stack.pop()) stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
