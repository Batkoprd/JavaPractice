package com.company.StreamAPI_8;

public class MainApp_8 {
    public static void main(String[] args) {

        //Анонимный внутренний класс Runnable, которому дается временное имя MainApp_8$1,
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Метод run с помощью Runnable");
            }
        }).start();

        new Thread(() -> System.out.println("метод run с помощью лямбды")).start();

        doSomething(() -> {
            for(int i = 0; i<5; i++) {
                System.out.println(i);
            }
        });

        doSomething(() -> System.out.println("А еще это можно заставить распечатать"));

    }

    public static void doSomething(Runnable runnableObj) {
        runnableObj.run();
    }
}


@FunctionalInterface //интерфейс, который делает 1 метод
interface MyInterface {
    void doSomething();

}