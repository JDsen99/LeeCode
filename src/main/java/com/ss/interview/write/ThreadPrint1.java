package com.ss.interview.write;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint1 {

    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            resource.print(resource.condition1, resource.condition2);
        }).start();
        new Thread(() -> {
            resource.print(resource.condition2, resource.condition1);
        }).start();
    }

    static class Resource {
        int value = 0;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        void print(Condition cur, Condition next) {
            lock.lock();
            try {
                while (value < 10) {
                    value++;
                    System.out.println(Thread.currentThread().getName() + ": " + value);
                    next.signal();
                    cur.await();
                }
                next.signal();
            } catch (Exception ignored) {
            } finally {
                lock.unlock();
            }
        }
    }
}
