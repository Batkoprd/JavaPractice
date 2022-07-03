package main.java.com.company.Generics_Collections_4;
/*
Перед нами стоит задача: создать класс, который позволит хранить в себе один объект любого типа. В
таком случае мы можем создать класс SimpleBox, у которого будет единственное поле типа Object, в
которое можно будет записать объект абсолютно любого типа.
 */
public class SimpleBox {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public SimpleBox(Object obj) {
        System.out.println("Конструктор SimpleBox, которая в себе хранит объект типа Object: " + obj + ", класса " + obj.getClass().getSimpleName());
        this.obj = obj;
    }
    public void info() {

        System.out.println(obj.getClass().getSimpleName() + " " + obj);
    }
}

/*
● каждый раз, когда мы хотим вытащить данные из нашей универсальной коробки, нам
необходимо выполнять приведение типов;
● чтобы не получить ClassCastException, перед каждым приведением типов необходимо делать
проверку типов данных с помощью instanceof;
● если мы где-то применим приведение типов и забудем прописать instanceof, то появится
вероятность появления ClassCastException в этой части кода.
 */
