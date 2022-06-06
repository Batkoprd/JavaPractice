package com.company.Multithreading_2_7.HW_7;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore smp;

    public Tunnel() {
        this.smp = new Semaphore(HW7_MainApp.CARS_COUNT / 2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            if (!smp.tryAcquire()) { //если с tryAcquire не удалось захватить семафор, то машина готовится
                //и будем ждать когда нужно захватить, если удалось, то машина сразу начала этап
               System.out.println(c.getName() + " готовится к этапу(ждет): " +
                            description);
               smp.acquire();
            }
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +
                        description);
                smp.release();
        }
    }
}




