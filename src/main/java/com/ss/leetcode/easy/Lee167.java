package com.ss.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Senn
 * @create 2022/1/28 11:41
 */
public class Lee167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) return res;
            if (map.containsKey(numbers[i])) return new int[]{map.get(numbers[i]), i + 1};
            map.put(target - numbers[i], i + 1);
        }
        return res;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
}
