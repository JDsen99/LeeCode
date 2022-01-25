package com.ss.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Senn
 * @create 2022/1/24 11:33
 */
public class Lee118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (i >= 2) {
                List<Integer> list1 = res.get(i - 1);
                for (int j = 1; j < i; j++) {
                    list.add(list1.get(j - 1) + list1.get(j));
                }
            }
            if(i>0) {
                list.add(1);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

}
