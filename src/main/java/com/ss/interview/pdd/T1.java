package com.ss.interview.pdd;

public class T1 {
    public void dfs(int n,int target) {
        if (n == target) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(n, target - i);
        }
    }
}
