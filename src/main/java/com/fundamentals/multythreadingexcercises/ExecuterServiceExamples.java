package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceExamples {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("In main thread");

        ExecutorService cachedService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            cachedService.execute(new ExecutionWorker());
        }
        cachedService.shutdown();
        ExecutorService fixedExecuter = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            fixedExecuter.submit(new ExecutionWorker());
        }
        fixedExecuter.shutdown();
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            System.out.println("Single thread ececutor pass- " + i);
            singleExecutor.submit(new ExecutionWorker());
            Thread.sleep(2000);
        }
        singleExecutor.shutdown();
    }


}

class ExecutionWorker implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Val of I " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
