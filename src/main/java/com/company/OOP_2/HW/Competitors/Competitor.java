package main.java.com.company.OOP_2.HW.Competitors;

public interface Competitor {

    double getJumpHeight();
    int getRunDistance();
    String getName();
    String getType();

    boolean jump(double height);

    boolean run(int distance);
}

