package main.java.com.company.OOP_1.animals;

public final class CatExtendsAnimal extends AnimalAbstractSuperclass { // final означает что у класса CatExtends не может быть наследников
                                                // если final в методе, подклассы не могут переопределять final-метод.
                                                // public class B extends CatExtends { // Ошибка: класс CatExtends не может иметь подклассы
                                                // }
    int clawsLength;

    public CatExtendsAnimal(String name, String color, int age) {
        super(name, color, age);
        /*
        Ключевое слово super означает обращение к суперклассу.
        Такая конструкция позволяет заполнять даже поля суперкласса с модификатором доступа private.
        Если необходимо вызвать конструктор суперкласса через super() , то этот вызов должен быть
        первым оператором, выполняемым в конструкторе подкласса. Стоит отметить, что если мы этого не
        сделаем, то Java сама первой строкой в конструкторе подкласса будет осуществлять вызов
        конструктора по умолчанию из суперкласса.
         */
    }

    public CatExtendsAnimal(String name, String color, int age, int clawsLength) {
        // наследник первой строкой кода обязан вызвать конструктор родителя
        // super();  вот так, это происходит виртуально, писать строку необязательно
        this.name = name;
        this.color = color;
        this.age = age;
        this.clawsLength = clawsLength;
    }

    @Override  // мы показываем что метод был переопределен у родительского класса аннотация @Override не является
    // обязательной, она только проверяет действительно ли в родительском классе есть переопределяемый метод
    public void voice() {
    // super.voice(); вариант метода родительского класса
        System.out.println(name + ": meow" + " - метод voice() класса CatExtends наследника класса Animal");
    }

    public void catMethod() {
        System.out.println("catMethod" + " - метод catMethod класса CatExtends наследника класса Animal");
    }

    @Override
    public String toString() {
            return "Метод toString() класса CatExtends наследника класса Animal: " + "\n" +
                    "CAT [" + name + " " + color + " " + age + " " + clawsLength + "]";
     }
}

/*
Переопределение методов выполняется только в том случае, если имя, список аргументов и возвращаемый тип обоих методов
совпадают. В противном случае методы считаются перегруженными. Переопределенные методы позволяют поддерживать в Java
полиморфизм во время выполнения. Благодаря ему можно определить в общем классе методы, которые станут общими для всех
производных от него классов, а в подклассах — конкретные реализации некоторых или всех этих методов.
 */