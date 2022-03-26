package com.ss.interview.write;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Senn
 * @create 2022/3/3 20:19
 */
public class PrintHundred {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();

        Resource resource = new Resource();

        new Thread(() -> {
            resource.printNum(resource.condition1,resource.condition2);
        }, "A").start();
        new Thread(() -> {
            resource.printNum(resource.condition2,resource.condition3);
        }, "B").start();

        new Thread(() -> {
            resource.printNum(resource.condition3,resource.condition1);
        }, "C").start();
    }

    static class Resource {
        int num = 0;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        public void printNum(Condition self, Condition next) {
            lock.lock();
            try {
                while (num < 99) {
                    num += 1;
                    System.out.println(Thread.currentThread().getName() + " --> " +num);
                    next.signal();
                    self.await();
                }
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
