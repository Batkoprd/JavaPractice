package main.java.com.company.OOP_1.HWsolution;
import main.java.com.company.OOP_1.HWsolution.animals.*;

public class MainAppHWSolution {
    public static void main(String[] args) {
        Animal[] animals = {
                new HouseCat("Barsik", 200),
                new Dog("Бобик", 1000, 50),
                new Tiger("Тигра", 10000, 500)
        };

        for (Animal a : animals) {
            a.run(800);
            a.swim(40);
        }

    }
}
