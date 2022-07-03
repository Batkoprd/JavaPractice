package main.java.com.company.OOP_1.animals;

public abstract class CowExtendsAnimal extends AnimalAbstractSuperclass {
    @Override
    public void info() {
        System.out.println(name); // поле name недоступно вне пакета animals
        // в этом случае у класса Animal модификатор поля должен быть измене на protected
    }
}
