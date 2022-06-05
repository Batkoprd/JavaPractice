package com.company.OOP_1;
import com.company.OOP_1.animals.Animal;
import com.company.OOP_1.animals.CatExtends;
import com.company.OOP_1.animals.Dog;

public class Main {
    public static void main(String[] args) {
        int c;
        // Cat cat - создаем ссылку на объект, сам объект кладется в heap(кучу), эта ссылка может
        // ссылаться на объект типа Cat() либо на его наследника,
        // оператор new выделяет память в heape под объект типа Cat(), после чего вызывается
        // конструктор из класса, он инициализирует объект и ссылка на объект кладется в cat

        Cat cat = new Cat("Barsik", "White", 2); // создаем объект класса Cat()
        Cat cat2 = new Cat("Murzik", "Black", 4);

//        Cat cat3;  // не инициализированный кот
//        cat3.info();

//        cat.name = " Barsik";
//        cat.color = "white";
//        cat.age = 2;
//        cat2.name = " Murzik";
//        cat2.color = "black";
//        cat2.age = 4;
        Cat.doSomething();

        Cat[] cats = new Cat[2]; // {null, null}
        cats[0] = new Cat("A", "A", 1);
        cats[1] = new Cat("B", "B", 2);
        cats[0].info();

        cat.info();
        cat2.info();

        // очередность стека: main -> int c -> cat1 -> cat2 -> doSomething -> int b
        // метод doSmth завершает свою работу и джава выкидывает из стека все что связано с doSmth
        // потом доходим до main и выкидываем все его локальные переменные, поэтому переменные main метода
        // выходят из стека последними
        // ссылка на объект может лежать в heapе, так и в стеке, как и примитивы
        doSomething();
        doSomething();

        // класс кот наследуюемый из класса animal
        CatExtends cat3 = new CatExtends("Vasya", "Orange", 5, 6);
        cat3.voice();

        Dog dog =new Dog("Bobik", "white", 4);
        dog.voice();


        // Main$1
//        Animal animal = new Animal() {
//            @Override
//            public void voice() {
//
//            }
//        };

        Animal cat4 = new CatExtends("A", "B", 1, 4);
        // наследники могут вызывать методы родителей, а наоборот нет
        if (cat4 instanceof CatExtends) {
            ((CatExtends) cat4).catMethod(); //вызываем catMethod из класса animal
        } else {
            System.out.println("не кот");
        }



        Animal[] catsAndDogs = {
                new CatExtends("Sneg", "White", 5, 3),
                new Dog("Sharik", "black", 4)
        };
        for (Animal o : catsAndDogs) {
            o.voice();
        }

        CatExtends cat5 = new CatExtends("A", "B", 2, 1);
        System.out.println(cat5);

        Box box1 = new Box("Green", 2);
        Box box2 = new Box("Green", 2);
        // зеленое и зеленое, размер одинаковы получим true
        System.out.println(box1.equals(box2));






    }
    public static void doSomething() {
        int b;

    }
}
