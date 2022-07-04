package main.java.com.company.OOP_1.animals;
/*
Наследование позволяет создать класс (суперкласс), определяющий общие черты набора классов,
а затем этот общий класс могут наследовать более специализированные классы (подклассы),
дополняя особыми характеристиками.
Подкласс будет наследовать члены, определенные в суперклассе, в соответствии с их
модификаторами доступа. Если у суперкласса будет private-поле, то подкласс не унаследует это
поле.
Для каждого создаваемого класса можно указать только один суперкласс — в Java не
поддерживается множественное наследование.
 */


public abstract class AnimalAbstractSuperclass extends Object{ // все классы наследуются от класса Object

    // убрали модификатор доступа private, чтобы поля могли переходить к классам наследникам
    // модификатор default, но мы не хотим чтобы левые классы могли менять поля наследуемого класса
    // модификатор protected означает что поле доступно всем классам внутри пакета и всем наследникам
    // можно использовать объекты с одинаковыми именами из разных пакетов
    protected String name;
    protected String color;
    protected int age;

    public AnimalAbstractSuperclass() { // дефолтный конструктор
        this.name = "Unknown";
        this.color = "Unknown";
        this.age = 1;
    }

    public AnimalAbstractSuperclass(String name) { // как только создаем наш конструктор ^ дефолтный больше не работает,
                                // если мы его не переобъявим его вручную
        this.name = name;
        this.color = "Unknown";
        this.age = 1;
    }

    // Конструкторов может быть сколько угодно. Бывает что мы создаем объекты из разных источников из файла\потока\облака и тд
    public AnimalAbstractSuperclass(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }


    public void info() {
        System.out.println(name + " " + color + " " + age + " - метод info() суперкласса Animal");
    }

    // если в каком-то классе есть метод, который есть у наследников и каждый наследник должен по-своему его реализовывать
    // то мы создаем абстрактный метод, но абстрактные методы должны быть в абстрактных классах
    // мы не можем создать объект абстрактного класса

    public abstract void voice(); // наследник должен реализовать все абстрактные методы родителя
//    public void voice() {
//        System.out.println(name + " животное издало звук");
//    }

}

/*
Что нужно помнить об абстрактных классах:
● нельзя создать объект абстрактного класса;
● в абстрактном классе могут быть конкретные реализации методов;
● если в классе объявлен хоть один абстрактный метод, сам класс должен быть объявлен
абстрактным.
Абстрактные классы не позволяют получать экземпляры объектов, их все же
можно применять для создания ссылок на объекты подклассов.
 */