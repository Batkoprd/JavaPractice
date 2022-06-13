package main.java.com.company.Multithreading_2_7.Concurrency;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreApp {
    public static void main(String[] args) {
        final Semaphore smp = new Semaphore(5);

        Runnable limitedCall = new Runnable() {
            int count = 0;
            public void run() {
                int time = 3 + (int)(Math.random() * 4.0);
                int num = count++;
                // в try может одновременно зайти permits потоков
                try {
                    smp.acquire(); // семафор берет поток
                    System.out.println("Поток #" + num + " начинает выполнять очень долгое действие " + time + " сек.");
                    Thread.sleep(time * 1000);
                    System.out.println("Поток #" + num + " завершил работу!");
                } catch (InterruptedException intEx) {
                    intEx.printStackTrace();
                } finally {
                    smp.release(); // семафор отпускает поток, должен быть в finally блоке
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
