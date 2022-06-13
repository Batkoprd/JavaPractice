package main.java.com.company.OOP_1.HW;

public class Tiger extends Animal{

    {
        setCanSwim(true);
        setRun(1000);
        setSwim(100);
        setColor("TigerStripe");
    }

    public Tiger() {
    }

    public Tiger(String name, int age) {
        super(name, age);
    }

    public Tiger(String name, String color, int age) {
        super(name, color, age);
    }

    public Tiger(String name, String color, int age, int run, boolean canSwim, int swim) {
        super(name, color, age, run, canSwim, swim);
    }
}
