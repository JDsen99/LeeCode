package com.ss.interview.meituan;

import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/19 9:43
 */
public class M2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        if (m == 1) {
            int l = (n + 1) / 2 - 1;
            int r = (n + 2) / 2 - 1;
            sb.append(str.charAt(l));
            if (l != r) sb.append(str.charAt(r));
            l--;
            r++;
            while (l >= 0 && r < n) {
                sb.append(str.charAt(l --));
                sb.append(str.charAt(r ++));
            }
            System.out.println(sb.toString());
        }else {
            char[] cs = new char[n];
            int cur = 0;
            int l =(n + 1) / 2 - 1;
            int r = (n + 2) / 2 -1;
            cs[l] = str.charAt(cur ++);
            if (l != r) cs[r] = str.charAt(cur ++);
            r++;
            l--;
            while (l >= 0 && r < n) {
               cs[l--] = str.charAt(cur ++);
               cs[r++] = str.charAt(cur ++);
            }
            System.out.println(new String(cs));
        }
    }
}
