package main.java.com.company.Multithreading_2_7.Semaphore;
import java.util.concurrent.Semaphore;

public class SimpleSemaphoreApp {
    /*
    Semaphore ограничивает количество потоков при работе с ресурсами. Для этого служит счетчик. Если
    его значение больше нуля, то потоку разрешается доступ, а значение уменьшается. Если счетчик
    равен нулю, то текущий поток блокируется до освобождения ресурса. Для получения доступа
    используется метод acquire() , для освобождения – release()
     */
    public static void main(String[] args) {
        final Semaphore smp = new Semaphore(5);
        Runnable limitedCall = new Runnable() {
            int count = 0;
            public void run() {
                int time = 3 + (int)(Math.random() * 4.0);
                int num = count++;
                // в try может одновременно зайти permits потоков
                try {
                    smp.acquire(); // семафор берет поток
                    System.out.println("Поток #" + num + " начинает выполнять очень долгое действие " + time + " сек.");
                    Thread.sleep(time * 1000L);
                    System.out.println("Поток #" + num + " завершил работу!");
                } catch (InterruptedException intEx) {
                    intEx.printStackTrace();
                } finally {
                    System.out.println("Semaphore отпускает поток.");
                    smp.release(); // семафор отпускает поток, должен быть в finally блоке
                }
            }
        };
        /*
        С помощью метода acquire() одновременно захватить семафор могут только 5 потоков. Остальные
        становятся в очередь, пока один из «захватчиков» не освободит семафор методом release().
         */
        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
