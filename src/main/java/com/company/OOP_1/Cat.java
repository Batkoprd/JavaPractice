package main.java.com.company.OOP_1;

public class Cat {
    // 4 модификатора доступа - private default protected public
    // private означает, что доступ к этим полям возможен только изнутри этого класса
    // default означает, что доступ возможет из этого класса + из любого класса внутри пакета, в котором лежит Кот
    // protected внутри класса от private, внутри пакета от default и из любого наследника этого класса
    // public это максимальный уровень доступа
    // нужно стараемся делать минимальный уровень доступа, который снизит вероятность ошибок

    private String name; // все ссылочные типы данных проинициализированны null, булевые false, числа 0
    private String color;
    private int age; //static поле является общим для всех объектов класса,
                    // т.е. все коты будут одного возраста, если static int age

    public String getName() { // метод который возвращает значение из поля, такой же тип как у поля
                              // если удалить сеттер, то будет read-only поле
        return name;
    }

    public void setName(String name) { // позволяет менять значение поля
        if (name.length() > 2){       // можно установить какие-то условия для значения поля
            this.name = name;         // this это ссылка на объект у которого мы вызываем данный метод
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


    public Cat(String name, String color, int age) { //конструктор
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void info() {
        System.out.println(name + " " + color + " " + age);
    }

    public void meow() {
        System.out.println(name + " meow");
    }

    public static void doSomething() {  //статический метод подвязывается к классу
                                        // это означает, что для вызова метода не нужны никакие объекты
                                        // Cat.doSomething();
                                        // в статическом методе можно вызывать только статические поля, тк неизвестно
                                        // к какому объекту относится поле

        System.out.println(123);
    }



}
