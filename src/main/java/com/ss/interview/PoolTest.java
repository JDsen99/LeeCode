package com.ss.interview;

import java.util.concurrent.*;

/**
 * @author Senn
 * @create 2022/3/24 11:47
 */
public class PoolTest {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(10,
                100,
                100,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"t1");
            }
        },new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
