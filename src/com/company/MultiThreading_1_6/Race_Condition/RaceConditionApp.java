package com.company.MultiThreading_1_6.Race_Condition;

public class RaceConditionApp {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.inc();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread decThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.dec();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        incThread.start();
        decThread.start();

        try {
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Значение счетчика: " + counter.value());

        /*
        Race condition возникает, когда несколько потоков работают с одними и теми же данными
        */



    }
}
