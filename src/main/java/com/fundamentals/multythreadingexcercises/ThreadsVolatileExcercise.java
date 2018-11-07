package com.fundamentals.multythreadingexcercises;

public class ThreadsVolatileExcercise {

    public static void main(String[] args) {
        System.out.println("In the main thread: about to check ninvoke the worker thread");
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        while (!worker.isTerminated()) {
            System.out.println("In the main thread, loop 1:  invoking the worker thread");
            t1.run();
        }
        while (!worker.isFinished()) {
            System.out.println("In the main thread, loop 2:  invoking the worker thread");
            //worker.testVolatile();
            worker.t2.run();
        }
        // At this point, the isTerminated variable is in the local cache of the worker thread. Hence for  the main thread, the updated
        // value set by the local thread is not available. Hence the loop  of execution does not end.


    }


}

class Worker implements Runnable {

    private boolean isTerminated = false;
    private volatile boolean isFinished = false;

    @Override
    public void run() {

        System.out.println("From Worker: The thread is not terminated ");

        try {
            Thread.sleep(300);
            System.out.println(" The var terminated is still false");
            setTerminated(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            testVolatile();
        }
    });

    public void testVolatile() {

        System.out.println(" The var isFinishsed is still false");
        setFinished(true);


    }


    public boolean isFinished() {
        return isFinished;
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}



