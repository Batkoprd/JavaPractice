package main.java.com.company.OOP_2;

import main.java.com.company.OOP_2.Interfaces.Flyable;
import main.java.com.company.OOP_2.Interfaces.Swimable;

public class Duck implements Flyable, Swimable { // класс должен переопределять методы из интерфейсов


    @Override
    public void fly() {
        System.out.println("Утка летит");

    }

    @Override
    public void swim() {
        System.out.println("Утка плавает");

    }
}
