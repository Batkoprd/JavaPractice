package main.java.com.company.MultiThreading_1_6.HW6Solution;

import java.util.Arrays;

public class MainAppHW6_Solution {
   static final int ARRAY_LENGTH = 10_000_000;
   static final int HALF_LENGTH = ARRAY_LENGTH / 2;

    public static void main(String[] args) {
        oneThreadTask();
        twoThreadTask();

    }

    public static void oneThreadTask() {
        float[] arr = new float[ARRAY_LENGTH];
        Arrays.fill(arr, 1.0f);
        long time = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) *
                    Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }

    public static void twoThreadTask() {
        float[] arr = new float[ARRAY_LENGTH];
        Arrays.fill(arr, 1.0f);
        long time = System.currentTimeMillis();

        float[] leftArray = new float[HALF_LENGTH];
        float[] rightArray = new float[HALF_LENGTH];

        System.arraycopy(arr, 0, leftArray, 0, HALF_LENGTH);
        System.arraycopy(arr, HALF_LENGTH, rightArray, 0, HALF_LENGTH);

        Thread leftThread = new Thread(() -> {
            for (int i = 0; i < leftArray.length; i++) {
                leftArray[i] = (float) (leftArray[i] * Math.sin(0.2f + i/5) *
                        Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
        });

        Thread rightThread = new Thread(() -> {
            for (int i = 0, j = HALF_LENGTH; i < rightArray.length; i++, j++) {
                rightArray[i] = (float) (rightArray[i] * Math.sin(0.2f + j/5) *
                        Math.cos(0.2f + j/5) * Math.cos(0.4f + j/2));
            }
        });

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(leftArray, 0, arr, 0, HALF_LENGTH);
        System.arraycopy(rightArray, 0, arr, HALF_LENGTH, HALF_LENGTH);

        System.out.println("time: " + (System.currentTimeMillis() - time));

    }
}
