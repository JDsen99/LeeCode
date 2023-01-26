package com.ss.test;

/**
 * @author Senn
 * @date 2023/1/14 13:23
 */
public class MethodTest {

    private String get() {
        return "1";
    }
    private String get(String name) {
        return name;
    }

    public String get(String name, int age) {
        return get(name) + get() + name + age;
    }

    public static void main(String[] args) {
        System.out.println(new MethodTest().get("name", 18));
    }
}
