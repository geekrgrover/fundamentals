package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLockAwait {
    public static void main(String[] args) throws InterruptedException {
        WorkAwaiter aw = new WorkAwaiter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WorkAwaiter.producer();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WorkAwaiter.consumer();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}


class WorkAwaiter {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void consumer() throws InterruptedException {
        System.out.println("In the consumer method");
        lock.lock();
        condition.await();
        System.out.println("In the consumer method..locked");
        Thread.sleep(2000);
        System.out.println("In the consumer method..wait over");
        //NOTE: if singnal is called after unlock, have noticed this exception is thrown
        // Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
        condition.signal();
        lock.unlock();
        System.out.println("In the consumer unlocked ");

    }

    public static void producer() throws InterruptedException {
        System.out.println("In the producer method");
        lock.lock();
        System.out.println("In the producer method..locked");
        Thread.sleep(2000);
        condition.signal();
        lock.unlock();
        System.out.println("In the producer unlocked and notification sent");

    }
}

