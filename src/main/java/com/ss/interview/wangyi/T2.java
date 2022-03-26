package com.ss.interview.wangyi;

import java.util.*;

/**
 * @author Senn
 * @create 2022/3/26 14:00
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new T2().getTreasures(6, 10 , new int[][]{
                {1, 2, 4, 3}, {2, 3, 2, 2}, {3, 4, 1, 4}
        });
    }
    public int[] getTreasures (int packageSize, int wakeTime, int[][] treasureInfo) {
        // write code here
        int max_v = 0;
        int res = 0;
        for (int state = 0; state < (1 << treasureInfo.length); state++) {
            int sum0 = 0;
            int sum1 = 0;
            int sum2 = 0;
            int sum4 = 0;
            int max_range = 0;
            for (int i = 0; i < treasureInfo.length; i++) {
                if (((state >> i) & 1) == 1) {
                    sum4++;
                    max_range = Math.max(max_range, treasureInfo[i][1]);
                    sum1 += treasureInfo[i][2];
                    sum2 += treasureInfo[i][3];
                }
            }
            sum0 = max_range + sum4;
            if (sum0 <= packageSize && sum1 <= wakeTime) {
                if (sum2 > max_v) {
                    max_v = sum2;
                    res = state;
                }
            }
            sum0 = max_range + sum4;
            if (sum0 <= packageSize && sum1 <= wakeTime) {
                if (sum2 > max_v) {
                    max_v = sum2;
                    res = state;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < treasureInfo.length; i++) {
            if (((res >> i) & 1) == 1) {
                list.add(i + 1);
            }
        }
        int[] re = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            re[index++] = integer;
        }
        return re;
    }
}
