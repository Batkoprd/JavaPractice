package main.java.com.company.Exeptions_3;

public class MyLibException extends RuntimeException{
    public MyLibException() {
    }
    public MyLibException(String message) {
        super(message);
    }
}
