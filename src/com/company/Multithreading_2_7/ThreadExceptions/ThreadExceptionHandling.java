package com.company.Multithreading_2_7.ThreadExceptions;

public class ThreadExceptionHandling {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 10;
                System.out.println(1);
                x = x / 0;
                System.out.println(2);
            }
        });
        //Thread.setDefaultUncaughtExceptionHandler(...); стандартный перехватчик для всех тредов через класс
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.out.println("Catched");
            }
        });
        t.start();
    }
}
