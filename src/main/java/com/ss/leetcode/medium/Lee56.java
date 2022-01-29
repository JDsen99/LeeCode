package com.ss.leetcode.medium;

import java.util.Arrays;

/**
 * @author Senn
 * @create 2022/1/29 10:22
 */
public class Lee56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        int[][] res = new int[intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res[index][0] = start;
                res[index][1] = end;
                index++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }
        res[index][0] = start;
        res[index][1] = end;
        return Arrays.copyOfRange(res,0,index + 1);
    }

}
