package com.company.Collections_Maps_Sets_5;

import java.lang.reflect.Field;
import java.util.*;

public class MainApp5 {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>(8);
        map.put("A", "B");
        map.put("C", "D");
        // Как спросить емкость хешмапа
//        Class hashMapClass = HashMap.class;
//        Field tableField = hashMapClass.getDeclaredField("table");
//        tableField.setAccessible(true);
//        int capacity = ((Object[])tableField.get(map)).length;
//        System.out.println(capacity);
        for (Map.Entry<String, String> o : map.entrySet()) {
            System.out.println(o.getKey());
            System.out.println(o.getValue());
            System.out.println();
        }
        System.out.println(map.getOrDefault("Z", "Q"));

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("AAA");
        set.add("AAAA");
        set.add("AA");
        System.out.println(set);

        List<String> list = new ArrayList<>(Arrays.asList("A", "A", "B", "C", "A"));
        // ConcurrentModificationException, нельзя изменять коллекции в цикле for each
//        for (String str : list) {
//            if(str.equals("A")) {
//                list.remove(str);
//            }
//            System.out.println(list);
//        }


//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).equals("A")) {
//                list.remove("A");
//            }
//        }
//        System.out.println(list);

        //Collections remove
//        list.removeIf(o -> o.equals("A"));


        //Итератор также подходит для Sets
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String o = iter.next();
            if(o.equals("A")) {
                iter.remove();
            }
        }
        System.out.println(list);


//        set.removeIf(o -> o.length() > 2);
        Iterator<String> iterSet = set.iterator();
        while (iterSet.hasNext()) {
            String o = iterSet.next();
            if (o.length() > 2) {
                iterSet.remove();
            }
        }
        System.out.println(set);


        // Разница ListIterator и Iterator - итератор нацелен на более общую задачу обхода любой коллекции,
        // те неизвестно умеет ли коллекция работать индексами, менять элементы и тд
        // ЛистИтератор заточен под листы и имеет дополнительные методы работы для листов
        ListIterator<String> listIterator = list.listIterator();


    }
}
