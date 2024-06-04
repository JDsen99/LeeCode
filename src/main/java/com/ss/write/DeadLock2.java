package com.ss.write;

import java.util.concurrent.locks.Lock;

/**
 * @author Senn
 * @create 2022/3/3 20:15
 */
public class DeadLock2 {
    private static final Object resource_1 = new Object();

    private static final Object resource_2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource_1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource_2) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource_2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource_1) {

                }
            }
        }).start();
    }
}
