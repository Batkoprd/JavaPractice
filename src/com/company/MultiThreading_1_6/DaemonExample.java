package com.company.MultiThreading_1_6;

public class DaemonExample {
    public static void main(String[] args) {
        Thread tTimer = new Thread(() -> {
            int time = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println("time: " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //если в программе есть не сильно важный поток, который не жалко в любой момент остановить
        // – то такой поток можно сделать потоком демоном
        // Поток-демон работает до тех пор, пока работает хотя бы один обычный поток в приложении
        // потоки демоны никак не связаны с порождающими их потоками и завершают свою работу, когда работу завершает
        // главный поток
        tTimer.setDaemon(true);
//        tTimer.getState(); // получает состояние потока
//        tTimer.isAlive();
//        tTimer.setPriority(); //чем приоритет выше, тем больше процессорного времени ОС должна дать потоку
        tTimer.start();
//        tTimer.stop(); моментально останавливает поток, но мы не знаем в каком состоянии он находился, пользоваться нельзя
//        tTimer.interrupt(); // в потоке есть поле isInterrupted() которое при вызове interrupt() становится true
        System.out.println("main -> sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main -> end");
    }
}
