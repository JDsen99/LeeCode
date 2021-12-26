package com.ss.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * “1234”
 * 1234
 * “-12312423544235456534”
 * Integer.MIN_VALUE;
 * @author Senn
 * @create 2021/12/26 15:36
 */
public class Lee8_1 {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
    //截取 并判断 边界
    public static int myAtoi(String s) {
        s = s.trim();
        int res = 0;
        int flag = 1;
        int start = 0;
        if (s.length() == 0) return 0;
        if ('-' == (s.charAt(0))) {
            flag = -1;
            start = 1;
            if (s.length() == 1) return 0;
        }
        if ('+' == (s.charAt(0))) {
            start = 1;
            if (s.length() == 1) return 0;
        }
        if (s.charAt(start) < 48 || s.charAt(start) > 57)
            return 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 48 || c > 57) break;
            if (res > Integer.MAX_VALUE / 10) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (res == Integer.MAX_VALUE / 10 ) {
                if (flag == 1) {
                    if ( (c - '0') > Integer.MAX_VALUE % 10) return Integer.MAX_VALUE;
                }else {
                    if ( -(c - '0') < Integer.MIN_VALUE % 10) return Integer.MIN_VALUE;
                }
            }

            res = res * 10 + c - 48;
        }
        return flag == 1 ? res : -res;
    }

    private int lee(String str ) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
