package com.fundamentals.multythreadingexcercises;

import java.util.ArrayList;
import java.util.List;


class ThreadRecUtil {

    public final Object lock = new Object();
    final int bottom = 0;
    final int limit = 5;
    List recList = new ArrayList();
    // Please note that the invocation of two methods in two threads will run in an infinite loop in their while loops.
    // when each of the  method's notify is executed, it will execute teh reminder of the code in that method before handing over the exeution to another thread.
    //So in thia case, it goes and checks the if condition, executes the code in if portion, if the condition satisfies. If not, it then hands over execution
    // to to the next thread which in this case invokes consume method. Same process happens there as well.


    public void consume() throws InterruptedException {
        synchronized (lock) {
            System.out.println("In the consume method..");
            while (true) {
                if (recList.size() == bottom) {
                    System.out.println("There is nothing to consume.. waiting for producer");
                    lock.wait();
                } else {
                    System.out.println("Consuming the item at location " + (recList.size() - 1));
                    recList.remove(recList.size() - 1);
                    //lock.wait(1000);
                    lock.notify();
                }
            }
        }

    }

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("In the produce method..");
            while (true) {
                System.out.println("recList size at the beginning of produce invoke " + recList.size());
                if (recList.size() == limit) {
                    System.out.println("recList reached max production.. sending notification for consumers..");
                    lock.wait();

                } else {
                    if (recList.size() < limit) {
                        System.out.println("There is more to produce.. producing " + recList.size());
                        recList.add((recList.size() + 1));
                        System.out.println("new recList size is " + recList.size());
                        lock.notify();
                    }
                }
            }
        }
    }
}

public class ThreadWaitAndNotifyAndRecursion {

    public static void main(String[] args) {
        System.out.println("In the main method");
        ThreadRecUtil util = new ThreadRecUtil();

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

        t1.start();
        t2.start();


    }


}
