package com.ss.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数和
 * @author Senn
 * @create 2022/1/18 11:04
 */
public class Lee18_2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4) return res;

        int len = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            if ( (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target ) return res;
            if ( (long)nums[len-1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) return res;
            int sum = target - nums[i];
            for (int j = i + 1; j < len - 2; j++) {
                if ( j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l-1]) {
                        l ++ ;
                        continue;
                    }
                    if ((long)nums[i]+nums[j]+nums[l]+nums[r] > target) r--;
                    else if ( (long)nums[i]+nums[j]+nums[l]+nums[r] < target) l++;
                    else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
