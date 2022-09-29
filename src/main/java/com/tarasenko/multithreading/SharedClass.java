package com.tarasenko.multithreading;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class SharedClass {
    @ToString.Include
    private static final AtomicInteger counter = new AtomicInteger();

    public Integer incrementCounter() {
        return counter.incrementAndGet();
    }
}
