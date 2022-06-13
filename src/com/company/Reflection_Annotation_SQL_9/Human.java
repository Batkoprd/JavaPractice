package com.company.Reflection_Annotation_SQL_9;

public class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greetings() {
        System.out.println("Hello, " + name);
    }
}
