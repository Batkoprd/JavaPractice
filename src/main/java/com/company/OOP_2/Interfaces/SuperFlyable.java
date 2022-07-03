package main.java.com.company.OOP_2.Interfaces;

import main.java.com.company.OOP_2.Interfaces.Flyable;

public interface SuperFlyable extends Flyable {
    //интерфейсы могут наследоваться друг от друга
    //и наследуют все методы, которые нужно будет переопределять в классе
    void superFly();
}
