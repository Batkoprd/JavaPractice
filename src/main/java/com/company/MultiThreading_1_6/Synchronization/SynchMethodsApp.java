package main.java.com.company.MultiThreading_1_6.Synchronization;
/*
При указании ключевого слова synchronized в объявлении метода в роли монитора выступает объект,
у которого был вызван синхронизированный метод. То есть в приведённом выше примере два потока
не могут параллельно выполнять method1() и method2().
 */
public class SynchMethodsApp {
    public static void main(String[] args) {
        SynchMethodsApp e1 = new SynchMethodsApp();
        SynchMethodsApp e2 = new SynchMethodsApp();
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
//        new Thread(() -> e1.method3()).start();
        //тк метод 3 несинхронизирован его можно выполнять параллельно с другим
        // синхронизированным методом
    }

    public synchronized void method1() {
        System.out.println("M1-START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M1-END");
    }


    public synchronized void method2() {
        System.out.println("M2-START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2-END");
    }


    public void method3() {
        System.out.println("M3-START");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M3-END");
    }
}
