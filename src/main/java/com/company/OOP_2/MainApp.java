package main.java.com.company.OOP_2;

import main.java.com.company.OOP_2.Classes.Airplane;
import main.java.com.company.OOP_2.Classes.Duck;
import main.java.com.company.OOP_2.Interfaces.Flyable;

public class MainApp {

    public static void main(String[] args) {

        Flyable[] flyables = {
                new Duck(), // утка летает можем закинуть в массив интерфейса, а рыба не летает ее не можем
                new Airplane() // добавим самолет к утке, потому что он тоже умеет летать
        };

        for (Flyable f : flyables) {
            f.fly();
        }

        Flyable somethingFlyable = new Duck(); // мы можем складывать
                                               // объекты реализующие интерфейс в ссылку на этот интерфейс
        // утка умеет и плавать, и летать, но у somethingFlyable можно вызвать метод только fly
        somethingFlyable.fly();
        // нельзя создавать объект интерфейса.
    }
}
