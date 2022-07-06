package main.java.com.company.Multithreading_2_7.Semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        // Semaphore - класс используется в том случае, когда есть какой-то ресурс
        // и много потоков используют этот ресурс и мы хотим ограничить использование
        // этого ресурса и делить его между всеми потоками

//        Semaphore semaphore = new Semaphore(3);
//        //permits кол-во разрешений, показывает сколько потоков, может пользоваться ресурсом, напр отправлять данные на сервер

//        try {
//            semaphore.acquire(); //вызываем когда в потоке начинаем взаимодействие с ресурсом
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        semaphore.release(); // отпускает одно из permits, чтобы его мог использовать другой поток,
//        // мы его вызываем когда в потоке заканчиваем использовать ресурс

//        System.out.println(semaphore.availablePermits()); // показывает разрешения

        /*
        Когда у нас есть ресурс, мы хотим ограничить доступ к ресурсу,
        когда мы в потоке начинаем, использовать ресурс мы в объекте semaphore вызываем
        метод acquire(), тем самым мы даем понять, что мы взяли одно разрешение и начали взаимодействовать
        с ресурсом. Когда мы закончили использовать ресурс мы вызываем метод release() и даем понять нашему
        semaphore, что мы закончили взаимодействовать с ресурсом, что одно разрешение освободилось и другой поток
        может начать взаимодействовать с ресурсом
         */

        //Вызовем doWork в 10 потоках
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown(); // вызываем, чтобы дать понять, что мы закончили сабмитить задания в наш executorService
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    //только один раз будет создан объект connection из-за приватного конструктора
    //этот паттерн программирования называется Singleton
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10); //мы хотим, чтобы было всего 10 разрешений в нашей системе

    private Connection() {

    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            System.out.println("Semaphore отпускает поток.");
            semaphore.release(); // метод release всегда должен вызываться в finally блоке
            // таким образом мы гарантируем, что даже в случае ошибки у нас будет вызван метод
            // release и разрешение будет отпущено
        }

    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println("connectionsCount: " + connectionsCount);
        }
        Thread.sleep(5000);
        synchronized (this) {
            connectionsCount--;
        }
    }
}

