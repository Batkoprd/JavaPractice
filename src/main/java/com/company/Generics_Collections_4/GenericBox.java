package main.java.com.company.Generics_Collections_4;

public class GenericBox<T> { //Обобщения работают только со ссылочными типами данных. Для работы с примитивами надо будет использовать классы-обёртки.
    /*
    T - Type
    E - Element Collections
    K, V Key Value
    */
    T obj;
    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public GenericBox(T obj) {
                System.out.println("Конструктор GenericBox коробки, содержащий объект " + obj + " класса " + obj.getClass().getSimpleName());
        this.obj = obj;
    }

    // нельзя создавать объекты и массивы, тк неизвестно какой тип,
    // но можно прокидывать объекты в методы
    public void doSomething(T[] arr) {
        // T object = new T();
    }

    // нельзя создавать статические поля с типом T : static T staticField = ...
    // потому что статическое поле должно быть общим для всех объектов класса
    // а T может быть разными типами
}
