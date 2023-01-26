package com.ss.bluedot.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author Senn
 * @date 2023/1/14 19:22
 */
public class PrintJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + " : 任务「PrintJob」被执行。");
    }
}
