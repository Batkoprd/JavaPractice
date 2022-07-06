package main.java.com.company.Multithreading_2_7.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProdConsExample3 {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>(); // обычная очередь не thread-safe
    private final int LIMIT = 10; // мы хотим, чтобы в нашей очереди было не более 10 элементов
    private final Object lock = new Object(); //объект для синхронизации, должен быть константой (final)

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    // когда размер очереди становится 10 мы вызываем метод wait
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify(); // когда мы кидаем элемент в очередь мы должны сообщить,
                // чтобы wait из while(size == 0) продолжил свою работу
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                int value = queue.poll(); // достаем элемент из очереди, очередь была 10, стала 9
                // когда появилось свободное место мы должны оповестить, что место освободилось метод produce
                System.out.println(value);
                System.out.println("Queue size is " + queue.size()); // всегда 9, потому что мы достали элемент из очереди
                // вывели его на экран
                lock.notify();
            }
            Thread.sleep(1000); // будем спать, чтобы produce успевал заполнять очередь
        }
    }
}

