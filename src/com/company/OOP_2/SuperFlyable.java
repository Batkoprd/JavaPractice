package com.company.OOP_2;

public interface SuperFlyable extends Flyable{
    //интерфейсы могут наследоваться друг от друга
    //и наследуют все методы, которые нужно будет переопределять в классе
    void superFly();
}
