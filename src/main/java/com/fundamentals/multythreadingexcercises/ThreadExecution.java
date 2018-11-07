package com.fundamentals.multythreadingexcercises;

public class ThreadExecution {
    private static Thread1 t1 = new Thread1();
    private static Thread2 t2 = new Thread2();

    // The main thread: This will be the first executed thread.
    public static void main(String[] args) throws InterruptedException {

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th1.start();
        //other threads will wait for th1 this thread to finish execution when join() is invoked.
        th1.join();
        th2.start();
        //Unless Thread.join() is invoked on thread invoked from within, the main thread will finish execution first.
        System.out.println("Finished thread execution");
    }


}

class Thread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("In class Thread 1");
        for (int i = 0; i < 10; i++) {
            System.out.println("Printing from Thread1.run: Iteration " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("In class Thread 2");
        for (int i = 0; i < 10; i++) {
            System.out.println("Printing from Thread2.run: Iteration " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
