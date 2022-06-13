package main.java.com.company.OOP_2.HW;
import main.java.com.company.OOP_2.HW.Competitors.Cat;
import main.java.com.company.OOP_2.HW.Competitors.Competitor;
import main.java.com.company.OOP_2.HW.Competitors.Human;
import main.java.com.company.OOP_2.HW.Competitors.Robot;
import main.java.com.company.OOP_2.HW.Obstacles.Obstacle;
import main.java.com.company.OOP_2.HW.Obstacles.Wall;

import java.util.Random;

public class MainHW2 {
    public static void main(String[] args) {

        Random random = new Random();
        Obstacle[] obstacles =  {
                new Wall.Track(random.nextInt(100, 3000)),
                new Wall(random.nextDouble(0.5, 2.0)),
                new Wall.Track(random.nextInt(100, 3000)),
                new Wall(random.nextDouble(0.5, 2.0)),
        };

        Competitor[] competitors = {
                new Human("John", random.nextDouble(0.5, 2.0), random.nextInt(100, 3000)),
                new Cat("Snowball", random.nextDouble(0.5, 2.0), random.nextInt(100, 3000)),
                new Robot("Optimus", random.nextDouble(0.5, 2.0), random.nextInt(100, 3000)),
        };

        for (Competitor competitor : competitors) {
            for (Obstacle obstacle : obstacles) {
                obstacle.tryObstacle(competitor);
            }
        }

        System.out.println();

        for (Competitor competitor : competitors) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.tryObstacle(competitor)) break;
            }
        }
        System.out.println();



        for (Competitor c : competitors) {
            System.out.println(c.toString());
        }

        System.out.println();
        for (Obstacle o : obstacles) {
            System.out.println(o.toString());
        }



    }
}

