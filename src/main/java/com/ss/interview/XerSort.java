package com.ss.interview;

/**
 * @author Senn
 * @create 2022/2/20 17:15
 */
public class XerSort {

    public static void main(String[] args) {
        Object o = new Object();
        Object o1 = new Object();
        int i = o.hashCode();
        int i1 = o1.hashCode();
        Integer[] a = new Integer[]{1,1};
        String[] strs = new String[]{"2","2"};
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println("abc".hashCode());
        System.out.println("str1 = " + str1.hashCode());
        System.out.println("str2 = " + str2.hashCode());
        Object[] os = new Object[]{new Object(), new Object()};
        System.out.println(a[0].equals(a[1]));//ture 基本数据类型常量池
        System.out.println(strs[0].hashCode());
        System.out.println(strs[1].hashCode());
        System.out.println(strs[0].equals(strs[1]));// 是否加入常量池分析
        System.out.println(os[0].equals(os[1]));//false
        System.out.println(os.equals(os[0]));//false
    }

    public int[] sortArray(int[] nums) {
        //增量gap，并逐步缩小增量
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                while (j - gap >= 0 && nums[j] < nums[j - gap]) {
                    //插入排序采用交换法
                    swap(nums, j, j - gap);
                    j -= gap;
                }
            }
        }
        return nums;
    }

    private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
