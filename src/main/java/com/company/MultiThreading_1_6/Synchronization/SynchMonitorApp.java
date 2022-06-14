package main.java.com.company.MultiThreading_1_6.Synchronization;

public class SynchMonitorApp {
    private final Object monitor = new Object();

    public static void main(String[] args) {
    SynchMonitorApp e2 = new SynchMonitorApp();
    new Thread(() -> e2.method()).start();
    new Thread(() -> e2.method()).start();
    new Thread(() -> e2.method()).start();


    }

    public void method() {
        try {
            System.out.println("NonSynch-Begin " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println('.');
                Thread.sleep(200);
            }
            System.out.println("NonSynch-Eng " + Thread.currentThread().getName());
            synchronized (monitor) {
                System.out.println("Synch-Begin " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println('.');
                    Thread.sleep(200);
                }
                System.out.println("Synch-End " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}