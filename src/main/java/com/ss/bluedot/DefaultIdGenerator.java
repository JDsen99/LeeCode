package com.ss.bluedot;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Senn
 * @date 2022/12/18 21:32
 */
public class DefaultIdGenerator implements IdGenerator<Integer>{

    private final AtomicInteger integer = new AtomicInteger(1);

    @Override
    public Integer getTaskId() {
        return integer.getAndIncrement();
    }

    @Override
    public Integer getInstanceId() {
        return integer.getAndIncrement();
    }

    @Override
    public Integer getDataId() {
        return integer.getAndIncrement();
    }
}
