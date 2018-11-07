package com.fundamentals.multythreadingexcercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum DownloaderEnum {

    //NOTE: for singleton implementation towards thread safety
    INSTANCE;
    //Semaphores are like permits. for example, the below implementation allows 5 threads to operate in parallel.
    //When there are more threads trying to access download method, they have to wait for this 5 in execution to be come available. Once free,
    //waiting threads will acquire them, in the order of their wait time, since we are setting fairness parameter as true below
    Semaphore semaphore = new Semaphore(5, true);

    public void downloadData() {
        try {
            semaphore.acquire();
            System.out.println("Acquired permit by thread ");

            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void download() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("downloading data..");
    }

}


public class SemaphoreImplementation {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 11; i++) {
            int count = i;

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("executing thread .. time " + count);
                    DownloaderEnum.INSTANCE.downloadData();
                }

            });
            Thread.sleep(2000);
        }
        executorService.shutdown();//  execurter service will not accept any more new tasks from now on
    }


}
