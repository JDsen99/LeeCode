package com.ss.leetcode;

/**
 * @author Senn
 * @create 2021/12/26 14:51
 */
public class Lee5_1 {

    public String longestPalindrome(String s) {
        // 因为所求为 一个字符串 所以 我们维护 一个 区间 用于 截取字符串
        int start  = 0, end  = 0;
        for (int i = 0; i < s.length(); i++) {
            //分别获取 单值 与双值的 最大长度
            int l1 = getLen(i, i, s);
            int l2 = getLen(i,i + 1, s);
            int len = Math.max(l1, l2);
            //判断 新的长度是否大于 区间 大于则更新
            if (len > end - start) {
                //减一 之后 除 2 则跟单双无关
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //ababd 2 3
        //dabbad 2 4 1
        return s.substring(start , end + 1);
    }

    private int getLen(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

}
