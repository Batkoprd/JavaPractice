package com.company.StreamAPI_8.HW8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HW8_MainApp {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3(4);
    }

    public static void ex1() {
        String[] myArr = {"cat", "dog", "whale", "apple", "coconut", "cat", "dog", "bison", "apple",
                "coconut", "monkey", "monkey", "monkey", "rose", "lavender", "whale", "shark", "dog", "dog",
                "dog", "wolf", "bear", "fox", "orange", "lemon"};
        Stream.of(myArr)
                .collect(Collectors
                .groupingBy(str -> str, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);
    }

    public static void ex2() {
        list().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .ifPresent(System.out::println);
    }

    public static void ex3(int n) {
        String res = list().stream()
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())
                .map(Employee::getName)
                .limit(n)
                .collect(Collectors.joining(", ", n + " cамых старших сотрудников зовут: ", "."));
        System.out.println(res);
    }

    public static List<Employee> list () {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Bob", 24, 50000));
        employeeList.add(new Employee("Kate", 34, 100000));
        employeeList.add(new Employee("John", 27, 80000));
        employeeList.add(new Employee("Bill", 42, 300000));
        employeeList.add(new Employee("George", 30, 120000));
        employeeList.add(new Employee("Ann", 24, 200000));
        employeeList.add(new Employee("Sonya", 25, 60000));
        employeeList.add(new Employee("Kent", 50, 40000));
        employeeList.add(new Employee("Patrick", 36, 180000));
        employeeList.add(new Employee("Emma", 42, 240000));

        return employeeList;
    }
}

class Employee {
    private String name;
    private int age;
    private int salary;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

}