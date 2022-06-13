package main.java.com.company.Generics_Collections_4.HW4;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxForFruits<T extends Fruit> {
    private ArrayList<T> container;
    private float currentWeight;

    public BoxForFruits() {
        this.container = new ArrayList<>();
    }

    public BoxForFruits(T... fruits) {
        this.container = new ArrayList<>(Arrays.asList(fruits));
    }

    public void addFruit(T fruit) {
        this.container.add(fruit);
    }

    public void addFruit(T... fruits) {
        this.container.addAll(Arrays.asList(fruits));

    }

    public float getWeight() {
        if (container.size() == 0) {
            return 0.0f;
        }
        return container.size() * container.get(0).getWeight();
    }

    public boolean compare(BoxForFruits<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001 ;
    }

    public void transfer(BoxForFruits<? super T> another) {
        if (this == another) {
            return;
        }
        another.container.addAll(this.container);
        this.container.clear();
    }

}
