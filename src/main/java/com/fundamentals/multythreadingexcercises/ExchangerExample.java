package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new FirstClass(exchanger)).start();
        new Thread(new SecondClass(exchanger)).start();
    }


}


class FirstClass implements Runnable {

    private int counter = 0;
    private Exchanger<Integer> exchanger;

    public FirstClass(Exchanger exchanger) {

        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter++;
            System.out.println("In the FirstClass .. incremented the counter to " + counter);
            try {
                counter = exchanger.exchange(counter);
                Thread.sleep(5000);
            } catch (InterruptedException exp) {
                System.out.println("exception " + exp);
            }
        }

    }
}


class SecondClass implements Runnable {

    private int counter = 0;
    private Exchanger<Integer> exchanger;

    public SecondClass(Exchanger exchanger) {
        //this.counter = counter;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter--;
            System.out.println("In the SecondClass .. decremented  the counter to " + counter);
            try {
                counter = exchanger.exchange(counter);
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println("exception " + ex);
            }
        }

    }
}