package main.java.com.company.StreamAPI_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp_8_3 {
    public static void main(String[] args) {
        secondEx();
        thirdEx();
        matchEx();
        findAnyEx();
        mappingEx();
        reduceEx();
        intStreamEx();
        streamFromFilesEx();
        simpleStringEx();

    }

    private static void secondEx() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("Отфильтруем только четные числа, возведем их в квадрат и выведем первые два элемента.");
        List<Integer> out = numbers.stream() //преобразуем список в стрим
                .filter(n -> n % 2 == 0)    //оставляем в потоке только четные числа
                .map(n -> n * n) //преобразуем каждый элемент int в квадрат
                .limit(2) // оставляем в потоке только первые два элемента
                .toList(); //собираем элементы потока в лист
        System.out.println("Исходные данные: " + numbers);
        System.out.println("Результат: " + out);
        System.out.println("---------------------------------");

    }

    private static void thirdEx() {
        System.out.println("Оставим в списке только уникальные элементы.");
        //получаем поток данных из набора целых чисел, находим среди них уникальные и выводим их
        Arrays.asList(1,2,3,4,4,3,2,3,2,1).stream().distinct().forEach(System.out::println);
        System.out.println("---------------------------------");

    }

    private static void matchEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Исходные данные: " + list);
        System.out.println("Все элементы меньше 10: " + list.stream().allMatch(n -> n < 10)); // все элементы в стриме должны удовлетворять условию
        System.out.println("Хотя бы один элемент равен 4: " + list.stream().anyMatch(n -> n == 4)); // хотя бы один элемент должен выполнять условие
        System.out.println("Нет элементов равных 2: " + list.stream().noneMatch(n -> n == 2)); // ни один элемент не должен выполнять условие
        System.out.println("---------------------------------");

    }

    private static void findAnyEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Исходные данные: " + list);
        list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println); // findAny возвращает Optional - контейнер в нем либо есть, либо нет
        Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();

        if (opt.isPresent()) {
            System.out.println(opt.get());
        } else {
            System.out.println("Нет элементов удовлетворяющих условию.");
        }
        System.out.println("---------------------------------");

    }

    private static void mappingEx() {
        //лямбду можно сохранять в переменные
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s -> s.length();
        Predicate<Integer> evenNumFilter = n -> n % 2 == 0; // подходящее число или нет
        Function<Integer, Integer> cube = n -> n * n * n;
        Stream.of(1, 2, 3).map(n -> Math.pow(n, 3));
        Stream.of(1, 2, 3).map(cube);


        List<String> list = Arrays.asList("A", "BB", "C", "DDD", "EE", "FFFF");
        List<Integer> wordsLen = list.stream().map(strToLen).collect(Collectors.toList());

        System.out.println("Исходный список: " + list);
        System.out.println("Список длин каждого элемента:" + wordsLen);

//        list.stream().map(strToLen).forEach(System.out::println);
        System.out.println("---------------------------------");
    }

    private static void reduceEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Исходный список: " + list);
        int sum = 0;
        for (Integer n: list) sum += n;

        int streamSum = list.stream().reduce(0, (acc, n) -> acc + n);
        System.out.println("Сумма элементов с помощью цикла for: " + sum + "\nСумма элементов с помощью метода reduce: " + streamSum);
        System.out.println("---------------------------------");
    }

    private static void intStreamEx() {
        IntStream intStream = IntStream.of(10, 20, 30, 40);
        System.out.println("Сумма [10, 20, 30, 40]: " + intStream.sum());
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().mapToInt(v -> v).sum(); //стрим объектов преобразуется к интСтриму
        System.out.println("Нечетные элементы rangeClosed(2, 10): ");
        IntStream.rangeClosed(2, 10).filter(n -> n % 2 != 0).forEach(System.out::println);
        System.out.println("---------------------------------");
    }

    private static void streamFromFilesEx() {
        System.out.println("Поток из файла со строками map(String::length): ");
        try {
            Files.lines(Paths.get("123.txt")).map(String::length).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
    }

    private static void simpleStringEx() {
        System.out.println("Подсчет уникальных элементов в массиве [A, B, CC, B, AA, A, A, B, CC, C]:  ");
        System.out.println(Arrays.stream("A B CC B AA A A B CC C".split("\\s"))
                .distinct()
                .count());
        System.out.println("---------------------------------");
    }
}
