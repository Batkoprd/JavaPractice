package main.java.com.company.Multithreading_2_7.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceApp_2 {
    public static void main(String[] args) {
        ExecutorService serv = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 12; i++) {
            String w = "#" + i;
            serv.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " - " + w + "-start");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " - " + w + "-end");
                }
            });
        }
        serv.shutdown();
    }
}