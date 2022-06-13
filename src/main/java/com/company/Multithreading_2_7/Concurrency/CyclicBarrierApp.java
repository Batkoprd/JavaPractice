package main.java.com.company.Multithreading_2_7.Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierApp {
    static final int THREADS = 5;
    public static void main(String[] args) {
        /*
        Когда нам необходимо засинхронизировать между собой этапы какого-то кол-ва потоков
        типа подготовка к скачкам, скачки начнутся, когда все лошади(потоки) будут готовы.
        */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS);

        for (int i = 0; i < THREADS; i++) {
            int count = i;
            new Thread(() -> {
                try {
                    System.out.println("Подготавливается " + count);
                    Thread.sleep(2500 + 500 * (int) (Math.random()*10));
                    System.out.println("Готов " + count);
                    cyclicBarrier.await(); //когда делаем await значение счетчика падает, когда счетчик сбрасывается в 0
                    // все потоки отпускаются и дальше начинают выполнять код
                    System.out.println("Поехал " + count);
                    cyclicBarrier.await(10, TimeUnit.SECONDS); //работает по кругу, снова 5, CountDownLatch можно только пересоздавать
                } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
