package com.ss.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Senn
 * @create 2022/2/6 11:05
 */
public class Lee71 {
    public String simplifyPath(String path) {
        Deque<String> d = new ArrayDeque<>();
        int n = path.length();
        for (int i = 1; i < n; ) {
            if (path.charAt(i) == '/' && ++i >= 0) continue;
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') j++;
            String item = path.substring(i, j);
            if (item.equals("..")) {
                if (!d.isEmpty()) d.pollLast();
            } else if (!item.equals(".")) {
                d.addLast(item);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) sb.append("/" + d.pollFirst());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
