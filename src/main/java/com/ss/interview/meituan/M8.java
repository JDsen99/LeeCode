package com.ss.interview.meituan;

import java.util.Scanner;

/**
 * @author Senn
 * @date 2022/8/20 15:34
 */
public class M8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int maxNum = num[0];
        int maxNumIndex = 0;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == maxNum && Math.abs(maxNumIndex - i) == 1) {
                maxNum ++;
            }
            if (num[i] > maxNum) {
                maxNum = num[i];
                maxNumIndex = i;
            }
        }
        int result = 0;
        for (int i = maxNumIndex; i < num.length; i = i + 2) {
            result += (maxNum - num[i]);
            num[i] = maxNum;
        }
        for (int i = maxNumIndex - 2; i >= 0; i = i - 2) {
            result += (maxNum - num[i]);
            num[i] = maxNum;
        }
        //遍历第二小
        int min = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == maxNum) continue;
            if (num[i] > min) {
                min = num[i];
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == maxNum) continue;
            result += (min - num[i]);
        }
        // 3 3 9 9
        // 3 1 1 1 9
        // 1 1 4 5 1 4
        System.out.println(result);
    }
}
