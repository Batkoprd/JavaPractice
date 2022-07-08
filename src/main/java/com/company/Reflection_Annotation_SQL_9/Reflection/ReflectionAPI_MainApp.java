package main.java.com.company.Reflection_Annotation_SQL_9.Reflection;

import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import org.sqlite.*;

public class ReflectionAPI_MainApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, MalformedURLException, ClassNotFoundException {
        /*
        Когда запускается приложение, то Джава не загружает в память все классы, которое есть, а подгружает их
        по мере обращения. Когда классы загружаются в память они складываются в специальном месте - metaspace

        Java Reflection API позволяет исследовать классы, интерфейсы, поля и методы во время выполнения
        программы, ничего не зная о них на этапе компиляции. Также с ее помощью можно создавать новые
        объекты, вызывать у них методы и работать с полями.
        */
        System.out.println("Название getName() этого класса: " + ReflectionAPI_MainApp.class.getName());
        System.out.println("String.class: " + String.class);
        System.out.println("int.class: " + int.class);
        System.out.println("int[].class: " + int[].class);
        System.out.println("int[][][].class: " + int[][][].class);
        System.out.println("void.class: " + void.class);

        Class<? extends String> stringClass = "Java".getClass(); // У любого Java объекта можно вызвать метод getClass(), который вернет объект типа Class
        Class<Integer> integerClass = Integer.class;
        Class<Integer> intClass = int.class;
        Class<Void> voidClass = void.class;
        Class<char[]> charArrayClass = char[].class;
        System.out.println("\nУ любого Java объекта можно вызвать метод getClass(), который вернет объект типа Class: " + stringClass);
        System.out.println("\nЗапросить объект типа Class напрямую у класса: " + integerClass + "\n"
                + intClass + "\n"
                + voidClass + "\n"
                + charArrayClass);

        //Вызвать статический метод Class.forName(), и передать ему полное имя класса в качестве аргумента.
        try {
//            Class jdbcClass = Class.forName("org.sqlite.jdbc");
            Class stringClass3 = Class.forName("java.lang.String");
            System.out.println("Статический метод Class.forName(): " + stringClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------");
        System.out.println("Узнаем информацию о классе с помощью нашего метода classInfo().");
        classInfo(String.class);
        System.out.println("---------------------------------");

        // через classCat можно узнать про модификаторы
        System.out.println("Поработаем с нашим классом Cat.");
        Class classCat = Cat.class;
        System.out.println("Cat isArray(): " + classCat.isArray());
        System.out.println("Простое имя: " + classCat.getSimpleName());
        // Получим методы класса Cat
        Method[] methods = classCat.getMethods(); //можно получить конкретный метод, указав имя метода и набор его аргументов
        Method[] methods1 = classCat.getDeclaredMethods();

        System.out.println("getMethods(), получим также методы, наследуемые от класса Object: ");
        for (Method o : methods)
            System.out.println("    " + o); // получим также методы, которые наследуются от Object
        System.out.println();
        System.out.println("getDeclaredMethods(), получим методы Cat в т.ч. приватные: ");
        for (Method o : methods1)
            System.out.println("    " + o); // получим методы класса cat в т.ч. приватные
        for (Method o : methods1) {
            System.out.println(o.getReturnType() + " ||| " + o.getName() + " ||| "
                    + Arrays.toString(o.getParameterTypes()));
        }


        Cat cat = new Cat(1, 2, 3);
        System.out.println("Вызываем метод publicMeow у объекта cat с помощью invoke(): ");
        methods[0].invoke(cat); //вызываем метод public meow у объекта cat,
        // если метод ожидает аргументы их нужно подавать в invoke()a
        System.out.println("Даем доступ к приватному методу privateMeow с помощью setAccessible(true) и вызываем его с помощью invoke(): ");
        methods1[1].setAccessible(true); // даем доступ к приватному методу private meow
        methods1[1].invoke(cat); //попытка вызвать приватный метод private meow вызывает исключение IllegalAccessException


        int mods = methods[0].getModifiers();
        System.out.println("\nint значение getModifiers: " + mods); //int число, представляется в двоичном виде напр 1010 и каждый разряд отвечает за
        // то есть(1) какой-то модификатор доступа или его нет(0), когда мы вызываем методы isStatic и тд,
        // то они смотрят на разряд и возвращают true/false
        System.out.println("isStatic = " + Modifier.isStatic(mods));
        System.out.println("isFinal = " + Modifier.isFinal(mods));
        System.out.println("isPublic = " + Modifier.isPublic(mods));
        // Можем получить поля класса Cat
        System.out.println("\nОбъект cat до изменения с помощью рефлексии: " + cat);
        Field[] fields = classCat.getDeclaredFields();
        System.out.println("Поля класса Cat: ");
        for (Field f : fields)
            System.out.println(f);
        System.out.println("\nЗначение второго поля: " + fields[1].get(cat)); //получаем значение второго поля у объекта cat
        fields[1].set(cat, 20); // меняем значение второго поля у объекта cat
        System.out.println("Значение второго поля после изменения: " + fields[1].get(cat));
        fields[0].setAccessible(true); // получили доступ к приватному полю
        fields[0].set(cat, 666);
        System.out.println("Объект cat после изменения с помощью рефлексии: " + cat);
        /*
        Методы getConstructors() и getDeclaredConstructors() возвращают массив объектов типа
        Constructor. Они содержат в себе информацию о конструкторах класса: имя, модификаторы, типы
        параметров, генерируемые исключения.
         */
        System.out.println("\nКонструкторы класса Cat: ");
        Constructor[] constructors = classCat.getConstructors();
        for (Constructor o : constructors) {
            System.out.println(o);
        }


        Cat cat2 = (Cat)classCat.newInstance();
        System.out.println("\n Создали cat2 с помощью метода newInstance(): " + cat2);
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
        System.out.println("\nСоздали cat3 c помощью метода getConstructor: " + cat3);
        System.out.println("---------------------------------");

        //Загрузим класс вне проекта с помощью ClassLoader
        ClassLoader classLoader = new URLClassLoader(new URL[] {new File("C:/ClassLoaderFolder").toURL()});
        Class humanClass = classLoader.loadClass("Human");
        //создадим объект загруженного класса
        Object humanObj = humanClass.getConstructor(String.class, int.class).newInstance("Bob", 30);
        //метод загруженного класса
        Method greetingsMethod = humanClass.getMethod("greetings");
        greetingsMethod.invoke(humanObj); // вызываем метод greetings у humanObj

    }

    public static void classInfo(Class myClass) {
//        Class myClass = String.class;

        //узнаем имя класса
        System.out.println( "Полное имя класса: " + myClass.getName());
        System.out.println( "Простое имя класса: " + myClass.getSimpleName());

        /*
        Метод getModifiers() возвращает значение типа int, из которого, с помощью статических методов класса Modifier,
        можно определить какие именно модификаторы были применены к классу.
         */
        int modifiers = myClass.getModifiers(); //возвращает int
        System.out.println("Метод getModifiers() возвращает значение int: " + modifiers);
        System.out.println("\nУзнаем модификаторы, которые применены к классу: ");

        if (Modifier.isPublic(modifiers)) {
            System.out.println(myClass.getName() + " - public" );
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(myClass.getName() + " - abstract" );
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(myClass.getName() + " - final" );
        }

         /*
        Метод getSuperclass() позволяет получить объект типа Class, представляющий
        суперкласс рефлексированного класса. Для получения всей цепочки родительских классов достаточно
        рекурсивно вызывать метод getSuperclass() до получения null. Его вернет Object.class.getSuperclass(),
        так как у него нет родительского класса.
         */
        System.out.println("Метод getSuperclass() для класса " + myClass.getSimpleName() + ": " + myClass.getSuperclass());

        //Метод getInterfaces() возвращает массив объектов типа Class.
        //Каждый из них представляет один интерфейс, реализованный в заданном классе.
        System.out.println("\nМетод getInterfaces() для класса " + myClass.getSimpleName() + ": ");
        for (Class s : myClass.getInterfaces())
            System.out.println("    " + s);

        System.out.println("\nМетод getFields() для класса " + myClass.getSimpleName() + ": ");
        for (Field f : myClass.getFields())
            System.out.println("    " + f);

        System.out.println("\nМетод getDeclaredFields() для класса " + myClass.getSimpleName() + ": ");
        for (Field f : myClass.getDeclaredFields())
            System.out.println("    " + f);

        // Для проверки модификаторов используются методы isPublic(), isPrivate(), isAbstract(), isFinal(), isNative(),
        // isInterface(), isSynchronized(), isVolatile(), isStrict(), isTransient(), isProtected(), isStatic().
    }
}

