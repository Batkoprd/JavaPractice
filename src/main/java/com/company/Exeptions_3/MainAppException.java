package main.java.com.company.Exeptions_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;


public class MainAppException {
          // try catch finally throw throws
    public static void main (String[]args){
//        int x = 10/0; - ArithmeticException
//        int x = Integer.parseInt("1s0"); - NumberFormatException
//        String string = null;
//        System.out.println(string.length()); - NullPointerException
            try {
                System.out.println(1);
                int x = 10 / 0;
                System.out.println(2);
            } catch (ArithmeticException e) {
                System.out.println("AE catched");
//             e.printStackTrace();
            } finally { //блок finally срабатывает всегда
                System.out.println(3);
            }


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

        try {
            a();
        } catch (ArithmeticException e) {
            System.out.println("main перехватил AE");
        }

        //    int a = 10/0; - unchecked exception;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("1.txt"); // checked exception метод throws исключение
            out.write(1); // при записа файла может возникнуть исключение и файл останется открыт
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

        System.out.println();
        System.out.println("До throw");
        try {
            throw new RuntimeException("Runtime Exception");
        } catch (RuntimeException e) {
            System.out.println("RE");
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

        System.out.println(doSomethingfinally()); //вернет 2, даже если finally после return - так лучше не делать

        throw new MyLibException("Мое исключение");



    }

    public static void a () {
        b();
    }

    public static void b () {
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

    public static int doSomethingfinally() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

}




