package com.ss.test;

/**
 * @author Senn
 * @date 2022/9/4 19:39
 */
public class ClassTest {
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
