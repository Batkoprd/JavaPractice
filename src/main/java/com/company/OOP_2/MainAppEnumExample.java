package main.java.com.company.OOP_2;

public class MainAppEnumExample {
    public static void main(String[] args) {
        Calendar.currentDateInfo();
        System.out.println("---------------------------------");

        Fruit fruit = Fruit.APPLE;
        System.out.println(fruit);
        if (fruit == Fruit.APPLE) {
            System.out.println( "fruit действительно является яблоком" );
        }
        switch (fruit ) {
            case APPLE:
                System.out.println( "fruit - яблоко" );
                break ;
            case ORANGE:
                System.out.println( "fruit - апельсин" );
                break ;
            case CHERRY:
                System.out.println( "fruit - вишня" );
                break ;
        }
        System.out.println( "\n"+"Все элементы перечисления:" );
        for (Fruit f : Fruit.values()) {
            System.out.println(f);
        }
        System.out.println( "Поиск по названию: " + Fruit.valueOf( "BANANA" ));
        System.out.println();
        for (Month m : Month.values()){
            System.out.println(m);
        }
        System.out.println( "Поиск по названию : " + Month.valueOf( "JANUARY" ));
        System.out.println("---------------------------------");
        for (Fruit f : Fruit.values()) {
            System.out.printf(" Средний вес фрукта %s составляет: %d ед.\n", f.getRussianTitle(), f.getWeight());
        }

    }
}


enum Fruit {
    /*
    Перечисление — это список именованных однотипных констант, определяющих новый тип данных, в объектах которого могут
    храниться только значения из этого списка. В качестве примера можно привести названия дней недели
    или месяцев в году — все они являются перечислениями.
    Идентификаторы ORANGE, APPLE и т.д. — константы перечисления, каждая из которых неявно объявлена как public
    и static член перечисления Fruit. Тип этих констант — тип перечисления (Fruit)
       */
    ORANGE( "Апельсин" , 3 ), APPLE( "Яблоко" , 3 ), BANANA( "Банан", 2) ,
    CHERRY( "Вишня" , 1 );
    private String russianTitle;
    private int weight;
    public String getRussianTitle() {
        return russianTitle;
    }
    public int getWeight() {
        return weight;
    }
    Fruit(String russianTitle, int weight) {
        this .russianTitle = russianTitle;
        this .weight = weight;
    }
    /*
    В перечислении каждая константа — объект класса. Таким образом, перечисление может иметь конструкторы,
    методы и переменные экземпляра. Если определить для объекта перечислимого типа конструктор, он будет вызываться
    всякий раз при создании константы перечисления. Для каждой константы перечисляемого типа можно вызвать любой метод,
    определённый в перечислении.
     */
}

enum Month {

    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5),
    JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10),
    NOVEMBER(11), DECEMBER(12 );
    private int number;
    public int getNumber() {
        return number;
    }
    private Month (int number) {
        this.number = number;
    }
}

class Calendar {
    static Month currentMonth = Month.APRIL;
    public static void currentDateInfo() {
        System.out.println(currentMonth.getNumber() + " " + Month.valueOf(String.valueOf(currentMonth)));
    }
}

