package com.company.Exeptions_3.HW3;

public class MyArraySizeException extends MyCustomException{
    private int len;

    public int getLen() {
        return len;
    }

    public MyArraySizeException(int len) {
        super("Method accepts only 4x4 arrays. ");
        this.len = getLen();
    }
}
