package main.java.com.company.OOP_2.HW.Obstacles;

import main.java.com.company.OOP_2.HW.Competitors.Competitor;

public class Wall implements Obstacle {
    double height;

    public double getM() {
        return height;
    }

    public Wall(double height) {
        this.height = height;
    }


    @Override
    public boolean tryObstacle(Competitor competitor) {
        if (competitor.jump(height)) {
            return true;
        } else {
//            System.out.println(competitor.getName() + " " + competitor.getType() + " left the race!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }


    public static class Track implements Obstacle {
        int distance;

        public int getM() {
            return distance;
        }

        public Track(int distance) {
            this.distance = distance;
        }


        @Override
        public String toString() {
            return "Track{" +
                    "distance=" + distance +
                    '}';
        }

        @Override
        public boolean tryObstacle(Competitor competitor) {
            if (competitor.run(distance)) {
                return true;
            } else {
    //            System.out.println(competitor.getName() + " " + competitor.getType() + " left the race!");
                return false;
            }
        }
    }
}
