package main.java.com.company.Exeptions_3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

/*
Исключения в Java представляют собой объекты, генерируемые при возникновении ошибочных
ситуаций и содержащие информацию о них. Все исключения можно разделить на три группы:
1. Класс Exception и его подклассы: исключения, которые обязательно должны быть
перехвачены программой (Checked).
2. Класс RuntimeException и его подклассы: исключения, охватывающие такие ситуации, как
деление на ноль или ошибочная индексация массивов (Unchecked).
3. Класс Error и его подклассы: исключения, которые не должны появляться при нормальном
выполнении программы. Используются для обозначения ошибок, возникающих в самой
исполняющей среде (таких, как переполнение стека).

Обработать исключение можно одним из двух способов:
● Поместить код, бросающий исключение, в блок try-catch.
● Пробросить исключение методу на уровень выше, то есть методу, который вызывает текущий
метод. Для этого используется ключевое слово throws.

Две группы исключений типа Exception:
● Checked — такие исключения обязательно нужно обрабатывать одним из двух
вышеописанных способов. Если checked-исключение оставить в коде как есть, возникнет
ошибка на этапе компиляции.
● Unchecked — их можно обрабатывать, если есть вероятность возникновения, но можно и не
обрабатывать, поскольку предполагается, что при правильном поведении программы такие
исключения вовсе не должны возникать. Действительно, если массив состоит из 8 элементов,
то код не должен обращаться к десятому.
 */


public class MainAppException {
          // try catch finally throw throws
    public static void main (String[]args){
//        int x = 10/0; - ArithmeticException
//        int x = Integer.parseInt("1s0"); - NumberFormatException
//        String string = null;
//        System.out.println(string.length()); - NullPointerException
            try {
                System.out.println("До возникновения ArithmeticException");
                int x = 10 / 0;
                System.out.println("После возникновения ArithmeticException");
                System.out.println ( "Это сообщение не будет выведено в консоль" );
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught, деление на ноль");
//             e.printStackTrace();
            } finally { //блок finally срабатывает всегда
                System.out.println("Сработал блок finally");
            }
        System.out.println("---------------------------------");



        //try-catch могут быть вложенные

//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(8189);
//        }  catch (IOException e) {
//            e.printStackTrace();
//            try {
//                serverSocket.close();
//            } catch (IOException e1){
//                e1.printStackTrace();
//            }
//        }

        System.out.println("Блоков catch может быть несколько: ");
        try {
            int a = 10 ;
            a -= 10 ;
            int b = 42 / a ;
            int[] с = { 1 , 2 , 3 };
            с[42] = 99 ;
        } catch (ArithmeticException е) {
            System.out.println ( "Первый блок catch, дeлeниe на ноль: " + е);
        } catch (ArrayIndexOutOfBoundsException е){
            System.out.println ( "Второй блок catch, ошибка индексации массива: " + е);
        }
        /*
        Применяя несколько операторов catch, нужно помнить, что перехватывать исключения из подклассов
        нужно раньше, чем из суперклассов. Дело в том, что оператор саtch, в котором перехватывается
        исключение из суперкласса, будет перехватывать все исключения этого суперкласса, а также всех его
        подклассов. Это означает, что исключения из подкласса вообще не будут обработаны, если
        попытаться перехватить их после исключений из его суперкласса.
         */
        System.out.println("---------------------------------");

//        try {
//            int а = 0 ;
//            int b = 42 / а;
//        } catch (Exception е) {
//            System.out.println ( "Exception" );
//        }
//        catch (ArithmeticException е) { // Ошибка компиляции: недостижимый код!
//            System . out . println ( "Этот код недостижим" );
//        }


        try {
            methodCallingMethodCausingArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("main перехватил ArithmeticException");
        }

        //    int a = 10/0; - unchecked exception;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("1.txt"); // checked exception метод throws исключение
            out.write(1); // при записи файла может возникнуть исключение и файл останется открыт
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }


        try (FileOutputStream out2 = new FileOutputStream("11.txt")) {
             //try с ресурсами работает только на Closeable, который наследуется от AutoCloseable
            FileOutputStream in = new FileOutputStream("22.txt");
        } catch (IOException e) {
            System.out.println();
        }

//    public FileOutputStream(String name) throws FileNotFoundException {
//        this(name != null ? new File(name) : null, false);

        System.out.println("---------------------------------");
        System.out.println("До throw");
        try {
            System.out.println("В блоке try пробрасывается RuntimeException");
            throw new RuntimeException("RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("В блоке catch пойман RuntimeException");
        }

        int coef = 0;
        try {
            coef = sqrt(-100);
        } catch (ArithmeticException e) {
            coef = 7;
        }

        try {

        } catch (RuntimeException e) {
            System.out.println(1);
            throw new ArithmeticException(); // можно кидать исключение в блоке catch
        }

        try {
            doSomething();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ReportMaker.makePDFReport("3.txt", "4423423sdvf");

        try {
            ReportMaker.makePDFReportCorrect("4.txt", "gfdsgdf");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------");
        System.out.println("Метод doSomethingFinally(), который возвращает значение после return из блока finally " + "\n"
                + doSomethingfinally()); //вернет 2, даже если finally после return - так лучше не делать

        try{
            System.out.println("---------------------------------");
            System.out.println("До проброса кастомного MyLibException");
            throw new MyLibException("Мое исключение");
        } catch (MyLibException e) {
            System.out.println("Поймали кастомное MyLibException");
        }
    }

    public static void methodCallingMethodCausingArithmeticException() {
        methodCausingArithmeticException();
    }

    public static void methodCausingArithmeticException() {
        int x = 10 / 0;
    }


    public static int sqrt(int n) {
        if (n < 0) {
            // давайте например если отрицательное число будем возвращать return 0
            // или например 8765, если мы ввели отрицательное число, но это фигня, поэтому используем исключение.
            throw new ArithmeticException("Невозможно взять корень от отрицательного числа");
        }
        return n / 2; // допустим мы так считаем корень, но корня из отрицательного числа не бывает
    }

    public static void doSomething() throws FileNotFoundException { //В этом методе не обрабатываются чекед исключения
        // их должен обрабатывать тот, кто их вызывает
        FileOutputStream out = new FileOutputStream("2.txt");
    }

    public static String doSomethingfinally() {
        try {
            return "Значение return из блока try";
        } finally {
            return "Значение return из блока finally";
        }
    }

}




