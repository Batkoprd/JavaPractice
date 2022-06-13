package main.java.com.company.OOP_2.HW2Solution;

import java.util.ArrayList;
import java.util.List;

public class MainAppHW2Solution {
    public static void main(String[] args) {

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill(50));
        obstacles.add(new Wall(2));
        obstacles.add(new Treadmill(200));

        List<Contestant> contestants = new ArrayList<>();
        contestants.add(new Robot());
        contestants.add(new Human());
        contestants.add(new Cat());

        for (Contestant contestant : contestants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.contest(contestant)) break;
            }
        }
    }
}

interface Contestant {
    boolean run (int distance);
    boolean jump(int height);
}

class Cat implements Contestant {
    private int maxRunDistance;
    private int maxJumpHeight;

    Cat() {
        this.maxRunDistance = 150;
        this.maxJumpHeight = 2;
    }

    @Override
    public boolean run(int distance) {
        if (distance >= maxRunDistance) {
            System.out.println("Дистанция " + distance + " не по плечу " + this.toString());
            return false;
        }else {
            System.out.println(this.toString() + " успешно справляется с дистанцией в " + distance + " метров");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height >= maxJumpHeight) {
            System.out.println("Высота " + height + " не по плечу " + this.toString());
            return false;
        }else {
            System.out.println(this.toString() + " успешно справляется с прыжком на высоту " + height + " метров");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cat ";
    }
}

class Human implements Contestant {
    private int maxRunDistance;
    private int maxJumpHeight;

    Human() {
        this.maxRunDistance = 100;
        this.maxJumpHeight = 1;
    }

    @Override
    public boolean run(int distance) {
        if (distance >= maxRunDistance) {
            System.out.println("Дистанция " + distance + " не по плечу " + this.toString());
            return false;
        }else {
            System.out.println(this.toString() + " успешно справляется с дистанцией в " + distance + " метров");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height >= maxJumpHeight) {
            System.out.println("Высота " + height + " не по плечу " + this.toString());
            return false;
        }else {
            System.out.println(this.toString() + " успешно справляется с прыжком на высоту " + height + " метров");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Human ";
    }
}

class Robot implements Contestant {
    private int maxRunDistance;
    private int maxJumpHeight;

    Robot() {
        this.maxRunDistance = 400;
        this.maxJumpHeight = 20;
    }

    @Override
    public boolean run(int distance) {
        if (distance >= maxRunDistance) {
            System.out.println("Дистанция " + distance + " не по плечу " + this.toString());
            return false;
        }else {
            System.out.println(this.toString() + " успешно справляется с дистанцией в " + distance + " метров");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height >= maxJumpHeight) {
            System.out.println("Высота " + height + " не по плечу " + this.toString());
            return false;
        }else {
            System.out.println(this.toString() + " успешно справляется с прыжком на высоту " + height + " метров");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Robot  ";
    }
}

interface Obstacle {
    boolean contest(Contestant contestant);
}

class Treadmill implements Obstacle {

    private int length;

    Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.run(length)) {
            System.out.println(contestant.toString() + " пробежал дистанцию.");
            return true;
        } else {
            System.out.println(contestant.toString() + " не смог пробежать дистанцию!");
            return false;
        }
    }
}

class Wall implements Obstacle {

    private int heigth;

    Wall(int heigth) {
        this.heigth = heigth;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.run(heigth)) {
            System.out.println(contestant.toString() + " перепрыгнул стену.");
            return true;
        } else {
            System.out.println(contestant.toString() + " не смог перепрыгнуть стену!");
            return false;
        }
    }
}



