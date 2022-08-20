package com.ss.interview;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Senn
 * @create 2022/3/23 17:24
 */
public class LockTest {

    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//        condition.await();
//        condition.signal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", 11);
        Long l = Long.valueOf(1);
        map.get("1");
        ConcurrentHashMap<String, Object> cmap = new ConcurrentHashMap<>(32);
        cmap.put("1", new Object());
        cmap.size();
        cmap.mappingCount();
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
//        list.get(1);
        System.out.println(tableSizeFor(32));
        BitSet bitSet = new BitSet();

        bitSet.set(2);
        bitSet.set(4);
//        BitSet bitSet2 = new BitSet();
//        bitSet2.set(1);
//        bitSet2.set(4);
//        bitSet.xor(bitSet2);
        char[] bytes = bitSet.toString().toCharArray();
        System.out.println(bytes.length);
        int[] ints = bitSet.stream().toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static void get() {
        String s = local.get();
        System.out.println(s);
    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
