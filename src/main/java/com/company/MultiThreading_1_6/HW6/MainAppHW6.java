package main.java.com.company.MultiThreading_1_6.HW6;

import java.util.Arrays;

public class MainAppHW6 {
    static final int SIZE = 10_000_000 ;
    static final int HALF = SIZE / 2 ;

    public static void main(String[] args) {
        method1();

        method2();
    }

    public static void method1() {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) *
                    Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static void method2() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);



        long start = System.currentTimeMillis();
        float[] arr_1 = new float[HALF];
        float[] arr_2 = new float[HALF];

        System.arraycopy(arr, 0, arr_1, 0, HALF);
        System.arraycopy(arr, HALF, arr_2, 0, HALF);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr_1.length; i++) {
                    arr_1[i] = (float) (arr_1[i] * Math.sin(0.2f + i/5) *
                            Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
                }

            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j = HALF; i < arr_2.length; i++, j++) {
                    arr_2[i] = (float) (arr_2[i] * Math.sin(0.2f + j/5) *
                            Math.cos(0.2f + j/5) * Math.cos(0.4f + j/2));
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr_1, 0, arr, 0, HALF);
        System.arraycopy(arr_2, 0, arr, HALF, HALF);


        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
