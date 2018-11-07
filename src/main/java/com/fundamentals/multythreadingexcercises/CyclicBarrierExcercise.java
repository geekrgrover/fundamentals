package com.fundamentals.multythreadingexcercises;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExcercise {

    public static void main(String[] args) {
        ExecutorService executerServices = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All the threads are done executing... in the barrier's run method now");
            }
        });
        for (int i = 0; i < 5; i++) {
            executerServices.submit(new BarrierWorker(barrier, i + 1));
        }
        barrier.reset();
        System.out.println("After resetting the barrier.. about to create a new executor and submit the ececution, reusing the barrier ");
        ExecutorService secondExecutorService = Executors.newFixedThreadPool(5);
        for (int i = -0; i < 5; i++) {
            System.out.println("Invoking secondExecutorService.submit times " + i);
            secondExecutorService.execute(new BarrierWorker(barrier, i + 1));
        }
        secondExecutorService.shutdown();
        executerServices.shutdown();
    }


}

class BarrierWorker implements Runnable {
    Random random;
    int id = 0;
    CyclicBarrier cyclicBarrier;

    public BarrierWorker(CyclicBarrier barrier, int id) {
        this.random = new Random();
        this.id = id;
        this.cyclicBarrier = barrier;
    }

    @Override
    public void run() {
        doWork();

    }

    private void doWork() {
        System.out.println("Executing the thread " + this.id + " in the work method of worker class");
        try {
            System.out.println("Thread " + id + " about to enter into sleep");
            Thread.sleep(this.random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {

            System.out.println("Thread " + id + " about to invoke CyclicBarrier.await()");
            this.cyclicBarrier.await();
            System.out.println("Thread " + id + " after invoking await CyclicBarrier.await()");
        } catch (InterruptedException | BrokenBarrierException be) {
            be.printStackTrace();
        }
    }
}