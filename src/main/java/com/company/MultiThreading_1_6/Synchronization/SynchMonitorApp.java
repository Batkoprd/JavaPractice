package main.java.com.company.MultiThreading_1_6.Synchronization;
/*
в роли монитора выступает объект monitor, соответственно, два потока смогут параллельно выполнять первую часть метода
method1(), однако в блок синхронизации в единицувремени может зайти только один поток,
так как захватывается монитор monitor.
© ВТБ
 */
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
            System.out.println("NonSynch block Begin " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println('.');
                Thread.sleep(200);
            }
            System.out.println("NonSynch block End " + Thread.currentThread().getName());
            synchronized (monitor) {
                System.out.println("Synch block Begin " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println('.');
                    Thread.sleep(200);
                }
                System.out.println("Synch block End " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
