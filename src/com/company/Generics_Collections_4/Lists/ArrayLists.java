package com.company.Generics_Collections_4.Lists;

import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        // Коллекции могут работать только со ссылочными типами данных, тк они используют дженерики
        // List это динамические массивы, если не хватает места и нужно добавить элемент они увеличиваются
        // в полтора раза
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println(arrayList);
        arrayList.add(2, "D");
        System.out.println(arrayList);
        arrayList.set(0, "X");
        System.out.println(arrayList);
        arrayList.remove(3);
        System.out.println(arrayList);
        arrayList.ensureCapacity(100); //задаем новую емкость
        arrayList.trimToSize(); // обрезаем емкость до длины списка
        List<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        System.out.println(arrayList2);
//        List list = new ArrayList();
//        list.add("A");
//        list.add(2);
//        System.out.println(list);
        List<String> arrayList3 = new ArrayList<>(Arrays.asList("9", "1", "2", "2", "2", "2", "2", "3"));
        // чтобы удалить все 2 из листа arrayList3
        while (arrayList3.remove("2")); // remove это boolean метод
        System.out.println(arrayList3);
        Collections.sort(arrayList3);
        System.out.println(arrayList3);

        // Мы хотим отсортировать arrayList4 по длине элемента
        List<String> arrayList4 = new ArrayList<>(Arrays.asList("AAA", "B", "B", "BBBBB", "C", "D", "ZZ"));
        // Анонимный класс компаратор позволяет переопределить метод сравнения
        arrayList4.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(arrayList4);
        System.out.println(arrayList4.contains("C"));
        System.out.println(arrayList4.indexOf("B"));// первое вхождение объекта в лист

        //tripToSize нужно использовать, если в листе очень большая емкость, но заполнен лист на небольшую часть
        //потому что в неиспользуемой емкости хранятся ссылки и это тратит память





    }
}
