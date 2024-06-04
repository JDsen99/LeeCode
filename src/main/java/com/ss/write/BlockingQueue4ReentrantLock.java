package com.ss.write;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue4ReentrantLock {
    public static void main(String[] args) {
    }
}

class ReentrantBlockingQueue<T> {
    private final Queue<T> queue;
    private ReentrantLock addLock;
    private ReentrantLock popLock;
    private Condition addWaitCondition;
    private Condition popWaitCondition;
    private int capacity;

    public ReentrantBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<T>();
        this.addLock = new ReentrantLock();
        this.popLock = new ReentrantLock();
        this.addWaitCondition = this.addLock.newCondition();
        this.popWaitCondition = this.popLock.newCondition();
    }

    public T pop() throws InterruptedException {
        try {
            this.popLock.lock();
            while (queue.isEmpty()) {
                this.popWaitCondition.wait();
            }

            if (queue.size() == this.capacity) {
                try {
                    this.addLock.lock();
                    this.addWaitCondition.signalAll();
                } finally {
                    this.addLock.unlock();
                }
            }
            this.capacity--;
            return queue.poll();
        } finally {
            this.popLock.unlock();
        }
    }

    public void add(T t) {
        try {
            this.addLock.lock();
            while (queue.size() == capacity) {
                this.addWaitCondition.wait();
            }
            queue.add(t);
            this.capacity++;
            if (this.capacity == 1) {
                try {
                    this.popLock.lock();
                    this.popWaitCondition.signalAll();
                } finally {
                    this.popLock.unlock();
                }
            }
        } catch (InterruptedException ignored) {
        } finally {
            this.popLock.unlock();
        }
    }
}