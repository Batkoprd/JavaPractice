package com.company.OOP_1.HW;

import java.util.ArrayList;
import java.util.List;

public class MainHW {
    public static void main(String[] args) {

        Animal cat = new Cat("Sully", "white", 5);
        Animal dog = new Dog("Fluffy", "black", 3);
        Animal tiger = new Tiger("Johny", 1);

        List<Animal> list = new ArrayList<>();

        list.add(cat);
        list.add(dog);
        list.add(tiger);

        for (Animal a : list) {
            a.letsRun(300);
        }
        System.out.println();

        for (Animal a : list) {
            a.letsSwim(50);
        }

        System.out.println();
        System.out.println(cat.toString());
        System.out.println(dog.toString());
        System.out.println(tiger.toString());
    }
}
