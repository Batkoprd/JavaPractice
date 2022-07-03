package main.java.com.company.Exeptions_3;

public class MyMatrixException extends MyLibException {
    private int row;
    private int column;
    private int value;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }

    public MyMatrixException(int row, int column, int[][] arr) {
        super("Invalid data in [" + row + ";" + column + "]: " + arr[row][column]);

        this.row = row;
        this.column = column;
        this.value = arr[row][column];
    }

}
