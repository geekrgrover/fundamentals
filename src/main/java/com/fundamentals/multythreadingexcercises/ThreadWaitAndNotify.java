package com.fundamentals.multythreadingexcercises;


class ThreadUtil {

    public void produce() throws InterruptedException {
        // The loch here would be intrinsic to the class since class reference is passed to synchronized.
        // This means when a thread acquires lock on this method, no other method in the class can be executed by other threads.
        synchronized (this) {
            System.out.println("In the produce method, b4 wait");
            wait();
            System.out.println("In the produce method, after wait");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            System.out.println("In the consume method.. yet to notify other threads");
            notifyAll();
            //Pls note that although the thred has notified other threads, the lines after notify() will be executed b4 threads can execute omn other methods
            Thread.sleep(1000);
            System.out.println("Notified from the consume method..");
        }
    }

}


public class ThreadWaitAndNotify {

    public static void main(String[] args) {
        // PlEASE NOTE THAT THE METHOIDS HAVE TO BE INVOKED ON THE SAME OBJECT REFERENCE IN ORDER FOR THE SYNCHRONIZATION TO WORK
        ThreadUtil util = new ThreadUtil();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    util.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    util.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        System.out.println("In the main metod .. b4 invoking threads");
        t1.start();
        t2.start();
        System.out.println("In the main metod .. both threads are invoked");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
