package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SynchronizedMapsExample {

    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        new Thread(new FirstWorker(map)).start();
        new Thread(new SecondWorker(map)).start();
    }


}

class FirstWorker implements Runnable {
    ConcurrentMap<String, Integer> cMap;

    public FirstWorker(ConcurrentMap map) {
        this.cMap = map;
    }

    @Override
    public void run() {
        try {

            cMap.put("MyName", 10);
            cMap.put("UrName", 20);
            Thread.sleep(1000);
            cMap.put("OtrName", 60);
        } catch (InterruptedException ex) {
            System.out.println("Exceptopn " + ex);
        }


    }
}

class SecondWorker implements Runnable {
    ConcurrentMap<String, Integer> cMap;

    public SecondWorker(ConcurrentMap map) {
        this.cMap = map;
    }

    @Override
    public void run() {
        try {


            Thread.sleep(1000);
            System.out.println(cMap.get("MyName"));
            Thread.sleep(1000);
            System.out.println(cMap.get("OtrName"));
            Thread.sleep(1000);
            System.out.println(cMap.get("UrName"));

        } catch (InterruptedException ex) {
            System.out.println("Exceptopn " + ex);
        }


    }
}