package com.ss.interview.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Senn
 * @create 2022/3/26 14:00
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new T1().getMinimumTime(new int[]{5, 5, 6, 6, 10, 10, 10}, new int[][]{
                {0, 1, 5},
                {1, 0, 2},
                {5, 1, 0}
        }));
    }

    List<Integer> list = new ArrayList<>();

    public int getMinimumTime(int[] productList, int[][] drivingTimes) {
        // write code here
        int n =  drivingTimes.length;
        int m =  drivingTimes[0].length;
        for (int i = 0; i < m; i++) {
             dfs(n, m, i, drivingTimes ,drivingTimes[0][i]);
        }
        Object[] objects = list.toArray();
        Arrays.sort(objects);
        int times = (int) objects[0];
        Arrays.sort(productList);
        int length = productList.length;
        int cars = 4;
        int res = 0;
        while (true) {
            int[] cw = new int[4];
            int index = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (productList[i] == 10) {
                    cars--;
                    cw[index ++ ] = 10;
                    productList[i] -= 10;
                }
                if (cw[index] < 10 && productList[i] != 0 && cw[index] + productList[i] <= 10) {
                    cw[index] += productList[i];
                    productList[i] = 0;
                }
            }
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (productList[i] > 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                res += 1;
            }else {
                return (res + 1) * times;
            }
        }
    }

    private void dfs(int n, int m, int i, int[][] nums, int value) {
        if (i == m - 1) {
            list.add(value);
            return;
        }
        for (int j = i + 1; j < m; j++) {
            if (nums[i][j] != -1 && nums[i][j] != 0) {
                 dfs(n, m, j, nums, value + nums[i][j]);
            }
        }
    }
}
