package main.java.com.company.OOP_2;

import java.awt.*;

public class MainAppOuterClass {
    class Inner {
        /*
        Внутренний класс — это нестатический вложенный класс. Он имеет доступ ко всем переменным и
        методам своего внешнего класса и может ссылаться на них так же, как это делают остальные
        нестатические члены внешнего класса.
         */
        int innerValue;

        public Inner(int innerValue) {
            this.innerValue = innerValue;
        }

        public void innerMethod() {

            System.out.println("вызов значения innerValue класса Inner: " + innerValue);
            System.out.println("вызов outerValue методом innerMethod класса Inner: " + outerValue);
            outerMethod();
            System.out.println("---------------------------------");

        }
    }

    static class InnerStatic {
        /*
        Статическим называется такой вложенный класс, который объявлен с модификатором statiс, поэтому
        он должен обращаться к нестатическим членам своего внешнего класса посредством объекта. Это
        означает, что вложенный статический класс не может ссылаться непосредственно на нестатические
        члены своего внешнего класса
         */
        int innerStaticValue;

        public InnerStatic(int innerStaticValue) {
            this.innerStaticValue = innerStaticValue;
        }

        public void innerStaticMethod() {
            System.out.println("Метод innerStaticMethod класса InnerStatic: " + innerStaticValue);
            System.out.println("---------------------------------");
        }
    }

    // Внутренний класс имеет доступ ко всем полям и методам внешнего класс,
    // а внешний класс не имеет доступа к полям и методам внутреннего класса

    String outerValue = "outerValue";

    public void outerMethod() {
        System.out.println("метод outerMethod(): " + outerValue);
//        System.out.println(innerValue); нельзя вызывать константы и методы внутреннего класса
//        innerMethod();
        Inner inner = new Inner(10);
    }


    public static void main(String[] args) {
 //       Inner inner = new Inner(10); не можем создать тк статический метод без объекта которому можно привязать внутренний класс
        Inner inner = new MainAppOuterClass().new Inner(10);
        InnerStatic innerStatic = new InnerStatic(20);
        inner.innerMethod();
        innerStatic.innerStaticMethod();




        // Локальный класс, который объявлен внутри метода
        class LocalPoint {
            int x;
            public LocalPoint(int x) {
                this.x = x;
            }
            public void info() {
                System.out.println("Локальный класс LocalPoint с параметром x равным: " + x);
            }
        }

    }

}
