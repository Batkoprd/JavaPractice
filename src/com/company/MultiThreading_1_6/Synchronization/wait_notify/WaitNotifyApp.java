package com.company.MultiThreading_1_6.Synchronization.wait_notify;

public class WaitNotifyApp {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyApp waitNotifyApp = new WaitNotifyApp();

        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();

    }
    //Когда поток находится в состоянии wait он не тратит ресурсы процессора и среагирует только на notify

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') { //цикл while нужен потому что, когда потокА перешел в состояние wait
                        // то может быть, что поток кто-то разбудит, когда еще не пришла его очередь,
                        // а в цикле while он будет засыпать и ждать своей очереди
                        mon.wait();
                    }
                    System.out.println('A');
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.println('B');
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
