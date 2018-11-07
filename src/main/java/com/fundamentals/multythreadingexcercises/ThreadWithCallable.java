package com.fundamentals.multythreadingexcercises;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String> {
    int id = 0;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "id is " + id;
    }
}

public class ThreadWithCallable {


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<String>> futureList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Future<String> future = service.submit(new Processor(i + 1));
            if (future.isDone()) {

                futureList.add(future);
            }
        }

        for (Future<String> future : futureList) {
            try {
                System.out.println("The id's returned by processoer is" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

//    private Future<Integer> doCalculate() throws Exception {
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        return exec.submit(() -> {
//            try {
//                Thread.sleep(1000);
//                return  100 * 100;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        });
    //  }
}
