package main.java.com.company.StreamAPI_8.Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class filter_forEach_reduce {
    public static void main(String[] args) {

        int[] array = new int[10];
        List<Integer>  list = new ArrayList<>();


        fillArr(array);
        fillList(list);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Исходный список: " + list);

        //допустим мы хотим оставить в массиве только четные числа
        array = Arrays.stream(array).filter(a -> a % 2 == 0).toArray();
        list = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println("Оставили в них только четные элементы: ");
        System.out.println(list);
        System.out.println(Arrays.toString(array));



        //метод forEach
        System.out.println("Вывели каждый элемент массива в отдельной строке: ");
        Arrays.stream(array).forEach(a -> System.out.println(a));
        System.out.println("Вывели каждый элемент списка в отдельной строке: ");
        list.stream().forEach(a -> System.out.println(a));
        System.out.println("--------------------------");


        //если в теле лямбды мы ничего не делаем, кроме как вызываем один метод, то можно сократить еще

        //Arrays.stream(array).forEach(System.out::println);
        //list.forEach(System.out::println);

        //метод reduce, используется для получения суммы всех э-в, произведения и тд
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        //acc - аккумулятор, b - текущее значение, можно указывать начальное значение
        //аккумулятора, если не указывать, то аккумулятором будет первое число, а итерация
        //начнется со второго
        int sum = Arrays.stream(arr2).reduce((acc, b) -> acc + b).getAsInt();
        int prod = list2.stream().reduce((acc, b) -> acc * b).get();
        System.out.println("Нашли сумму всех элементов массива " + Arrays.toString(arr2) + " с помощью метода reduce(): " + sum);
        System.out.println("Нашли произведение всех элементов списка " + list2 + " с помощью метода reduce(): " + prod);
        System.out.println("--------------------------");


        int[] arr3 = new int[10];
        fillArr(arr3);
        //можно методы использовать последовательно
        int[] newArr = Arrays.stream(arr3).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println("Отфильтровали все нечетные элементы массива " + Arrays.toString(arr3)  + ", и умножили их в два раза: " + Arrays.toString(newArr));
        System.out.println("--------------------------");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println("Исходное множество: " + set);
        set = set.stream().map(a -> a * 2).collect(Collectors.toSet());
        System.out.println("Увеличили каждый элемент множества в 2 раза: " + set);


    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i<10; i++) {
            list.add(i+1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }

}
