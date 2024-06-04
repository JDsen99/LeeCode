package com.ss.demo;

/**
 * @author Senn
 * @date 2023/1/14 13:23
 */
public class MethodDemo {

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
        System.out.println(new MethodDemo().get("name", 18));
    }
}
