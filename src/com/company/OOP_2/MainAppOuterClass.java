package com.company.OOP_2;

public class MainAppOuterClass {
    class Inner {
        int innerValue;

        public Inner(int innerValue) {
            this.innerValue = innerValue;
        }

        public void innerMethod() {
            System.out.println(innerValue);
            System.out.println(outerValue);
            //outerMethod();

        }
    }

    static class InnerStatic {
        int innerStaticValue;

        public InnerStatic(int innerStaticValue) {
            this.innerStaticValue = innerStaticValue;
        }

        public void innerMethod() {
            System.out.println(innerStaticValue);
        }
    }

    // Внутренний класс имеет доступ ко всем полям и методам внешнего класс,
    // а внешний класс не имеет доступа к полям и методам внутреннего класса

    int outerValue;

    public void outerMethod() {
        System.out.println(outerValue);
//        System.out.println(innerValue); нельзя вызывать константы и методы внутреннего класса
//        innerMethod();
        Inner inner = new Inner(10);

    }


    public static void main(String[] args) {
 //       Inner inner = new Inner(10); не можем создать тк статический метод без объекта к оторому можно привязать внутренний класс
        Inner inner = new MainAppOuterClass().new Inner(10);
        InnerStatic innerStatic = new InnerStatic(20);

        // Локальный класс, который объявлен внутри метода
        class Point {
            int x;

            public Point(int x) {
                this.x = x;
            }

            public void info() {
                System.out.println(x);
            }
        }

    }
}
