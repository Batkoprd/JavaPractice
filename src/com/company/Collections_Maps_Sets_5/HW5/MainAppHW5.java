package com.company.Collections_Maps_Sets_5.HW5;

import java.util.*;

public class MainAppHW5 {
    public static void main(String[] args) {
        String[] myArr = {"cat", "dog", "whale", "apple", "coconut", "cat", "dog", "bison", "apple",
                "coconut", "monkey", "monkey", "monkey", "rose", "lavender", "whale", "shark", "dog", "dog",
                "dog", "wolf", "bear", "fox", "orange", "lemon"};
        Solution(myArr);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Вася", "123");
        phoneBook.add("Вася", "1234");
        phoneBook.add("Вася", "1235");
        phoneBook.add("Вася", "12356");
        phoneBook.add("Петя", "123");
        phoneBook.add("Петя", "666");
        phoneBook.add("Петя", "777");
        phoneBook.getAllNames().forEach(e -> System.out.println("[" + e + "] - " + phoneBook.getAllPhoneNumbers(e)));
        System.out.println(phoneBook.getAllPhoneNumbers("Петя")) ;

        Map<String, Integer> a = new HashMap<>();
        a.put("a", a.getOrDefault("a", 0));
        System.out.println(a.get("a"));
    }

    public static void Solution(String[] array) {
        Map<String, Integer> hm = new TreeMap<>();
        for (String s : array) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
//            if (hm.containsKey(s)) {
//                hm.put(s, hm.get(s) + 1);
//            } else {
//                hm.put(s, 1);
        }


        System.out.println(hm.keySet());

        hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(
                        new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o2 - o1;
                            }
                        }
                ))
                .forEach(System.out::println);

    }
}
