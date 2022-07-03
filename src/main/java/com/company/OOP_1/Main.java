package main.java.com.company.OOP_1;
import main.java.com.company.OOP_1.animals.AnimalAbstractSuperclass;
import main.java.com.company.OOP_1.animals.CatExtendsAnimal;
import main.java.com.company.OOP_1.animals.DogExtendsAnimal;

public class Main {
    public static void main(String[] args) {
        int c;
        // Cat cat - создаем ссылку на объект, сам объект кладется в heap(кучу), эта ссылка может
        // Область памяти, в которой создаются и хранятся объекты, называется heap (куча).
        // Ссылаться на объект типа Cat() либо на его наследника,
        // оператор new выделяет память в heape под объект типа Cat(), после чего вызывается
        // конструктор из класса, он инициализирует объект и ссылка на объект кладется в cat

        Cat cat = new Cat("Barsik", "White", 2);
        Cat cat2 = new Cat("Murzik", "Black", 4);
        /*
        Cоздали объект типа Cat (экземпляр класса Cat), и, чтобы с ним работать, положили его в переменную,
        которой присвоили имя cat. в переменной не лежит весь объект, а только ссылка, где его искать в памяти.
         */



//        Cat cat3;  // не инициализированный кот
// Объект cat создан по «чертежу» Cat , и значит у него есть поля name, color, age.
// Для доступа к полям объекта служит операция «точка», которая связывает имена объекта и поля.
//        cat3.info();
//        cat.name = " Barsik";
//        cat.color = "white";
//        cat.age = 2;
//        cat2.name = " Murzik";
//        cat2.color = "black";
//        cat2.age = 4;
        Cat.doSomething(); // Статический метод класса Cat() для которого не нужно создание объекта класса

        Cat[] cats = new Cat[2]; // {null, null}
        cats[0] = new Cat("A", "A", 1);
        cats[1] = new Cat("B", "B", 2);

        cats[0].info();
        cat.info();
        cat2.info();
        System.out.println("---------------------------------");

        System.out.println("catB ссылается на тот же объект, что и catA?");
        /*
        catB присваивается ссылка на копию объекта catA, то есть переменные cat1 и cat2 будут ссылаться на разные объекты
        в памяти. Но catA и catB будут ссылаться на один объект. Присваивание переменной catA значения переменной
        catB не привело к выделению области памяти или копированию объекта, а только к тому, что переменная catB ссылается
        на тот же объект, что и переменная catA. Изменения, внесенные в объекте по ссылке catB, окажут влияние на объект,
        на который ссылается переменная cat1, — поскольку это один объект в памяти.
         */
        Cat catA = new Cat();
        Cat catB = catA;
        System.out.println(catB.equals(catA));
        System.out.println("---------------------------------");



        // очередность стека: main -> int c -> cat1 -> cat2 -> doSomething -> int b
        // метод doSomething завершает свою работу и джава выкидывает из стека все что связано с doSomething
        // потом доходим до main и выкидываем все его локальные переменные, поэтому переменные main метода
        // выходят из стека последними
        // ссылка на объект может лежать в heapе, так и в стеке, как и примитивы
        doSomething();

        // класс кот наследуемый из класса animal
        CatExtendsAnimal cat3 = new CatExtendsAnimal("Vasya", "Orange", 5, 6);
        cat3.voice();

        DogExtendsAnimal dog =new DogExtendsAnimal("Bobik", "white", 4);
        dog.voice();


        // Main$1
//        Animal animal = new Animal() {
//            @Override
//            public void voice() {
//
//            }
//        };

        AnimalAbstractSuperclass cat4 = new CatExtendsAnimal("A", "B", 1, 4);
        // наследники могут вызывать методы родителей, а наоборот нет
        if (cat4 instanceof CatExtendsAnimal) {
            ((CatExtendsAnimal) cat4).catMethod(); //вызываем catMethod из класса animal
        } else {
            System.out.println("не кот");
        }



        AnimalAbstractSuperclass[] catsAndDogs = {
                new CatExtendsAnimal("Sneg", "White", 5, 3),
                new DogExtendsAnimal("Sharik", "black", 4)
        };
        for (AnimalAbstractSuperclass o : catsAndDogs) {
            o.voice();
        }
        System.out.println("---------------------------------");


        System.out.println("При работе с суперклассами и подклассами можно создать ссылку на суперкласс и записать в нее\n" +
                "объект подкласса: ");
        AnimalAbstractSuperclass animal = new CatExtendsAnimal("Снежок", "Белый", 2, 1);
        System.out.println(animal);
        animal.voice();
        /*
        Если в классе CatExtendsAnimal есть метод catMethod(), который мы захотим выполнить через переменную animal,
        необходимо явно указать класс, с которым мы работаем: ((CatExtendsAnimal)animal). Это называется casting —
        «закастить». После этого сможем пользоваться методами и полями из класса Cat.
         */
        ((CatExtendsAnimal)animal).catMethod();
        System.out.println("---------------------------------");


        Box box1 = new Box("Green", 2);
        Box box2 = new Box("Green", 2);
        System.out.println("box1: " + box1 + "\n" + "box2: " + box2);
        // зеленое и зеленое, размеры одинаковы получим true
        System.out.println(box1.equals(box2) + " - результат equals на двух объектах типа Box");


    }
    public static void doSomething() {
        System.out.println("Вызов метода doSomething класса Main");
        System.out.println("---------------------------------");
        int b;

    }
}

/*
Сборка мусора. Поскольку выделение памяти под объекты осуществляется динамически с помощью
оператора new, в процессе выполнения программы необходимо периодически удалять объекты —
очищать память, иначе она может закончиться. В Java освобождение оперативной памяти
осуществляется автоматически и называется сборкой мусора. Если на объект нет ссылок, считается,
что он больше не нужен, и занимаемую им память можно освободить. Во время выполнения
программы сборка мусора выполняется с периодически, а не как только один или несколько объектов
перестают использоваться.
 */
