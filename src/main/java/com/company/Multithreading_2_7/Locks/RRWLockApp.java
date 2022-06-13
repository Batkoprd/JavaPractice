package main.java.com.company.Multithreading_2_7.Locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLockApp {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
/*
Может давать доступ потоку на чтение и запись, пока какой-то поток читает данные, то другой поток не может права
записывать данные и наоборот. В один момент времени любое количество потоков может читать данные, пока хоть один поток
данные читает, ни один поток не может данные записывать. Пока поток записывает другие потоки не имеют права читать.
В один момент времени только один поток может записывать данные.
Потоки становятся в очередь, т.е. если поток читает и придет записывающий поток, то он встанет в очередь, новые читающие потоки
не помешают записывающему потоку.
*/
        new Thread(() -> {
            rwl.readLock().lock();
            System.out.println("READING-start-a");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("READING-end-a");
            rwl.readLock().unlock();
        }).start();

        new Thread(() -> {
            rwl.readLock().lock();
            System.out.println("READING-start-b");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("READING-end-b");
            rwl.readLock().unlock();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rwl.readLock().lock();
            System.out.println("READING-start-c");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("READING-end-c");
            rwl.readLock().unlock();
        }).start();

        new Thread(() -> {
            rwl.writeLock().lock();
            System.out.println("WRITING-start-a");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WRITING-end-a");
            rwl.writeLock().unlock();
        }).start();

        new Thread(() -> {
            rwl.writeLock().lock();
            System.out.println("WRITING-start-b");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WRITING-end-b");
            rwl.writeLock().unlock();
        }).start();
    }
}

