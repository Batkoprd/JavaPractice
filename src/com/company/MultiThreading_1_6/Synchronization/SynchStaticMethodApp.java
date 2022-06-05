package com.company.MultiThreading_1_6.Synchronization;

public class SynchStaticMethodApp {
    public static void main(String[] args) {
        SynchStaticMethodApp e = new SynchStaticMethodApp();
        new Thread(() -> classMethod()).start();
        new Thread(() -> e.objectMethod()).start();
    }
//Если мы повесили синхронизацию на статический метод, то это означает, что в один момент времени
    // только один поток может у данного класса вызывать синхронизированный статический метод, в роли монитора
    // выступает сам класс
    public synchronized static void classMethod() {
        System.out.println("Synch static Method start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Static Method End");
    }

    public synchronized void objectMethod() {
        System.out.println("Synch Method Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Synch Method End");
    }
}
