package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {

            executor.submit(new LatchWorker(countDownLatch, i + 1));
        }

        executor.submit(new LatchAdditionalWorker(countDownLatch, 6));

        try {
            System.out.println(" in main about to await for workers to complete; The current count is - " + countDownLatch.getCount());
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" the awaits are over ... execution back to main thread");
        executor.shutdown();

    }


}


class LatchWorker implements Runnable {

    CountDownLatch countDownLatch;
    int id = 0;

    public LatchWorker(CountDownLatch latch, int id) {
        this.countDownLatch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(" in the LatchWorker.. performing task");
        synchronized ("countdown") { // if not synchronized, will see more than one thread executing this block and printing same count more than once
            try {
                Thread.sleep(1000);
                this.countDownLatch.countDown();
                System.out.println(" The work is done in LatchWorker ..Id is " + id + "The new count is - " + countDownLatch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class LatchAdditionalWorker implements Runnable {
    CountDownLatch countDownLatch;
    int id;

    public LatchAdditionalWorker(CountDownLatch latch, int id) {
        this.countDownLatch = latch;
        this.id = id;

    }

    @Override
    public void run() {
        System.out.println(" in the LatchAdditionalWorker.. performing task");
        try {
            Thread.sleep(1000);
            System.out.println("in  LatchAdditionalWorker - before Countdiwn is invoked : Current count is - " + countDownLatch.getCount());
            this.countDownLatch.countDown();

            System.out.println(" work  done in  LatchAdditionalWorker is done ..Id is " + id + "The new count is - " + countDownLatch.getCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}