package main.java.com.company.OOP_1.HWsolution.animals;

public class Tiger extends Cat{
    public static int count;

    public Tiger() {
    }

    public Tiger(String name, int maxRunDistance, int maxSwimDistance) {
        super("Тигр", name, maxRunDistance, maxSwimDistance);
        count++;

    }
}
