package com.fundamentals.multythreadingexcercises;

import java.util.ConcurrentModificationException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//The Reentrant lock is an alternative to synchronozed blocks and methods. Advantage is a lock put in a part of one method can be unlocked in another
// method provided it is done by same thread
public class ThreadReentrantLock {

    private static Lock lock = new ReentrantLock();
    private static int counter = 0;

    private static void increment() {
        try {
            lock.lock();
            //WHEN TRIED UP TO 1000, THE VALUES WERE NOT SHOWING A PROBLEM IN CONCURRENT EXECUTION. AT 10000,
            // IT STARTED SHOWING INCONSISTENCIES CONSISTENTLY!!
            for (int i = 0; i < 10000; i++) {

                ++counter;
            }
        } catch (ConcurrentModificationException | IllegalMonitorStateException cme) {
            System.out.println("AN exception occured while doing concurrent modification " + cme.getMessage());
        } finally {
            lock.unlock();
        }
    }

    private static void decrement() {
        try {

            lock.lock();
            for (int i = 0; i < 5000; i++) {
                counter--;
            }
        } catch (ConcurrentModificationException | IllegalMonitorStateException ex) {
            System.out.println("AN exception occured while doing concurrent modification " + ex.getMessage());
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //  lock.unlock(); --> Does not work. A thread cant unlock a lock put on method by another thread
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //  lock.unlock(); --> Does not work. A thread cant unlock a lock put on method by another thread
                increment();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //  lock.unlock(); --> Does not work. A thread cant unlock a lock put on method by another thread
                decrement();
            }
        });

        t1.start();
        t2.start();
        t3.start();

//        t1.run();
//        t2.run();
//        t3.run();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("The value of counter after thread executions is " + counter);
    }
}
