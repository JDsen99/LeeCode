package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/10 10:57
 */
public class Lee89 {


    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(gray(i));
        }
        return ans;
    }

    /**
     * 计算第 n 个格雷码
     * 格雷码计算公式：G(n) = n xor (n >> 1)
     */
    public int gray(int n) {
        return n ^ (n >> 1);
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> grayCode1(int n) {
        /**
         *               000
         *       001     010     100
         *    011  101   110
         *  111
         */
        ans.add(0);
        dfs(0, 0, n);
        return ans;
    }

    public void dfs(int nodev, int initOffset, int n) {
        for (int offset = initOffset; offset < n; offset++) {
            int nextNodev = nodev ^ (1 << offset);
            ans.add(nextNodev);
            dfs(nextNodev, offset + 1, n);
        }
    }
}
