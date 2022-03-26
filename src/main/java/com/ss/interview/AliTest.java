package com.ss.interview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/14 16:25
 */
public class AliTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = scanner.nextInt();
            }
            Arrays.sort(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (true) {
                int times = 0;
                for (int j = 4; j >= 0 && times < 4; j--) {
                    if (nums[i][j] > 0 ) {
                        times++;
                        nums[i][j]--;
                    }
                }
                if (times < 4) {
                    break;
                }else if (times == 4){
                    count++;
                }
            }
            System.out.println(count);
        }
    }


    private void test1() {
        int[] map = {1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = 0;
        for (int i = 2; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            Integer integer = Integer.valueOf(str, 16);
            res += map[integer - 1];
        }
        System.out.println(res);
    }
}
