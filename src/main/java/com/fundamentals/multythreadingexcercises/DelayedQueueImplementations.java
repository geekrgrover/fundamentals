package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


public class DelayedQueueImplementations {

    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
        try {
            queue.put(new DelayedWorker(10000, "First worker"));
            queue.put(new DelayedWorker(100000, "second worker"));
            queue.put(new DelayedWorker(40000, "Third worker"));

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        while(!queue.isEmpty())
        {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

    class DelayedWorker implements Delayed {
        private long duration;

        private String message;

        public DelayedWorker(long duration, String message) {
            this.duration = duration;
            this.message = message;
        }


        @Override
        public long getDelay(TimeUnit unit) {

            return unit.convert((this.duration - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDuration() < ((DelayedWorker) o).getDuration()) {
                return -1;
            }
            if (this.getDuration() > ((DelayedWorker) o).getDuration())

            {
                return +1;
            }
            return 0;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.getMessage();
        }
    }

