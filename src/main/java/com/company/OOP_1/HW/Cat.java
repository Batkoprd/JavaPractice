package main.java.com.company.OOP_1.HW;

public class Cat extends Animal{



    {
        setCanSwim(false);
        setRun(200);
    }

    public Cat() {
    }

    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public Cat(String name, String color, int age, int run, boolean canSwim, int swim) {
        super(name, color, age, run, canSwim, swim);
    }


}
