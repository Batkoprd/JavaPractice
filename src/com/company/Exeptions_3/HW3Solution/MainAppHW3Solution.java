package com.company.Exeptions_3.HW3Solution;

public class MainAppHW3Solution {
    public static void main(String[] args) {
        String[][] arr = {
                {"1","2","2","1"},
                {"1","2","4a","1"},
                {"1","2","2","1"},
                {"1","2","2","1"}
        };
        try {
            System.out.println(calculate(arr));

        } catch (MyException e) {
            System.out.println("Ignored MyException");
        }



    }

    public static int calculate(String[][] data) {
        if (data.length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            if (data[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(data[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyDataException();
                }

            }

        }
        return sum;

    }
}
