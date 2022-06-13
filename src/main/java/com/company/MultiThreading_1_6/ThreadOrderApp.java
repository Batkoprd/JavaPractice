package main.java.com.company.MultiThreading_1_6;
/*
Мы не можем гарантировать порядок выполнения параллельных потоков, потому что они выполняются хаотично
*/
public class ThreadOrderApp {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).start();
    }
}
