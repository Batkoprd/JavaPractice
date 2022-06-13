package main.java.com.company.OOP_1.animals;

import main.java.com.company.OOP_1.animals.Animal;

public final class CatExtends extends Animal { // final означает что у класса CatExtends не может быть наследников
                                                // если final в методе, то подклассы не смогут использовать этот метод
    int clawsLength;


    public CatExtends (String name, String color, int age, int clawsLength) {
        // наследник первой строкой кода обязан вызвать конструктор родителя
//        super();  вот так, это происходит виртуально, писать строку не обязательно
        this.name = name;
        this.color = color;
        this.age = age;
        this.clawsLength = clawsLength;
    }

    @Override  // мы показываем что метод был переопределен у родительского класса
    public void voice() {
//        super.voice(); // вариант родительского класса
        System.out.println(name + ": meow");
    }

    public void catMethod() {
        System.out.println("catMethod");
    }

    @Override
    public String toString() {
        return "CAT [" + name + " " + color + " " + age + " " + clawsLength + "]";
     }
}
