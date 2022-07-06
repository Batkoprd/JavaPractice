package main.java.com.company.Multithreading_2_7.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceUsages {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ESExecute();
        System.out.println("---------------------------------");

        ESSubmitRunnable();
        System.out.println("---------------------------------");

        ESSubmitCallable();
    }

    public static void ESExecute() {
        System.out.println("Метод execute(Runnable) принимает объект java.lang.Runnable и выполняет его асинхронно. ");
        ExecutorService executorService = Executors.newFixedThreadPool ( 10 );
        executorService.execute( new Runnable() {
            public void run() {
                System.out.println( "execute(Runnable) - Асинхронная задача" );
            }
        });
        executorService.shutdown();

    }

    public static void ESSubmitRunnable() throws ExecutionException, InterruptedException {
        System.out.println("Метод submit(Runnable) также принимает реализацию Runnable, но возвращает объект типа Future,\n" +
                "который можно использовать для проверки завершенности выполнения задачи.");
            ExecutorService executorService = Executors.newFixedThreadPool ( 2 );
            Future future = executorService.submit (new Runnable() {
                public void run () {
                    System.out.println ("submit(Runnable) - Асинхронная задача" );
                }
            });
            future.get(); // вернет null если задача завершилась корректно
            executorService.shutdown();

    }

    public static void ESSubmitCallable() throws ExecutionException, InterruptedException {
        System.out.println("Экземпляр Callable также позволяет дать потоку задачу, но в отличие от Runnable, его метод call()\n" +
                "может возвращать результат. Результат Callable может быть получен через объект Future,\n" +
                "возвращенный методом submit.");
        ExecutorService executorService = Executors.newFixedThreadPool ( 2 );
        Future future = executorService.submit( new Callable(){
            public Object call() throws Exception {
                System.out.println( "submit(Callable) - Асинхронный вызов" );
                return "Результат из потока" ;
            }
        });
        System.out.println( "submit(Callable) - future.get() = " + future.get());
        executorService.shutdown();

    }



}
