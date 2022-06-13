package main.java.com.company.Multithreading_2_7.ThreadExceptions;

import java.util.concurrent.*;

public class ThreadExceptionApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<String> stringFuture = service.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {

                Thread.sleep(2000);
//                int x = 10/0;
                return "Java";
            }
        });

        /*
        ExecutionException возникает, когда поток работает некорректно, мы получим и ошибку выполнения и причину ее возниктовения

        */

        try {
            String result = stringFuture.get(); //код выдергивающий из future будет работать как join, т.е. будет ждать появления результата
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();


        // Вылетит исключение из потока, потому что main не имеет отношения к этому потоку
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = 1/0;
                }
            }).start();
        } catch (ArithmeticException e) {
            System.out.println("catched");
        }
    }
 }

