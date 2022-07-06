package main.java.com.company.Multithreading_2_7.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Интерфейс Lock из пакета java.util.concurrent – это продвинутый механизм синхронизации потоков.
По гибкости он выигрывает в сравнении с блоками синхронизации.
    Основные отличия между Lock и синхронизированными блоками:
● Синхронизированные блоки не гарантируют, что сохранится порядок обращения потоков к
критической секции;
● Нельзя выйти из синхронизированного блока по времени ожидания ( timeout );
● Синхронизированные блоки должны полностью содержаться в одном методе. Lock может
быть захвачен в одном методе, а освобожден в другом.
 */
public class SimpleLockApp {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        /*
        unlock() должен быть вызван в блоке finally, чтобы замок был разлочен даже в случае исключений
        */

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.err.println("T-BEFORE-LOCK-FIRST");
//                    lock.lockInterruptibly(); реагирует на интерапт
                    lock.lock();
                    System.err.println("T-GET-LOCK-FIRST");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    System.err.println("T-END-FIRST");
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("T-BEGIN-SECOND");
                try {
                    if (lock.tryLock(10L, TimeUnit.SECONDS)) { //попытка захвата замка по таймауту
                        try {
                            System.err.println("T-LOCK-SECTION-SECOND");
                            try {
                                Thread.sleep(13000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } finally {
                            lock.unlock();
                            System.err.println("T-END-SECOND");
                        }
                    } else {
                        System.err.println("Не очень-то и нужно было...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
