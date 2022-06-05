package com.company.Multithreading_2_7;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTypes {
    public static void main(String[] args) {
        //можно использовать для тонкой оптимизации вместо блока синхронизации
        AtomicInteger ai = new AtomicInteger(10);
        ai.addAndGet(10);
        System.out.println(ai);
        ai.getAndAdd(5);
        System.out.println(ai);


    }
}
