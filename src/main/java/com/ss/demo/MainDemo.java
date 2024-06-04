package com.ss.demo;

/**
 * @author Senn
 * @date 2023/1/14 15:40
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println(Status.START);
        Status start = Status.valueOf("START");
        Status[] values = Status.values();
        for (Status value : values) {
            System.out.println(value);
        }
        System.out.println(start);
    }
}
