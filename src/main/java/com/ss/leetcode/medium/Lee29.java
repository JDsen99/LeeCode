package com.ss.leetcode.medium;

/**
 * @author Senn
 * @create 2022/1/21 10:39
 */
public class Lee29 {

    public int divide(int dividend, int divisor) {
        int sign = (dividend ^ divisor) >= 0 ? 1 : -1;//判断符号
        dividend = -Math.abs(dividend);//都转换为负数
        divisor = -Math.abs(divisor);//都转换为负数
        int res = 0;
        //阈值，越界警告值
        int threshold = Integer.MIN_VALUE >> 1;
        while (dividend <= divisor) {
            int tmp = divisor;
            int times = 1;
            //tmp >= threshold，防止tmp一直往左移导致溢出
            while (tmp >= threshold && dividend <= (tmp << 1)) {
                tmp <<= 1;
                times <<= 1;
            }
            dividend -= tmp;
            res -= times;
        }
        //是否有溢出
        if (res == Integer.MIN_VALUE && sign == 1)
            return Integer.MAX_VALUE;
        return sign < 0 ? res : -res;
    }
}
