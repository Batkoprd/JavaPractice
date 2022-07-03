package main.java.com.company.OOP_2.Interfaces;

public interface Flyable {
    //public abstract void fly();
    //В интерфейсах могут быть только абстрактые методы

    //Все переменные в интерфейсах глобальные константы public static final
//    void fly();

    public static final int x = 10;

    // Дефолтная реализация, если мы не переопределим метод в классе, то будет работать дефолтный метод
    default void fly() {
        System.out.println("Fly");
    }
}
