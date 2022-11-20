package com.tarasenko.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultithreadingExample {
    public static final int NUMBER_OF_FIXED_THREADS = 10;

    public static void main(String[] args) throws Exception {
        WorkThread workThread = new WorkThread();
        Thread thread1 = new Thread(workThread);

        Callable<Boolean> task = new WorkThread();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(NUMBER_OF_FIXED_THREADS);

        List<Future<Boolean>> tasks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_FIXED_THREADS; i++) {
            Future<Boolean> future = fixedThreadPool.submit(task);
            tasks.add(future);
        }
        tasks.add(singleThreadExecutor.submit(task));
        
        
        thread1.start();
        for (Future<Boolean> future : tasks) {
            future.get();
        }
        thread1.join();

        fixedThreadPool.shutdown();
        singleThreadExecutor.shutdown();

        Map<String, Integer> resultMap = WorkThread.sharedMap;
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
