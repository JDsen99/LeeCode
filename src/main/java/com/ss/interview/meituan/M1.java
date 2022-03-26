package com.ss.interview.meituan;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 9:43
 */
public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] discount = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            discount[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int sum = 0;
        int dis = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sum += num[i];
            dis += discount[i];
            if (i + 1 >= m) {
                int k = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (sum >= a[j]) {
                        k = Math.min(k, sum - b[j]);
                    }
                }
                if (k == dis) {
                    sb.append("B");
                }else if (k > dis){
                    sb.append("Z");
                }else {
                    sb.append("M");
                }
            } else {
                if (dis == sum) {
                    sb.append("B");
                }else {
                    sb.append("Z");
                }
            }
        }
        System.out.println(sb);
    }
}
