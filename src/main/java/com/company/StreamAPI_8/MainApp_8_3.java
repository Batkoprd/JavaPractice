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
        List<Integer> out = numbers.stream() //преобразуем список в стрим
                .filter(n -> n % 2 == 0)    //оставляем в потоке только четные числа
                .map(n -> n * n) //преобразуем каждый элемент int в квадрат
                .limit(2) // оставляем в потоке только первые два элемента
                .toList(); //собираем элементы потока в лист
        System.out.println(numbers);
        System.out.println(out);
    }

    private static void thirdEx() {
        //получаем поток данных из набора целых чисел, находим среди них уникальные и выводим их
        Arrays.asList(1,2,3,4,4,3,2,3,2,1).stream().distinct().forEach(System.out::println);
    }

    private static void matchEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list.stream().allMatch(n -> n < 10)); // все элементы в стриме должны удовлетворять условию
        System.out.println(list.stream().anyMatch(n -> n == 4)); // хотя бы один элемент должен выполнять условие
        System.out.println(list.stream().noneMatch(n -> n == 2)); // ниодин элемент не должен выполнять условие
    }

    private static void findAnyEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println); // findAny возвращает Optional - контейнер в нем либо есть, либо нет
        Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
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

        System.out.println(list);
        System.out.println(wordsLen);

        list.stream().map(strToLen).forEach(System.out::println);
    }

    private static void reduceEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer n: list) sum += n;

        int streamSum = list.stream().reduce(0, (acc, n) -> acc + n);
        System.out.println(sum + "   " + streamSum);
    }

    private static void intStreamEx() {
        IntStream intStream = IntStream.of(10, 20, 30, 40);
        System.out.println(intStream.sum());
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.stream().mapToInt(v -> v).sum(); //стрим объектов преобразуется к интСтриму

        IntStream.rangeClosed(2, 10).filter(n -> n % 2 != 0).forEach(System.out::println);
    }

    private static void streamFromFilesEx() {
        try {
            Files.lines(Paths.get("123.txt")).map(String::length).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleStringEx() {
        System.out.println(Arrays.stream("A B CC B AA A A B CC C".split("\\s")).distinct().count() );
    }







}
