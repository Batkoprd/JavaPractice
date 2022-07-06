package main.java.com.company.MultiThreading_1_6.Synchronization.wait_notify;


import java.util.Scanner;

public class WaitAndNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        // wait и notify два метода, которые определены у любого класса в джаве, тк они определены у Object
        // потому что мы можем синхронизироваться на любом объекте

        WaitAndNotify wn = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); // this.wait();
            // метод wait и notify могут вызываться только внутри синхронизованных блоков по умолчанию на this
            // 1) отдаем intrinsic lock(монитор) 2) ждем пока будет вызван метод notify
            // wait принимает разные аргументы timeout столько милисикунд поток будет ждать до вызова notify
            System.out.println("Producer thread resumed... ");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(2000); //поток поспит 2 секунды, чтобы поток produce точно был первым
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for return key pressed ");
            scanner.nextLine();
            notify(); //вызываем метод, чтобы на объекте this все объекты, которые ждут, проснулись
            // когда мы вызвали notify мы не освобождаем монитор, если мы его не освободим, то поток
            // который ждет не будет продолжать работу
            Thread.sleep(5000);
        }
    }
}

