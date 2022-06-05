package com.company.Generics_Collections_4;

import java.util.ArrayList;
import java.util.List;

public class MainApp_4 {
    public static void main(String[] args) {

        // создали две коробки с интегерами
        SimpleBox inBox1 = new SimpleBox(10);
        SimpleBox inBox2 = new SimpleBox(20);

        inBox1.setObj("Java"); // кто-то положил в коробку строку


        // чтобы просумировать нужно делать касты, тк Джава не знает, что лежит внутри коробок, а мы знаем
        if (inBox1.getObj() instanceof Integer && inBox2.getObj() instanceof Integer ) {
            int sum = (Integer) inBox1.getObj() + (Integer) inBox2.getObj();
            System.out.println("sum: " + sum);
        } else {
            System.out.println("Error");
        }
        /*
        Чтобы создать контейнер для разных объектов есть 3 проблемы:
        1) Выстаскивая данные из коробки необходимо делать касты
        2) Чтобы не словить ClassCastException необходимо делать проверки instanceof, нельзя их забывать
        3) В эту коробку кто-то может положить что угодно, потому что на ней не указано что в ней
        Для этого и придумали Generics
        */


        // В такую коробку можно нечаянно положить что угодно, например строку, никто же не знает,
        // что это коробка с интегерами


        //задаем тип данных
        GenBox<String> stringGenBox = new GenBox<>("Java");
        GenBox<Integer> integerGenBox1 = new GenBox<>(10);
        GenBox<Integer> integerGenBox2 = new GenBox<>(20);

        integerGenBox1.setObj(55); //setObj ожидает только инт

        int sum2 = integerGenBox1.getObj() + integerGenBox2.getObj(); //без кастов
        System.out.println(sum2);

        // Все три проблемы решают дженерики
        // особенность дженериков, что они используют только ссылочные типы данных,
        // а не примитивы, т.е. Integer вместо int, для восьми примитивов есть 8 оберток


        BoxWithNumbers<Integer> integerBoxWithNumbers = new BoxWithNumbers<>(1, 2, 3, 4);
        BoxWithNumbers<Integer> integerBoxWithNumbers2 = new BoxWithNumbers<>(1, 2, 3, 4);

        System.out.println(integerBoxWithNumbers.average());
        BoxWithNumbers<Float> floatBoxWithNumbers = new BoxWithNumbers<>(1f, 2f, 3f, 4f);
        System.out.println(floatBoxWithNumbers.average());
//        BoxWithNumbers<String> stringBoxWithNumbers; String не наследуется от Number
        System.out.println(integerBoxWithNumbers.compareAverage(floatBoxWithNumbers));

        // В момент компиляции компилятор выкидывает все дженерики, а все <T> заменяются на обжекты
        // и где нужно компилятор расставляет на касты, если <N extends Number> в компиляторе N станет Number а не object

        System.out.println(integerBoxWithNumbers.getClass().getName());

        GenBox<Number> numberGenBox = new GenBox<>(1);
        GenBox<Integer> integerGenBox = new GenBox<>(1);
        doSomething1(numberGenBox);
        doSomething2(numberGenBox);
        doSomething1(integerGenBox);
//        doSomething2(integerGenBox); // откажется от Integer

        // В обобщениях наследования не работают
        // Слева можно складывать любые Numbers, а справа наследник Integer,
        // но Number слева говорит, что туда можно подавать float и тд, а слева только Integer
//        GenBox<Number> gbx = new GenBox<Integer>(123);




    }

    public static void method1(int[] arr) {}
    public static void method2(int... arr){} // аргумент переменной длины

    public static void doSomething1(GenBox<? extends Number> box) {} // а сюда Number и его наследников
    public static void doSomething2(GenBox<Number> box) {} // сюда можно подавать только Number
    public static void doSomething3(GenBox<? super Number> box) {} // либо Number либо его родитель

    public static <T /*extends Number*/> T getFirstElement(List<T> list) {
        return list.get(0);
    }

}
