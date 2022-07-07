package main.java.com.company.StreamAPI_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MainApp_8_2 {
    static class Person {
            enum Position {
                ENGINEER, DIRECTOR, MANAGER;
            }
            private String name;
            private int age;
            private Position position;

            public Person (String name, int age, Position position) {
                this .name = name;
                this .age = age;
                this .position = position;
            }
        }
    private static void streamSimpleTask () {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person( "Bob1" , 35 , Person.Position.MANAGER),
                new Person( "Bob2" , 44 , Person.Position.DIRECTOR),
                new Person( "Bob3" , 25 , Person.Position.ENGINEER),
                new Person( "Bob4" , 42 , Person.Position.ENGINEER),
                new Person( "Bob5" , 55 , Person.Position.MANAGER),
                new Person( "Bob6" , 19 , Person.Position.MANAGER),
                new Person( "Bob7" , 33 , Person.Position.ENGINEER),
                new Person( "Bob8" , 37 , Person.Position.MANAGER)
        ));
        List<String> engineersNames = persons.stream()
                .filter(person -> person.position == Person.Position.ENGINEER)
                .sorted((o1, o2) -> o1.age - o2.age)
                .map((Function<Person, String>) person -> person.name)
                .collect(Collectors.toList());
        System.out.println(engineersNames);
    }

    public static void main(String[] args) {
        streamSimpleTask();
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        //промежуточные операции не будут работать, если не поставить терминальную операцию
        List<Integer> out = integerList.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).toList();

        List<Integer> out2 = integerList.stream().filter(integer -> integer % 2 == 0).toList();
        System.out.println(out);
        System.out.println(out2);

        integerList.stream().filter((n) -> n% 2 == 1).forEach(System.out::println);

        //Способы создавать стримы:
        List<String> list = new ArrayList<>(Arrays.asList( "A" , "AB" , "B" ));
        Stream<String> stream1 = list.stream();
        Stream<Integer> stream2 = Stream.of( 1 , 2 , 3 , 4 );
        String[] array = { "A" , "B" , "C" };
        Stream<String> stream3 = Arrays.stream(array);
        Stream<String> anotherStream = Stream.of(array);
        IntStream intStream = IntStream.of( 1 , 2 , 3 , 4 );
        LongStream longStream = LongStream.of( 1L , 2L , 3L , 4L );
        IntStream rangedIntStream = IntStream.rangeClosed( 1 , 100 );
        IntStream intStream2 = Stream.of( 1 , 2 , 3 , 4 ).mapToInt(n -> n); //преобразуем обычный стрим в инт

        System.out.println();
        Stream.of("AA", "BBB", "C", "DDDD").map(str -> str.length()).forEach(System.out::println);

        System.out.println();
        Stream.of(1, 2, 3, 4).map(a -> a*10).forEach(System.out::println); //ссылка на метод принт

        System.out.println();
        Stream.of("AAAA", "VVV", "QQQQQQQ").map(String::length).collect(Collectors.toList());

        class User {
            String name;

            public User(String name) {
                this.name = name;
            }

        }
        Stream.of("Bob", "Max", "John").map(s -> new User(s)).collect(Collectors.toList());
    }
}

