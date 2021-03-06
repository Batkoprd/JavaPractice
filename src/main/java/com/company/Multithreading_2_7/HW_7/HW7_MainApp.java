package main.java.com.company.Multithreading_2_7.HW_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class HW7_MainApp {
    public static final int CARS_COUNT = 4 ;

    public static void main (String[] args) {
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" );

        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT+1);

        Race race = new Race( new Road( 60 ), new Tunnel(), new Road( 40 ));
        Car[] cars = new Car[CARS_COUNT];
        for ( int i = 0 ; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + ( int ) (Math.random() * 10 ), cyclicBarrier);
            new Thread(cars[i]).start();
        }

        try {
            cyclicBarrier.await();
            System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" );
            cyclicBarrier.await(); //мешает машинам начать раньше, чем гонка начнется
            cyclicBarrier.await(); //все машины доедут и гонка закончится
            System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }



    }
}




