package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/5 10:51
 */
public class Lee57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int length = intervals.length;
        int i = 0;
        while (i < length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while (i < length && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
