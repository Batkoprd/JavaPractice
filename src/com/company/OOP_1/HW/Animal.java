package com.company.OOP_1.HW;

public class Animal {
    String type;
    String name;
    String color;
    int age;
    int run;
    boolean canSwim;
    int swim;
    static int counter;
    int animalCount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public int getSwim() {
        return swim;
    }

    public void setSwim(int swim) {
        this.swim = swim;
    }

    {
        this.type = this.getClass().getSimpleName();
        counter++;
        animalCount = counter;

    }


    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Animal(String name, String color, int age, int run, boolean canSwim, int swim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.run = run;
        this.canSwim = canSwim;
        this.swim = swim;
    }

    public void letsRun(int len) {
        if (run >= len) {
            System.out.println(type + " " + name + " can run " + len + " meters.");
        } else System.out.println(type + " " + name + " can't run " + len + " meters.");

    }

    public void letsSwim(int len) {
        if(canSwim) {
            if (swim >= len) {
                System.out.println(type + " " + name + " can swim " + len + " meters.");
            } else System.out.println(type + " " + name + " can't swim " + len + " meters.");
        } else System.out.println(type + " " + name + " can't swim.");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", run=" + run +
                ", canSwim=" + canSwim +
                ", swim=" + swim +
                ", animalCount=" + animalCount +
                '}';
    }
}
