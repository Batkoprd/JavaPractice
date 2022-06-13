package main.java.com.company.OOP_1.HW;

public class Dog extends Animal{

    {
        setCanSwim(true);
        setSwim(10);
        setRun(500);
    }

    public Dog() {
    }

    public Dog(String name, String color, int age) {
        super(name, color, age);
    }

    public Dog(String name, String color, int age, int run, boolean canSwim, int swim) {
        super(name, color, age, run, canSwim, swim);
    }
}
