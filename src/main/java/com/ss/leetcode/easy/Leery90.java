package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/29 11:02
 */
public class Leery90 {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret += (n & 1);
            n >>= 1;
        }
        return ret;
    }
}
