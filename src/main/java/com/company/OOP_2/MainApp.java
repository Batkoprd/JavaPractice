package main.java.com.company.OOP_2;

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
                                               // объекты реализующие интерфейст в ссылку на этот интерфейс
        // утка умеет и плавать, и летать, но у somethingFlyable можно вызвать метот только fly
        somethingFlyable.fly();

        // нельзя создавать объект интерфейса.









    }
}