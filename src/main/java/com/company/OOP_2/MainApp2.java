package main.java.com.company.OOP_2;

import main.java.com.company.OOP_2.Interfaces.Magic;
import main.java.com.company.OOP_2.Interfaces.Transport;

public class MainApp2 {


    // Наша цель заставить человека ездить на разных транспортных средства
    // и останавливать любое из них
    // тут мы создаем класс транспорта, учим его ездить, учим человека ездить на этом транспорте,
    // a потом слазить с транспорта. но все можно упростить с помощью интерфейса

    static class Human {
        private Transport currentTransport;
        private Magic magic; // если мы хотим делать трюки например


//        private Car lastCar;
//        private Skateboard lastSkateboard;
//        private Bicycle lastBicycle;

        public void stop() {
            if (currentTransport != null) {
                currentTransport.stop();
                currentTransport = null;
            } else {
                System.out.println("Я никуда и не еду");
            }

        }

        public void drive(Transport transport) {
            transport.start();
            this.currentTransport = transport;

        }

        // если мы хотим например делать трюки на скейте
        public void skateBoardParkActions() {
            if (!(currentTransport instanceof Skateboard)) {
                System.out.println("К сожалению я не на скейтборде. ");
                return;
            }
            Skateboard skateboard = (Skateboard) currentTransport;
            // делаем трюки

        }



//        public void drive(Car car) {
//            car.runCar();
//
//        }
//
//        public void drive(Skateboard skateboard) {
//            skateboard.runSkate();
//        }
//
//        public void drive(Bicycle bicycle) {
//            bicycle.runBicycle();
//        }


    }

    static class Car implements Transport{
        @Override
        public void start() {
            System.out.println("Машина поехала");
        }

        @Override
        public void stop() {
            System.out.println("Машина остановилась");

        }

    }

    static class Skateboard implements Transport, Magic{

        @Override
        public void start() {
            System.out.println("Скейт поехал");
        }

        @Override
        public void stop() {
            System.out.println("Скейт остановился");

        }

    }

    static class Bicycle implements Transport, Magic{
        @Override
        public void start() {
            System.out.println("Велосипед поехал");
        }

        @Override
        public void stop() {
            System.out.println("Велосипед остановился");

        }
    }

    static class Moto implements Transport{
        @Override
        public void start() {
            System.out.println("Мотоцикл поехал");
        }

        @Override
        public void stop() {
            System.out.println("Мотоцикл остановился");

        }
    }

    public static void main(String[] args) {

        // Человек может ехать на любом транспорте

        Transport transport = new Car();
        Human human = new Human();
        human.stop();
        human.drive(transport);
        human.stop();

    }
}
