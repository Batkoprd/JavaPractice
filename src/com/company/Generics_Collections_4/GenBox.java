package com.company.Generics_Collections_4;

public class GenBox<T> {
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

    public GenBox(T obj) {
        this.obj = obj;
    }

    // нельзя создавать объекты и массивы, тк неизвестно какой тип,
    // но можно прокидывать объекты в методы
    public void doSomething(T[] arr) {
        // T object = new T();
    }

    // нельзя создавать статические поля  с типом T : static T staticField = ...
    // потому что статическое поле должно быть общим для всех объектов класса
    // а T может быть разными типами
}
