package main.java.com.company.Multithreading_2_7.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample2 {
    public static void main(String[] args) throws InterruptedException {
        // Сейчас в методе main мы будем отсчитывать CountDownLatch, а в трех потоках будем ждать
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor2(i, countDownLatch));
        }
        executorService.shutdown();

        //Каждую секунду отсчитываем 1 от countDownLatch
        //пройдет 3 сек и 3 потока продолжат работу
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}


class Processor2 implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor2(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id " + id + " proceeded.");
    }
}

