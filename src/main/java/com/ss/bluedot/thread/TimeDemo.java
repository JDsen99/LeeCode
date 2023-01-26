package com.ss.bluedot.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Senn
 * @date 2023/1/10 19:39
 */
public class TimeDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        timer.schedule(timerTask, new Date());

    }
}
