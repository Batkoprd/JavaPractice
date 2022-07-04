package main.java.com.company.Generics_Collections_4.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    public static void main(String[] args) {
        /*
        Структура LinkedList значительно отличается от ArrayList. Каждый элемент в связном списке имеет
        ссылку на предыдущий и на следующий элементы. Сам же LinkedList имеет ссылку на свой первый и
        последний элемент.

        LinkedList позволяет производить поиск элемента по индексу, однако из-за своей структуры, для
        поиска элемента приходится обходить элементы коллекции или от первого, или от последнего, и
        пробегать по ссылкам, пока не будет найден запрошенный элемент. Выбор начала поиска зависит от
        указанного индекса, и size объекта LinkedList, если индекс меньше size / 2, то поиск будет начинаться
        с начала коллекции, в противном случае - с конца.

        При удалении элемента нет необходимости куда-либо смещать элементы коллекции (как это
        происходит в ArrayList), достаточно лишь переписать ссылки у двух соседних с удаленным объектов.
        При большом количестве элементов в коллекции, удаление из начала LinkedList будет производиться
        быстрее чем из начала ArrayList, это связано опять же с тем, что LinkedList перепишет всего пару
        ссылок, а ArrayList будет перемещать все элементы после удаленного влево на одну позицию.
         */
        //Связанный список - массив, где каждый элемент знает, кто его соседи

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add( "F" );
        linkedList.add( "B" );
        linkedList.add( "D" );
        linkedList.add( "Е" );
        linkedList.add( "C" );
        linkedList.addLast( "Z" );
        linkedList.addFirst( "A" );
        linkedList.add( 1 , "А2" );
        System.out.println( "1. linkedList: " + linkedList);
        linkedList.remove( "F" );
        linkedList.remove( 2 );
        System.out.println( "2. linkedList: " + linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println( "3. linkedList: " + linkedList);
        String val = linkedList.get( 2 );
        linkedList.set( 2 , val + " изменено" );
        System.out.println( "4. linkedList: " + linkedList);
        System.out.println("---------------------------------");
        /*
        В каком случае использовать ArrayList и LinkedList?
        -если предполагается большой объем данных и к ним нужно часто обращаться по индексу, то ArrayList
        -если часто обращаемся по индексу и нужно часто добавлять в конец списка, то ArrayList
        -если нужно часто добавлять и в начало списка, и в конец, то LinkedList. но это зависит от размера коллекции
         */
        List<Integer> myLinkedList = new LinkedList<>();
        List<Integer> myArrayList = new ArrayList<>();
        System.out.println("Для LinkedList: ");
        measureTime(myLinkedList);
        System.out.println("Для ArrayList: ");
        measureTime(myArrayList);
        // Если в программе много считывается из листа по индексу, то arraylist будет в тысячи раз быстрее






    }

    private static void measureTime(List<Integer> list) {
        long start1 = System.currentTimeMillis();
        for (int i  = 0; i < 100000; i++) {
            list.add(0, i); // можно добавлять элементы в начале и тут уже linkedlist будет быстрее
        }
        // add каждый раз новое число добавляется в конец листа [] -> [0] -> [0, 1] -> [0, 1, 2]

        long end1 = System.currentTimeMillis();
        System.out.println("Добавление 100000 элементов в начало заняло: " + (end1 - start1) + " ms.");

        long start2 = System.currentTimeMillis();
        for (int i  = 0; i < 100000; i++) {
            list.add(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Добавление 100000 элементов в конец заняло: " + (end2 - start2) + " ms.");

        long start3 = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            list.get(i);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("Обращение к каждому из 100000 элементов заняло: " + (end3 - start3) + " ms.");




    }
}
