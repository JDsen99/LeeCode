package com.ss.jdk;
import sun.misc.Unsafe;

import java.util.Optional;

/**
 * @author Senn
 * @date 2023/1/14 13:00
 */
public class Demo {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());
    }
}
