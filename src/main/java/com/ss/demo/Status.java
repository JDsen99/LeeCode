package com.ss.demo;

/**
 * @author Senn
 * @date 2023/1/14 15:38
 */
public enum Status {
    START(0),
    END(1);
    private final int status;
    Status(int status) {
        this.status = status;
    }
}
