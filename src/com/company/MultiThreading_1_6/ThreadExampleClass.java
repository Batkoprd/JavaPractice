package com.company.MultiThreading_1_6;

public class ThreadExampleClass extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread- "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new ThreadExampleClass();
        t.start(); //start а не run, run выполнит код метода в главном потоке, а не отдельном
        for (int i = 0; i < 10; i++) {
            System.out.println("main-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

