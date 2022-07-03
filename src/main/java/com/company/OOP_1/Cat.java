package main.java.com.company.OOP_1;

public class Cat {
    // 4 модификатора доступа - private default protected public
    // private означает, что доступ к этим полям возможен только изнутри этого класса
    // default означает, что доступ возможет из этого класса + из любого класса внутри пакета, в котором лежит Кот
    // protected внутри класса от private, внутри пакета от default и из любого наследника этого класса
    // public это максимальный уровень доступа
    // нужно стараемся делать минимальный уровень доступа, который снизит вероятность ошибок

    /*                                                  private | default | protected | public
Один и тот же класс                                        +    |    +    |     +     |    +
Подкласс, производный от класса из того же пакета          -    |    +    |     +     |    +
Класс из того же пакета, не являющийся подклассом          -    |    +    |     +     |    +
Подкласс, производный от класса другого пакета             -    |    -    |     +     |    +
Класс из другого пакета, не являющийся подклассом,
производный от класса данного пакета                       -    |    -    |     -     |    +
     */

    private String name; // все ссылочные типы данных проинициализированы null, булевые false, числа 0
    private String color;
    private int age; //static поле является общим для всех объектов класса,
                    // т.е. все коты будут одного возраста, если static int age



    /*
    Инкапсуляция говорит о том, что доступ к данным объекта должен осуществляться только через
    методы. Если поле экземпляра открыто для изменения напрямую присваиванием через точку, то на
    такое нарушение инкапсуляции должны быть веские основания. Для доступа к данным обычно
    используются методы, определенные в классе этого объекта: геттеры и сеттеры. Они позволяют
    полностью контролировать процесс установки и получения значений.
     */
    public String getName() { // Геттер позволяет узнать содержимое поля.
                              // Метод, который возвращает значение из поля, такой же тип как у поля, для которого он создан
                              // если удалить сеттер, то будет read-only поле
        return name;
    }
    public void setName(String name) { // позволяет менять значение поля
        if (name.length() > 2){       // можно установить какие-то условия для значения поля
            this.name = name;         // this это ссылка на объект у которого мы вызываем данный метод
        } else {
            System.out.println( "Введено некорректное имя" );
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    static int field1;
//    static int field2;
//
//    static { // статический блок инициализации
//        field1 = 1;
//        field2 = 2;
//    }

    public Cat() {
        /*
        Как только вы создали в классе свою реализацию конструктора, конструктор по умолчанию автоматически создаваться
        не будет. И если вам понадобится такая форма конструктора (в которой нет аргументов и которая ничего не делает),
        необходимо будет добавить конструктор по умолчанию вручную.
         */
        System.out.println("Дефолтный конструктор класса Cat");
    }

    public Cat(String name, String color, int age) { //конструктор
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void info() {
        System.out.println(name + " " + color + " " + age + " метод info() класса Cat.");
    }

    public void meow() {
        System.out.println(name + " meow" + " - метод meow() класса Cat.");
    }

    /*
    Ключевое слово static. Обращение к такому полю или методу должно осуществляться через имя класса.
    На методы, объявленные как static, накладываются следующие ограничения:

    1. Они могут непосредственно вызывать только другие статические методы.
    2. Им непосредственно доступны только статические переменные.
    3. Они не могут использовать ссылки типа this или super.
    Это следствие того, что static-метод не связан ни с одним из объектов.
     */
    public static void doSomething() {  //статический метод подвязывается к классу
                                        // это означает, что для вызова метода не создавать объекты класса Cat
                                        // Cat.doSomething();
                                        // в статическом методе можно вызывать только статические поля, тк неизвестно
                                        // к какому объекту относится поле
        System.out.println("Статический метод из класса Cat():");
        System.out.println(123);
        System.out.println("---------------------------------");
    }



}
