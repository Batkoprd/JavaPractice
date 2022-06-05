package com.company.Multithreading_2_7.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
SingleThreadPool - пул потоков хранящий один поток, если возникает много мелких задач, которые
нужно в отдельном потоке выполнять, то запустили и периодически туда задачи кидаете, или если есть редкие задачи
которые занимают какое-то время.
FixedThreadPool - пул потоков с ограничением, создает некое кол-во потоков и потихоньку их подгружает.
CachedThreadPool - пул потоков без потолка, сколько задач не даешь он берет их на себя, т.е. если там
4 нагруженных потоков, то если туда закинуть еще 3 задачи, то он создаст еще 3 потока, если поток 60 секунд
ничего не делает, то он отключается
*/

public class ExecutorServiceApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int w = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(w + " - Begin");
                    try {
                        Thread.sleep(100 + (int) (3000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(w + " - End");
                }
            });
        }
        service.shutdown(); //екзекьюторсервис перестает принимать задачи и ждет пока все потоки выполнят всю свою работу
        //шатдаун нужно вызывать иначе программа будет висеть с потоками
    }
}
