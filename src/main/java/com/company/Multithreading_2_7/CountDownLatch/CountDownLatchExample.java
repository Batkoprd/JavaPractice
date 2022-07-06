package main.java.com.company.Multithreading_2_7.CountDownLatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); // три раза мы должны отсчитать, пока защелка не отопрется
        // CountDownLatch это класс при создании в который передаем число, которое означает сколько раз должны вызвать
        // метод countDown(), чтобы await() больше не ждал
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));
        }
        executorService.shutdown();

        countDownLatch.await();
        System.out.println("Latch has been opened, main thread is proceeding");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;
    private  static int i;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        i++;
        System.out.println(i);

        try {
            System.out.println("Поток спит 3 секунды.");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
