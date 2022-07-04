package main.java.com.company.Generics_Collections_4;

import java.util.List;

public class MainApp_Lesson_4 {
    public static void main(String[] args) {

        // создали две коробки с интегерами
        SimpleBox simpleBox1 = new SimpleBox(10);
        SimpleBox simpleBox2 = new SimpleBox(20);
        System.out.println("---------------------------------");

        simpleBox1.setObj("Java"); // кто-то положил в коробку строку
        System.out.println("Положили в simpleBox1 объект " + simpleBox1.getObj() + ", класса " + simpleBox1.getObj().getClass());
        System.out.println("---------------------------------");

        // чтобы просуммировать нужно делать касты, тк Джава не знает, что лежит внутри коробок, а мы знаем
        System.out.println("Попытаемся просуммировать хранящиеся в simpleBox1 и simpleBox2 объекты: ");
        if (simpleBox1.getObj() instanceof Integer && simpleBox2.getObj() instanceof Integer ) {
            int sum = (Integer) simpleBox1.getObj() + (Integer) simpleBox2.getObj();
            System.out.println("sum: " + sum);
        } else {
            System.out.println("Получим ошибку, потому что в simpleBox1: " + simpleBox1.getObj().getClass().getSimpleName() +
                    ", а в simpleBox2: " + simpleBox2.getObj().getClass().getSimpleName());
            System.out.println( "Содержимое коробок отличается по типу");
        }
        System.out.println("---------------------------------");


        /*
        Чтобы создать контейнер для разных объектов есть 3 проблемы:
        1) Выстаскивая данные из коробки необходимо делать касты
        2) Чтобы не словить ClassCastException необходимо делать проверки instanceof, нельзя их забывать
        3) В эту коробку кто-то может положить что угодно, потому что на ней не указано что в ней
        Для этого и придумали Generics
        */


        // В такую коробку можно нечаянно положить что угодно, например строку, никто же не знает,
        // что это коробка с интегерами


        //задаем тип данных
        GenericBox<String> stringGenBox = new GenericBox<>("Java");
        GenericBox<Integer> integerGenBox1 = new GenericBox<>(10);
        GenericBox<Integer> integerGenBox2 = new GenericBox<>(20);
        System.out.println("Установим в integerGenBox1 значение 55 и просуммируем объекты, хранящиеся в коробках " +
                "integerGenBox1 и integerGenBox1: ");
        integerGenBox1.setObj(55); //setObj ожидает только инт
        int sum2 = integerGenBox1.getObj() + integerGenBox2.getObj(); //без кастов
        System.out.println(sum2);
        System.out.println("---------------------------------");

        // Все три проблемы решают дженерики
        // особенность дженериков, что они используют только ссылочные типы данных,
        // а не примитивы, т.е. Integer вместо int, для восьми примитивов есть 8 оберток


        BoxWithNumbers<Integer> integerBoxWithNumbers = new BoxWithNumbers<>(1, 2, 3, 4);
        System.out.println(integerBoxWithNumbers.average());

        BoxWithNumbers<Float> floatBoxWithNumbers = new BoxWithNumbers<>(1f, 2f, 3f, 4f);
//        BoxWithNumbers<String> stringBoxWithNumbers; String не наследуется от Number
        System.out.println("---------------------------------");
        System.out.println(integerBoxWithNumbers.compareAverage(floatBoxWithNumbers));
        System.out.println("---------------------------------");

        // В момент компиляции компилятор выкидывает все дженерики, а все <T> заменяются на обжекты
        // и где нужно компилятор расставляет на касты, если <N extends Number> в компиляторе N станет Number а не object


        TwoGen<Integer, String> twoGenObj = new TwoGen<Integer, String>( 555 ,
                "Hello" );
        twoGenObj.showTypes();
        int intValue = twoGenObj.getObj1();
        String strValue = twoGenObj.getObj2();
        System.out.println("Значение первого параметра: " + intValue);
        System.out.println("Значение второго параметра: " + strValue);
        System.out.println("---------------------------------");

        GenericBox<Number> numberGenBox = new GenericBox<>(1);
        GenericBox<Integer> integerGenBox = new GenericBox<>(1);
        doSomething1(numberGenBox);
        doSomething2(numberGenBox);
        doSomething1(integerGenBox);
//        doSomething2(integerGenBox); // откажется от Integer

        // В обобщениях наследования не работают
        // Слева можно складывать любые Numbers, а справа наследник Integer,
        // но Number слева говорит, что туда можно подавать float и тд, а слева только Integer
        // GenBox<Number> gbx = new GenBox<Integer>(123);
    }

    public static void method1(int[] arr) {}
    public static void method2(int... arr){} // аргумент переменной длины

    public static void doSomething1(GenericBox<? extends Number> box) {} // а сюда Number и его наследников
    public static void doSomething2(GenericBox<Number> box) {} // сюда можно подавать только Number
    public static void doSomething3(GenericBox<? super Number> box) {} // либо Number либо его родитель
    public static <T /*extends Number*/> T getFirstElement(List<T> list) {
        return list.get(0);
    }
}

class TwoGen<T, V> {
    private T obj1;
    private V obj2;
    public TwoGen(T obj1, V obj2) {
        System.out.println("Конструктор класса TwoGen с двумя параметрами: " + obj1.getClass().getSimpleName() + " и "
                + obj2.getClass().getSimpleName());
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public void showTypes() {
        System.out.println( "Тип T: " + obj1.getClass().getName());
        System.out.println( "Тип V: " + obj2.getClass().getName());
    }
    public T getObj1() {
        return obj1;
    }
    public V getObj2() {
        return obj2;
    }
}
