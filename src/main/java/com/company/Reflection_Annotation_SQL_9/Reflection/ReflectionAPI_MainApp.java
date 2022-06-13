package main.java.com.company.Reflection_Annotation_SQL_9.Reflection;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class ReflectionAPI_MainApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, MalformedURLException, ClassNotFoundException {
        /*
        Когда запускается приложение, то Джава не загружает в память все классы, которое есть, а подгружает их
        по мере обращения. Когда классы загружаются в память они складываются в специальном месте - metaspace
        */
        System.out.println(ReflectionAPI_MainApp.class.getName());
        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(int[].class);
        System.out.println(int[][][].class);
        System.out.println(void.class);

        Class stringClass1 = "Java" .getClass(); // У любого Java объекта можно вызвать метод getClass(), который вернет объект типа Class
        Class stringClass2 = String.class; // Запросить объект типа Class напрямую у класса.

        //Вызвать статический метод Class.forName(), и передать ему полное имя класса в качестве аргумента.
        try {
//            Class jdbcClass = Class.forName( "org.sqlite.jdbc" );
            Class stringClass3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        classInfo();
        // через classCat можно узнать про модификаторы
        Class classCat = Cat.class;
        classCat.isArray();
        classCat.getSimpleName();
        // Получим методы класса Cat
        Method[] methods = classCat.getMethods(); //можно получить конкретный метод, указав имя метода и набор его аргументов
        Method[] methods1 = classCat.getDeclaredMethods();
        for (Method o : methods)
            System.out.println(o.getName()); // получим также методы, которые наследуются от Object
        System.out.println();
        for (Method o : methods1)
            System.out.println(o.getName()); // получим методы класса cat в т.ч. приватные

        Cat cat = new Cat(1, 2, 3);
        methods[0].invoke(cat); //вызываем метод public meow у объекта cat,
        // если метод ожидает аргументы их нужно подавать в invoke()
        methods1[1].setAccessible(true); // даем доступ к приватному методу private meow
        methods1[1].invoke(cat); //попытка вызвать приватный метод private meow вызывает исключение IllegalAccessException
        System.out.println();

        int mods = methods[0].getModifiers();
        System.out.println("int значение getModifiers: " + mods); //int число, представляется в двоичном виде напр 1010 и каждый разряд отвечает за
        // то есть(1) какой-то модификатор доступа или его нет(0), когда мы вызываем методы isStatic и тд,
        // то они смотрят на разряд и возвращают true/false
        System.out.println("isStatic = " + Modifier.isStatic(mods));
        System.out.println("isFinal = " + Modifier.isFinal(mods));
        System.out.println("isPublic = " + Modifier.isPublic(mods));
        System.out.println();
        // Можем получить поля класса Cat
        Field[] fields = classCat.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        System.out.println("Значение второго поля: " + fields[1].get(cat)); //получаем значение второго поля у объекта cat
        fields[1].set(cat, 20); // меняем значение второго поля у объекта cat
        System.out.println("Значение второго поля после изменения: " + fields[1].get(cat));
        fields[0].setAccessible(true); // получили доступ к приватному полю
        System.out.println();

        Cat cat2 = (Cat)classCat.newInstance();
        System.out.println(cat2);
        /*
        Метод newInstance() позволяет создавать экземпляры класса через объект типа Class и возвращает
        объект типа Object. Если этот метод вызван у объекта типа Class, то для создания нового объекта
        используется конструктор по умолчанию. Если он отсутствует – будет брошено исключение. Если
        вначале получаем объект типа Constructor с заданным набором параметров, то newInstance()
        использует этот набор.
        */

        Cat cat3 = (Cat) classCat
                .getConstructor(int.class, int.class, int.class)
                .newInstance(20,30, 40);
        System.out.println(cat3);
        System.out.println("----------");

        //Загрузим класс вне проекта с помощью ClassLoader
        ClassLoader classLoader = new URLClassLoader(new URL[] {new File("C:/ClassLoaderFolder").toURL()});
        Class humanClass = classLoader.loadClass("Human");
        //создадим объект загруженного класса
        Object humanObj = humanClass.getConstructor(String.class, int.class).newInstance("Bob", 30);
        //метод загруженного класса
        Method greetingsMethod = humanClass.getMethod("greetings");
        greetingsMethod.invoke(humanObj); // вызываем метод greetings у humanObj

    }

    public static void classInfo() {
        Class strClass = String.class;
        //узнаем имя класса
        System.out.println("----------");
        System.out.println( "Полное имя класса: " + strClass.getName());
        System.out.println( "Простое имя класса: " + strClass.getSimpleName());
        //узнаем модификаторы, которые применены к классу
        int modifiers = strClass.getModifiers(); //возвращает int
        if (Modifier.isPublic(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - public" );
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - abstract" );
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - final" );
        }
        System.out.println("----------");
        // Для проверки модификаторов используются методы isPublic(), isPrivate(), isAbstract(), isFinal(), isNative(),
        // isInterface(), isSynchronized(), isVolatile(), isStrict(), isTransient(), isProtected(), isStatic().
    }
}

