package com.ss.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class Lee406 {

    public static void main(String[] args) {
        int[][] p = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] ints = reconstructQueue(p);
//        Arrays.sort(p, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int[] anInt : ints) {

            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }
}

