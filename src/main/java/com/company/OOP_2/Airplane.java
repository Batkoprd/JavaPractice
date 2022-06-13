package main.java.com.company.OOP_2;

public class Airplane implements Flyable{

    @Override
    public void fly() {
        // Flyable.super.fly(); - дефолтный метод интерфейса
        System.out.println("Самолет летит");
    }
}
