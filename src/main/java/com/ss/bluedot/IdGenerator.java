package com.ss.bluedot;

/**
 * @author Senn
 * @date 2022/12/18 21:30
 */
public interface IdGenerator<T> {
    /**
     * 获取任务ID
     * @return T
     */
    T getTaskId();

    /**
     * 获取实例ID
     * @return T
     */
    T getInstanceId();

    /**
     * 获取数据ID
     * @return T
     */
    T getDataId();
}
