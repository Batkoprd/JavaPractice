package com.company.MultiThreading_1_6.Race_Condition;

public class SynchCounterApp {
    public static void main(String[] args) {
        SynchCounter synchCounter = new SynchCounter();

        Thread incThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchCounter.inc();
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
                    synchCounter.dec();
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
        System.out.println("Значение счетчика: " + synchCounter.value());
    }
}
