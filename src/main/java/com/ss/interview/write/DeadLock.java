package com.ss.interview.write;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Senn
 * @create 2022/3/3 20:13
 */
public class DeadLock {
    private static ReentrantLock lockA = new ReentrantLock();
    private static ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            lockA.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockB.lock();
        }).start();
        new Thread(()->{
            lockB.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockA.lock();
        }).start();
    }
}
