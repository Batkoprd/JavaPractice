package main.java.com.company.StreamAPI_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp_8_4 {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("text.txt"))
                    .map(line -> line.split("\\s"))
                    .distinct()
                    .forEach(arr -> System.out.println(Arrays.toString(arr)));
            System.out.println("--------------------------");
            Files.lines(Paths.get("text.txt"))
                    .map(line -> line.split("\\s"))
                    .map(Arrays::stream)
                    .distinct()
                    .forEach(System.out::println);
            System.out.println("--------------------------");
            System.out.println(Files.lines(Paths.get("text.txt"))
                    .map(line -> line.split("\\s"))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .collect(Collectors.joining(", ", "Уникальные слова: ", ".")));
                    // flatMap объединяет массивы в общий поток

        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream.of(1,2,3,4,5,6,7,8).filter(n -> myOperation(n, 2)).collect(Collectors.toList());

        // при большом кол-ве данных parallel() может помочь ускорить стрим
        IntStream.rangeClosed(0, 1000).parallel().filter(n -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName());
            return n % 7 == 0;
        }).count();
    }

    public static boolean myOperation(int n, int coef) {
        try {
            return n / coef > 2;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return false;
        }
    }
}
