package com.ss.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Senn
 * @create 2022/3/23 17:24
 */
public class LockTest {

    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", 11);
        map.get("1");
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.get(1);
    }

    private static void get() {
        String s = local.get();
        System.out.println(s);
    }
}
