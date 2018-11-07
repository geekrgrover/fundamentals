package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueImplementations {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        new Thread(consumer).start();
        new Thread(producer).start();
    }


}

class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int taken = queue.take();
                System.out.println("Taking the integer.. " + taken);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true) {
            counter++;
            System.out.println("Inserting integer to queue " + counter);
            try {
                queue.put(counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}