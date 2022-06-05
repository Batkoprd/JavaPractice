package com.company.Generics_Collections_4.HW4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainAppHW4 {
    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(roque(array, 0, 4)));
        System.out.println(arrayToArrayList(new String[]{"a", "b"}));

        BoxForFruits<Apple> appleBox = new BoxForFruits<>(new Apple());
        BoxForFruits<Apple> anotherAppleBox = new BoxForFruits<>(new Apple());
        BoxForFruits<Orange> orangeBox = new BoxForFruits<>(new Orange());
        BoxForFruits<Fruit> fruitBox = new BoxForFruits<>();

        appleBox.transfer(fruitBox);
        appleBox.transfer(anotherAppleBox);
//        appleBox.transfer(orangeBox);
//        fruitBox.transfer(appleBox);


    }

    public static Object[] roque(Object[] arr, int idx1, int idx2) {
        Object tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
        return arr;
    }

    public static <T> ArrayList<T> arrayToArrayList (T[] arr) {
        return new ArrayList<>(List.of(arr));
    }
}
