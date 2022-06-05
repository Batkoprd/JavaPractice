package com.company.Generics_Collections_4.Lists;

import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    public static void main(String[] args) {
        //Связанный список - массив, где каждый элемент знает, кто его соседи
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i< 1000000; i++){
            linkedList.add(i);
        }

        /*
        В каком случае использовать ArrayList и LinkedList?
        -если предполагается большой объем данных и к ним нужно часто обращаться по индексу, то ArrayList
        -если часто обращаемся по индексу и нужно часто добавлять в конец списка, то ArrayList
        -если нужно часто добавлять и в начало списка, и в конец, то LinkedList. но это зависит от размера коллекции

         */

    }
}
