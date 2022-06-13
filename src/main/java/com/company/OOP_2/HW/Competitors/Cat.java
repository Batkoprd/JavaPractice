package main.java.com.company.OOP_2.HW.Competitors;

public class Cat implements Competitor {
    String type;
    String name;
    double jumpHeight;
    int runDistance;

    public double getJumpHeight() {
        return jumpHeight;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }


    public Cat(String name, double jumpHeight, int runDistance) {
        this.type = this.getClass().getSimpleName();
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public boolean jump(double height) {
        if (jumpHeight > height) {
            System.out.printf("%s %s have successfully jumped over '%.1f'm. wall. \n", type, name, height);
            return true;
        } else {
            System.out.printf("%s %s failed to jump over '%.1f'm. wall. \n", type, name, height);
            return false;
        }

    }

    @Override
    public boolean run(int distance) {
        if (runDistance > distance) {
            System.out.printf("%s %s have successfully finished  '%d'm. track. \n", type, name, distance);
            return true;
        } else {
            System.out.printf("%s %s failed to finish  '%d'm. track. \n", type, name, distance);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runDistance=" + runDistance +
                '}';
    }
}
