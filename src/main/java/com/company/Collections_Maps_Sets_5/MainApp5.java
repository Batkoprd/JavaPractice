package main.java.com.company.Collections_Maps_Sets_5;

import java.lang.reflect.Field;
import java.util.*;

public class MainApp5 {
    public static void main(String[] args) throws Exception {
        /*
        У HashMap есть два основных параметра:
            ● capacity - емкость, или количество элементов(bucket) во внутренней таблице HashMap,
        по-умолчанию начальная емкость HashMap равна 16, и всегда равна степени 2, при попытке
        указать в конструкторе начальную емкость равную 28, она автоматически будет увеличена до 32;
            ● loadFactor (по-умолчанию равен 0.75, должен находиться в пределах от 0.0 до 1.0) -
        коэффициент, который показывает что при добавлении в HashMap количества элементов
        бОльшего чем capacity * loadFactor, емкость коллекции будет увеличена вдвое и произойдет
        рехеширование записей.
         */
        Map<String, String> hm = new HashMap<>(8);
        hm.put( "Russia" , "Moscow" );
        hm.put( "France" , "Paris" );
        hm.put( "Germany" , "Berlin" );
        hm.put( "Norway" , "Oslo" );
        // Как спросить емкость хешмапа
//        Class hashMapClass = HashMap.class;
//        Field tableField = hashMapClass.getDeclaredField("table");
//        tableField.setAccessible(true);
//        int capacity = ((Object[])tableField.get(map)).length;
//        System.out.println(capacity);
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println(o.getKey() + " : " + o.getValue());
        }
        System.out.println("getOrDefault method: " + hm.getOrDefault("Z", "defaultValue"));
        System.out.println("Если ключа нет в HashMap, то вернется: " + hm.get(10));
        System.out.println("---------------------------------");

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        System.out.println("HashMap не гарантируется порядок: ");
        testMap(hashMap);
        System.out.println("LinkedHashMap в каком порядке пары ключ\\значение добавлены, в таком порядке они и вернутся: ");
        testMap(linkedHashMap);
        System.out.println("В TreeMap пары отсортированы по ключу, по увеличению чисел либо лексикографический порядок: ");
        testMap(treeMap);
        System.out.println("---------------------------------");

        Set<String> set = new HashSet<>();
        set.add( "Aльфa" );
        set.add( "Бета" );
        set.add( "Aльфa" );
        set.add( "Этa" );
        set.add( "Гaммa" );
        set.add( "Эпсилон" );
        set.add( "Oмeгa" );
        set.add( "Гaммa" );
        System.out.println("Множество - " + set + ", удалим все элементы с len > 4 с помощью Iterator: ");
        Iterator<String> iterSet = set.iterator();
        while (iterSet.hasNext()) {
            String o = iterSet.next();
            if (o.length() > 4) {
                iterSet.remove();
            }
        }
        System.out.println("Результат: " + set);
//        set.removeIf(o -> o.length() > 2);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add( "Бета" );
        linkedHashSet.add( "Aльфa" );
        linkedHashSet.add( "Этa" );
        linkedHashSet.add( "Гaммa" );
        linkedHashSet.add( "Эпсилон" );
        linkedHashSet.add( "Oмeгa" );
        System.out.println("Из LinkedHashSet объекты извлекаются в том же порядке, что и были добавлены:  " + linkedHashSet);

        Set<String> treeSet = new TreeSet<>();
        treeSet.add( "C" );
        treeSet.add( "A" );
        treeSet.add( "B" );
        treeSet.add( "E" );
        treeSet.add( "F" );
        treeSet.add( "D" );
        System.out.println("TreeSet хранит объекты в отсортированном порядке: " + treeSet);
        System.out.println("---------------------------------");

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 6; i++) set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int i = 2; i < 8; i++) set2.add(i);
        System.out.println("set1: " + set1 + "; set2: " + set2);

        // union - объединение множеств
        Set<Integer> union = new HashSet<>(set1); // копируем set1
        union.addAll(set2);
        System.out.println("Oбъединение(addAll) set1 и set2: " + union);

        // intersection - пересечение множеств
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // оставляет в исходном множестве только те элементы
        // которые есть в множестве передаваемом в аргумент
        System.out.println("Пересечение(retainAll) set1 и set2: " + intersection);

        // difference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2); // удаляются все элементы которые есть в set аргументе
        System.out.println("Разность(removeAll)  set1 и set2: " + difference);
        System.out.println("---------------------------------");

        /*
        Итератор позволяет обойти все элементы коллекции. Для работы с итераторами служит интерфейс
        Iterator. Для получения объекта этого типа, необходимо вызвать метод iterator() у коллекции.
         */
        List<String> list = new ArrayList<>(Arrays.asList("A", "A", "A", "B", "C", "A", "D", "D", "D"));
        // ConcurrentModificationException, нельзя изменять коллекции в цикле for each
        try {
            System.out.println("Попробуем изменить ArrayList " + list + " в цикле for each: ");
            for (String str : list) {
                if (str.equals("A")) {
                    list.remove(str);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("После удаления одного элемента было поймано исключение: " + e + " список: " + list);
        }

        System.out.println("\nУдалим элемент D с помощью классического цикла for от конца к началу: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i).equals("D")) {
                list.remove("D");
            }
        }
        System.out.println("Циклом for от начала к концу нельзя удалить все элементы ArrayList.");
        System.out.println("Результат: " + list);


        //Итератор также подходит для Sets
        System.out.println("\nДля перебора и удаления элементов из коллекции нужно использовать Iterator.");
        System.out.println("Удалим элемент A из списка с помощью Iterator: ");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String o = iter.next();
            if(o.equals("A")) {
                iter.remove();
            }
        }
        System.out.println("Получившийся список: " + list);
        System.out.println("---------------------------------");

        //Collections remove
//        list.removeIf(o -> o.equals("A"));

        // Разница ListIterator и Iterator - итератор нацелен на более общую задачу обхода любой коллекции,
        // те неизвестно умеет ли коллекция работать индексами, менять элементы и тд
        // ЛистИтератор заточен под листы и имеет дополнительные методы работы для листов
        ListIterator<String> listIter = list.listIterator();
        /*
            Этот интерфейс добавляет больше гибкости при работе с List.
        ● hasPrevious() - проверка есть ли элемент слева;
        ● previous() - переход на левый элемент и возврат ссылки на него;
        ● nextIndex() - получение индекса следующего элемента;
        ● previousIndex() - получение индекса предыдущего элемента;
        ● add() - добавить новый элемент на то место, на которое указывает итератор;
        ● set() - изменить элемент, на который указывает итератор.
            При работе с листами можно не только обходить элементы и удалять их, но и: работать с индексами элементов,
        добавлять/изменять объекты в коллекции, двигаться не только вправо, но и влево по списку.
         */

        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat( "A" , 5 ), new Cat( "B" , 2 ), new Cat( "C" , 4 )
        ));
        System.out.println("Коты: " + cats);
        Collections.sort(cats);
        System.out.println("Котов отсортировали в порядке увеличения возраста: " + cats);

    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

 class Cat implements Comparable{
    private String name;
    private int age;
    public Cat(String name, int age) {
        this .name = name;
        this .age = age;
    }

     @Override
     public String toString() {
         return "Cat{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }

     @Override
     public int compareTo(Object o) {
         Cat another = (Cat)o;
         if ( this .age > another.age) {
             return 1 ;
         }
         if ( this .age < another.age) {
             return - 1 ;
         }
         return 0 ;
     }
}