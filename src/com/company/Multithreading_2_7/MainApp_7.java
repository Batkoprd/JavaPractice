package com.company.Multithreading_2_7;

import java.util.concurrent.atomic.AtomicInteger;

public class MainApp_7 {

    private static Integer mon = 0;

    public static void main(String[] args) {
//        int w = 5;
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(finalI);
//                }
//            }).start();
//        }

/*
Когда мы инкрементируем mon, то создается новый объект Integer и mon начинает ссылаться на некго
т.е. тут у нас три разных монитора. Integer это иммутабельный(неизменяемый) тип данных.

 */
        new Thread(() -> {
            synchronized (mon) {
                System.out.println("1-start");
                mon++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1-end");
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("2-start");
                mon++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2-end");
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("3-start");
                mon++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3-end");
            }
        }).start();



    }
}
