package com.ss.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Senn
 * @create 2022/2/27 20:27
 */
public class M3Test {

    int res = 0;
    int m;
    public int solution(int[] A, int M) {
        Arrays.sort(A);
        m = M;
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(A[i]);
            dfs(i + 1, A, list);
        }
        return res;
    }

    private void dfs(int index, int[] nums,List<Integer> list) {
        res = Math.max(list.size(), res);
        boolean flag = true;
        for (int i = index; i < nums.length; i++) {
            for (Integer integer : list) {
                if ((nums[i] - integer % m) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(nums[i]);
                dfs(i + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
