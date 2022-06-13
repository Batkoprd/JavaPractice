package main.java.com.company.Multithreading_2_7;

import java.util.Collections;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsThreads {
    public static void main(String[] args) {
        // Vector вместо ArrayList
//        Hashtable<Integer, Integer> ht = new Hashtable<>(); синхронизированы все методы
//                , когда добавляем\удаляем блокируется весь хештейбл, доступ потоков к данным
//                последовательный
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        /*
        ConcurrentHashMap - на чтение нет блокировки, т.е. 10000 потоков могут параллельно читать,
        на запись блокируется не вся таблица, а только ячейка, куда попадает запись, остальные ячейки другие
        потоки могут читать.
        */

//        Collections.synchronizedList();
//        Collections.synchronizedMap()
        /*
        CopyOnWriteArrayList - если поток начал работать с листом, то он будет его видеть в том виде в котором начал,
        без динамических изменений, если другой тред изменяет лист, то тогда создается новый лист и ссылка будет указывать
        на новый лист, а первый поток будет работать со старым вариантом.
        */
        ArrayBlockingQueue<Thread> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        /*
        4 метода для добавления в очередь, когда места нет все методы будут работать по-разному
        arrayBlockingQueue.put(); - при отсутствии места переводит поток в режим ожидания
        arrayBlockingQueue.offer(); /2 - булевой метод, возвращает получилось ли положить в очередь или нет,
        есть таймаут, типа я жду 5 минут, если не удалось добавить в очередь - возвращает фолс
        arrayBlockingQueue.add(); - если места нет, то выбросит исключение

        4 метода вытащить из очереди
        arrayBlockingQueue.take(); - достает и удаляет из очереди, освобождая место, если очередь пустая, то будет
        в режиме ожидания, когда что-то появится в очереди, то получит ссылку на объект.
        arrayBlockingQueue.poll(); / 2 - возвращает элемент, если очередь пустая возвращает null, есть таймаут
        arrayBlockingQueue.peek(); - узнать что последнее лежит в очереди, вернет объект без удаления
        */

    }

}
