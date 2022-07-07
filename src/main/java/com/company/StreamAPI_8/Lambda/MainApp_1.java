package main.java.com.company.StreamAPI_8.Lambda;

interface Executable {
     int execute(int x);
}

class Runner {
    public void run(Executable e) {
       int a = e.execute(10);
        System.out.println(a);
    }

    public void run2(Executable2 e) {
        int a = e.execute2(10, 15);
        System.out.println(a);
    }
}

class ExecutableImplementation implements Executable {
    @Override
    public int execute(int x) {
        System.out.println("Первый способ с помощью класса, реализующего интерфейс");
        return x + 6;
    }
}

interface Executable2 {
    int execute2(int x, int y);
}


public class MainApp_1 {
    public static void main(String[] args) {
        //заменяет анонимные классы
        //анонимная функция, метод без названия

//        Thread thread = new Thread(() -> System.out.println("Hello"));
//        thread.start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        }).start();

        Runner runner = new Runner();

        runner.run(new ExecutableImplementation());
        System.out.println("--------------------------");

        int b = 1;
        runner.run(new Executable() {
            @Override
            public int execute(int x) {
                int b = 5;
                System.out.println("Второй способ с помощью анонимного класса");
                return x + 5;
            }
        });
        System.out.println("--------------------------");

        // лямбда автоматически понимает, что ей нужно вернуть int String bool и тд
        // она возвращает тот тип, который задан в сигнатуре метода. в лямбде мы не указываем тип возвращаемых значений
        runner.run((int x) -> {
            System.out.println("Третий способ с помощью лямбда выражения");
            System.out.println("Вторая строка");
            return x + 10;
        });
        System.out.println("--------------------------");

        //можно упростить сильнее без слова return
        runner.run((int x) -> x + 555);
        // можно не указывать тип
        runner.run((x) -> x + 655);
        // можно не писать круглые скобки
        runner.run(x -> x + 755);

        //можно подавать несколько аргументов
        runner.run2((x, y) -> x * y);

        // если в интерфейсе будет еще одна сигнатура метода, то лямбду уже использовать нельзя

        //если мы хотим передать в лямбу значение вне аргументов, то оно должно быть final либо effectively final, до объявления в лямбде переменная не должна меняться
        int a = 1;
        //a = 5; использовать уже не сможем в лямбде
        runner.run2((x,y) -> x + y + a);

        // у лямбды нет своей области видимости(scope), если мы попробуем переопределить переменную в лямбде,
        // то будет ошибка variable is allready defined in the scope
        runner.run2((x, y) -> {
//            int a = 5;
            int z = 5; // но мы можем создать новую переменную в лямбде и использовать ее
            return x + y + z;
        });
    }
}
