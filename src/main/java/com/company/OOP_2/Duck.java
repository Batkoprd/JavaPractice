package main.java.com.company.OOP_2;

public class Duck implements Flyable, Swimable{ // класс должен переопределять методы из интерфейсов


    @Override
    public void fly() {
        System.out.println("Утка летит");

    }

    @Override
    public void swim() {
        System.out.println("Утка плавает");

    }
}
