package com.company.Exeptions_3.HW3;

public class MyArrayDataException extends MyCustomException{
    private int row;
    private int column;
    private String value;

    public int getRow() {
        return row;
    }


    public int getColumn() {
        return column;
    }


    public Object getValue() {
        return value;
    }


    public MyArrayDataException(int row, int column, String[][] arr) {
        super("Invalid data in [" + row + "; " + column + "]: " + arr[row][column]);

        this.row = row;
        this.column = column;
        this.value = arr[row][column];
    }

}
