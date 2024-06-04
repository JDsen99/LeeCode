package com.ss.demo;

/**
 * @author Senn
 * @date 2022/9/4 19:39
 */
public class ClassDemo {
    public static void main(String[] args) {
        System.out.println(Config.name);
    }
    static class Config {
        static {
            name = "BBBB";
        }
        {
            name = "AAAA";
        }
        public static String name;
    }
}
