package com.company.StreamAPI_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

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
    }
}
