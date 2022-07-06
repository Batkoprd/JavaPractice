package main.java.com.company.MultiThreading_1_6;
/*
В классе Thread имеется несколько методов, которые можно переопределить в порожденном классе.
Из них обязательному переопределению подлежит только метод run(). Он же, безусловно,
должен быть определён и при реализации интерфейса Runnable. В большинстве случаев создавать подкласс,
порождённый от класса Thread, следует в случае, если требуется дополнить его новыми функциями. Так, если
переопределять любые другие методы из класса Thread не нужно, то можно ограничиться только
реализацией интерфейса Runnable. Кроме того, реализация интерфейса Runnable позволяет
создаваемому потоку наследовать класс, отличающийся от Thread.
 */

public class ThreadExampleClass extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread- "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new ThreadExampleClass();
        t.start(); //start а не run, run выполнит код метода в главном потоке, а не отдельном
        for (int i = 0; i < 10; i++) {
            System.out.println("main-" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

