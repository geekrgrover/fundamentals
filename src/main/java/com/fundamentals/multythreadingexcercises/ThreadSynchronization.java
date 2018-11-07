package com.fundamentals.multythreadingexcercises;

public class ThreadSynchronization {
    private static int xcounter = 0;

    //with synchronized, threads will wait for the completion of current thread which has hold
    private synchronized static void  increment() {
        ++xcounter;
    }

    static Thread th1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("The thread status - th1 :"+th1.getState());
            for (int i = 0; i < 10; i++) {
                increment();
                System.out.println("In th1: incrementing; the current value on xclounter is " + xcounter);
                //sleep(th1);
                th2.run();
            }


        }
    });

    static Thread th2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("The thread status - th2 :"+th2.getState());
            for (int i = 0; i < 10; i++) {
                increment();
                System.out.println("In th2: incrementing; the current value on xclounter is " + xcounter);
                //  sleep(th2);

            }

        }
    });

    private static void sleep(Thread t) {
        try {
            t.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        th1.run();
        System.out.println("The xcounter's value at the end of th1 & th2 run:" + xcounter);
       // th2.run();
        th1.join();
        th2.join();
        System.out.println("The thread status - th1 alive?:"+th1.isAlive());
        System.out.println("The thread status - th2 alive? :"+th2.isAlive());

    }
}
