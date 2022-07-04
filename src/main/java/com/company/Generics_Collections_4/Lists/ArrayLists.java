package main.java.com.company.Generics_Collections_4.Lists;

import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        System.out.println("Что нужно помнить при работе с ArrayList:\n" +
                "- ArrayList представляет собой динамический массив(список) в Java;\n" +
                "- Получение значения по индексу ячейки осуществляется с помощью метода get() ;\n" +
                "- Для добавления элемента в ArrayList используем метод add() ;\n" +
                "- Метод set() позволяет заменить значение ячейки по ее индексу;\n" +
                "- Чтобы удалить элемент по индексу или значению, используем метод remove();\n" +
                "- При удалении элемента не с конца ArrayList, все элементы, идущие после удаляемого\n" +
                "элемента, будут смещены на 1 позицию влево.");
        System.out.println("---------------------------------");

        // Коллекции могут работать только со ссылочными типами данных, тк они используют дженерики
        // List это динамические массивы, если не хватает места и нужно добавить элемент они увеличиваются
        // в полтора раза
        //Как работает ArrayList?
        //Внутри обычный массив, в случае его заполнения создается новый массив
        //и в него копируются элементы старого массива

        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println("Cоздали ArrayList и добавили в него три элемента: " + arrayList);
        arrayList.add(2, "D");
        System.out.println("Вставили на место второго индекса элемент 'D': " + arrayList);
        arrayList.set(0, "X");
        System.out.println("Установили в нулевой индекс элемент 'X': " + arrayList);
        arrayList.remove(3); // неэффективно удалять элементы с середины листа
        System.out.println("Удалили элемент с индексом 3: " + arrayList);
        System.out.println("---------------------------------");
        arrayList.ensureCapacity(100); //задаем новую емкость
        arrayList.trimToSize(); // обрезаем емкость до длины списка

//        List<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
//        System.out.println(arrayList2);
//        List list = new ArrayList();
//        list.add("A");
//        list.add(2);
//        System.out.println(list);
        List<String> arrayList3 = new ArrayList<>(Arrays.asList("9", "1", "2", "2", "2", "2", "2", "3"));
        System.out.println(arrayList3);
        // чтобы удалить все 2 из листа arrayList3
        while (arrayList3.remove("2")); // remove это boolean метод
        System.out.println("Удалили все элементы 2 из предыдущего листа: " + arrayList3);
        Collections.sort(arrayList3);
        System.out.println("Отсортировали лист: " + arrayList3);
        System.out.println("---------------------------------");
        // Мы хотим отсортировать arrayList4 по длине элемента
        List<String> arrayList4 = new ArrayList<>(Arrays.asList("AAA", "B", "B", "BBBBB", "C", "D", "ZZ"));
        System.out.println("ArrayList, содержащий строки: " + arrayList4);
        // Анонимный класс компаратор позволяет переопределить метод сравнения
        arrayList4.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("Отсортировали ArrayList в порядке увеличения длины строки с помощью Comparator: " + arrayList4);
        System.out.println("Содержит ли ArrayList элемент 'C': " + arrayList4.contains("C"));
        System.out.println("Первое вхождение элемента 'B' в ArrayList: " + arrayList4.indexOf("B"));// первое вхождение объекта в лист

        //tripToSize нужно использовать, если в листе очень большая емкость, но заполнен лист на небольшую часть
        //потому что в неиспользуемой емкости хранятся ссылки и это тратит память
        /*
        При добавлении объектов в коллекцию, ее size растет, как только size попытается превысить capacity,
        ArrayList расширяется путем увеличения capacity в полтора раза. При расширении, элементы, которые
        были в коллекции до расширения, сохраняются.
        В ArrayList нем не может быть “пустых мест” между элементами. Допустим существует ArrayList с элементами
        { 1, 2, 3, 4, 5 }, при удалении элемента 3, он примет вид { 1, 2, 4, 5 }, то есть элементы, после удаленного
        переместятся влево на одну позицию (то есть на месте 3 не образуется никакого null или чего-либо еще).
        null может содержаться в ArrayList только если вы его туда добавите
         */

    }
}
