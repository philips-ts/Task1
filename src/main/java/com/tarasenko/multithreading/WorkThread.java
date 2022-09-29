package com.tarasenko.multithreading;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class WorkThread implements Runnable, Callable<Boolean> {
    public static final Map<String, Integer> sharedMap = new ConcurrentHashMap<>();
    private static final SharedClass sharedClass = new SharedClass();

    private boolean threadProcedure() {
        long beforeTime = System.currentTimeMillis();

        sharedMap.put(Thread.currentThread().getName(), sharedClass.incrementCounter());

        long afterTime = System.currentTimeMillis();
        System.out.println("Thread '" + Thread.currentThread().getName() +
                "' execution time: " + (afterTime - beforeTime) + " ms.");

        return true;
    }


    @Override
    public void run() {
        threadProcedure();
    }

    @Override
    public Boolean call() {
        return threadProcedure();
    }
}
