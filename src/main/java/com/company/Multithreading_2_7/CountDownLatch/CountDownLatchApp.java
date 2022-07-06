package main.java.com.company.Multithreading_2_7.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
CountDownLatch позволяет потоку ожидать завершения операций, выполняющихся в других потоках.
Режим ожидания запускается методом await(). При создании объекта определяется количество
требуемых операций, после чего уменьшается при вызове метода countDown(). Как только счетчик
доходит до нуля, с ожидающего потока снимается блокировка.
 */
public class CountDownLatchApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 6;

        final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

        System.out.println("Начинаем");
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200 * w + (int)(500 * Math.random()));
                    countDownLatch.countDown();
                    System.out.println("Поток #" + w + " - готов");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа завершена");
    }
}

