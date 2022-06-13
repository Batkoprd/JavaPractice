package main.java.com.company.MultiThreading_1_6.Race_Condition;

public class SynchCounter {
    private int c;

    public int value() { return c; }

    public SynchCounter() { c = 0; }

    public synchronized void inc() { c++; }

    public synchronized void dec() { c--; }


}
