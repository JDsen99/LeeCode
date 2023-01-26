package com.ss.bluedot.thread;

import java.util.concurrent.*;

/**
 * @author Senn
 * @date 2023/1/14 20:14
 */
public class BlueThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
