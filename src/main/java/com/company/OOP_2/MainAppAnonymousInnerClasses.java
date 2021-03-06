package main.java.com.company.OOP_2;

import main.java.com.company.OOP_2.Interfaces.Flyable;
import main.java.com.company.OOP_2.Interfaces.MyInterfaceSum;

public class MainAppAnonymousInnerClasses {
    public static void main(String[] args) {
        Flyable flyable = new Flyable() {
            @Override
            public void fly() {
                Flyable.super.fly();
            }
        };
        //com.company.OOP_2.MainAppAnonymousInnerClasses$1
        System.out.println(flyable.getClass().getName());

        // вот что происходит когда создается анонимный класс
//        public class MainAppAnonymousInnerClasses$1 implements Flyable {
//            @Override
//            public void fly(){
//
//            }
//        }
//        MainAppAnonymousInnerClasses flyable = new MainAppAnonymousInnerClasses();

        // Анонимные классы нужны тогда,
        // когда не нужно переиспользовать класс
        // Функциональный интерфейс - интерфейс с одним методом напр Runnable()

        new Thread(() -> System.out.println(1)).start(); // лямбда написание интерфейса

        doSomething(new MyInterfaceSum() {
            @Override
            public void sum(int a, int b, int c) {
                System.out.println(a + b + c);
            }
        });

        //пример сворачивания анонимного внутреннего класса в лямбду
        doSomething((a, b, c) -> {System.out.println(a + b + c);});
    }

    public static void doSomething(MyInterfaceSum myInterfaceSum) {
        System.out.println("Метод doSomething(MyInterfaceSum myInterfaceSum) реализующий функциональный интерфейc: ");
        myInterfaceSum.sum(1, 2, 3);
    }
}
