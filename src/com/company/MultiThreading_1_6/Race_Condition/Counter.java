package com.company.MultiThreading_1_6.Race_Condition;

public class Counter {
    private int c;

    public int value() { return c; }

    public Counter() { c = 0; }

    public void inc() { c++; }
    public void dec() { c--; }
}
