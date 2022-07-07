package main.java.com.company.StreamAPI_8.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class mapExample {
    public static void main(String[] args) {
        int[] array = new int[10];
        List<Integer> list = new ArrayList<>();


        fillList(list);
        fillArr(array);


        System.out.println("Исходный список: " + list);
        System.out.println("Исходный массив: " + Arrays.toString(array));

        for (int i = 0; i < 10; i++) {
            array[i] = array[i] * 2;
            list.set(i, list.get(i) * 2);
        }
        System.out.println("Увеличили каждый элемент списка в 2 раза с помощью for: " + list);
        System.out.println("Увеличили каждый элемент массива в 2 раза с помощью for: " + Arrays.toString(array));

        //увеличим значения на 2 с помощью лямбды
        //метод map() пришел из функциональных ЯП и позволяет изменять данные
        //map переводится как отображения, это из теории множеств, есть оригинальное множество
        //и преобразованное множество, мы берем каждый элемент из оригинального множества и по какому-то
        //правилу сопоставляем этому элементу элемент из нового множества - эта операция называется отображением

        // метод map() возвращает поток
        array = Arrays.stream(array).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

//        array = Arrays.stream(array).map(a -> 3).toArray(); //заменяет все элементы array на 3

        System.out.println("Увеличили каждый элемент списка в 2 раза с помощью Stream API map(): " + list);
        System.out.println("Увеличили каждый элемент массива в 2 раза с помощью Stream API map(): " + Arrays.toString(array));

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
