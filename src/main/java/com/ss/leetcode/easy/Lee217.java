package com.ss.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Senn
 * @create 2022/2/7 11:54
 */
public class Lee217 {

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return false;
        }

        //自定义hash表
        int[] hash = new int[length];
        int zeroNum = 0;
        for(int num : nums){
            if(num == 0 && zeroNum ++ > 0){
                return true;
            }
            int hashIndex = num%length;
            if(hashIndex < 0){
                hashIndex += length;
            }
            while(true){
                if(hash[hashIndex] == 0){
                    hash[hashIndex] = num;
                    break;
                }else if(hash[hashIndex] == num){
                    return true;
                }else{
                    if(++hashIndex >= length){
                        hashIndex -=  length;
                    }
                }
            }

        }
        return false;
    }
}
