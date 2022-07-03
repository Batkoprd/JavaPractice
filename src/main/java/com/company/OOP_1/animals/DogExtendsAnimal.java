package main.java.com.company.OOP_1.animals;

public class DogExtendsAnimal extends AnimalAbstractSuperclass {
    public DogExtendsAnimal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public void voice() {
        System.out.println(name + ": gav-gav" + " - метод voice() класса Dog наследника класса Animal");
    }
}

