package main.java.com.company.Exeptions_3.HW3Solution;

public class MyArraySizeException extends MyException{
    public MyArraySizeException() {
        super("Размер входного массива не 4х4");
    }
}
