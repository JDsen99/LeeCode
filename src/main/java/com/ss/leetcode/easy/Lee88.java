package com.ss.leetcode.easy;

/**
 * @author Senn
 * @create 2022/1/22 11:45
 */
public class Lee88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        while(n >= 0){
            //m >= 0是避免 nums1={0}的情况
            if(m >= 0 && nums1[m] > nums2[n]){
                //nums1 > nums2,则把nums1[m]放到nums1数组后面,m再自减一
                nums1[(m+n+1)] = nums1[m--];
            }else{
                //nums2 >= nums1,则把nums2[n]放到nums1数组后面,n再自减一
                nums1[(m+n+1)] = nums2[n--];
            }
        }
    }
}
