package com.company.OOP_1.animals;

public abstract class Animal extends Object{ // все классы наследуются от класса Object

    // убрали модификатор доступа private, чтобы поля могли переходить к классам наследникам
    // модификатор default, но мы не хотим чтобы левые классы могли менять поля наследуемого класса
    // модификатор protected означает что поле доступно всем классам внутри пакета и всем наследникам
    // можно использовать объекты с одинаковыми именами из разных пакетов
    protected String name;
    protected String color;
    protected int age;



    public Animal() { // дефолтный конструктор
        this.name = "Unknown";
        this.color = "Unknown";
        this.age = 1;
    }

    public Animal(String name) { // как только создаем наш конструктор ^ дефолтный больше не работает,
        // если мы его не переобъявим его вручнуюю
        this.name = name;
        this.color = "Unknown";
        this.age = 1;
    }

    // конструкторов может быть сколько угодно. бывает что мы создаем объекты из разных источников из файла\потока\облака и тд
    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }





    public void info() {
        System.out.println(name + " " + color + " " + age);
    }

    // если в каком-то классе есть метод, который есть у наследников и каждый наследник должен по-своему его реализовывать
    // то мы создаем абстрактый метод, но абстрактые методы должны быть в абстрактных классах
    // мы не можем создать объект абстрактного класса

    public abstract void voice(); // наследние должен реализовать все абстрактые методы наследника
//    public void voice() {
//        System.out.println(name + " voice");
//    }

}
