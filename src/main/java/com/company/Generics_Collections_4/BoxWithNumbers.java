package main.java.com.company.Generics_Collections_4;

public class BoxWithNumbers <N extends Number>{
    private N[] array;

    public BoxWithNumbers(N... array) {
        System.out.println("Конструктор BoxWithNumbers, содержащей  объекты типа " + array.getClass().getSimpleName());
        this.array = array;
    }

    public double average() {
        System.out.println("Считаем среднее значение, содержащихся в коробке BoxWithNumbers чисел: ");
        double avg = 0.0;
        for (int i = 0; i < array.length; i++) {
            avg += array[i].doubleValue();
        }
        avg /= array.length;
        return avg;
    }

    public boolean compareAverage(BoxWithNumbers<?> another) { // <?> wildcard используется
        // когда не важно какой тип в коробке
        return Math.abs(this.average() - another.average()) < 0.0001;
    }
}
