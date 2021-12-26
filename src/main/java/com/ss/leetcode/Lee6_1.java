package com.ss.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"
 *
 * @author Senn
 * @create 2021/12/26 15:13
 */
public class Lee6_1 {

    public String convert(String s, int numRows) {

        //边界判断
        if (numRows < 2) return s;

        List<StringBuffer> resList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new StringBuffer());
        }
        //用于来回循环的条件 使 i在区间 0 - numRow - 1 中来回跳转 实现功能
        int i = 0, flag = 1;

        for (char c : s.toCharArray()) {
            resList.get(i).append(s.charAt(i));
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer stringBuffer : resList) {
            res.append(stringBuffer);
        }
        return res.toString();
    }

}
