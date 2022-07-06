package main.java.com.company.MultiThreading_1_6;

/*
Класс RunnableExampleClass реализует интерфейс Runnable, в теле метода run() прописан цикл, который
выводит в консоль числа от 0 до 9. Метод sleep() приостанавливает поток, из которого он был вызван,
на указанное число миллисекунд, в нём может быть сгенерировано исключение InterruptedException,
следовательно, его нужно вызывать в блоке try. В методе же main() создаётся два объекта типа
Thread, конструктору которых в качестве аргумента передаются объекты класса RunnableExampleClass,
после чего новые потоки запускаются с помощью метода start().
 */

public class RunnableExampleClass implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
                System.out.println("new thread: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableExampleClass()).start();
        new Thread(new RunnableExampleClass()).start();
    }
}
