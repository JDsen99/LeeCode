package com.ss.leetcode.medium;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @author Senn
 * @create 2021/12/26 15:30
 */
public class Lee7_1 {

    public int reverse(int x) {
        //题目最重要的是 边界判断
        int res = 0;
        while ( x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            res = res * 10 + temp;
        }
        return res;
    }
}
