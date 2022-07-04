package main.java.com.company.Generics_Collections_4;

public class BoxWithNumbers <N extends Number>{ //  Это означает, что параметр N может быть заменен только самим суперклассом или его подклассами.
                                                // Он объявляет включающую верхнюю границу.
    private N[] array;

    public BoxWithNumbers(N... array) {
        System.out.println("Конструктор BoxWithNumbers, содержащей  объекты типа " + array.getClass().getSimpleName());
        this.array = array;
    }

    public double average() {
        double avg = 0.0;
        for (int i = 0; i < array.length; i++) {
            // У array[i] появился метод doubleValue() из класса Number,
            // который позволяет любой числовой объект привести к double
            avg += array[i].doubleValue();
        }
        avg /= array.length;
        System.out.println("Считаем среднее значение, содержащихся в коробке BoxWithNumbers чисел: " + avg);
        return avg;
    }

    public boolean compareAverage(BoxWithNumbers<?> another) { // <?> wildcard используется
                                                                // когда не важно какой тип в коробкe
                                                                // если использовать N, то BoxWithNumbers<Integer>
                                                                // можно будет cравнить только с BoxWithNumbers<Integer>
        System.out.println("Сравним среднее значение двух BoxWithNumbers: ");
        return Math.abs(this.average() - another.average()) < 0.0001; // Чтобы не столкнуться с ошибкой округления при сравнении двух дробных чисел, мы
                                                                      // сравниваем средние значения в пределах дельты 0.0001.
    }
}

/*
Объявление public class BowWithNumbers<N extends Number> сообщает компилятору, что все объекты типа N
являются подклассами класса Number и поэтому могут вызывать метод doubleValue(), как и любой
другой из класса Number. Ограничивая параметр N, мы предотвращаем создание нечисловых
объектов класса BoxWithNumbers.
 */