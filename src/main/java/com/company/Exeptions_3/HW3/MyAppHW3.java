package main.java.com.company.Exeptions_3.HW3;

public class MyAppHW3 {
    public static void main(String[] args) {

        String[][] myarr = {
                {"1","1","1","1"},
                {"1","100","1","1"},
                {"1","1","1","1"},
                {"1","1","1","1"}
        };


        System.out.println(myMatrixMethod(myarr));



    }

    public static int myMatrixMethod(String[][] array) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;

        if (array.length != 4){
            throw new MyArraySizeException(array.length);
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException(array[i].length);
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                for (int k = 0; k < array[i][j].length(); k++) {
                    if (!Character.isDigit(array[i][j].charAt(k))) {
                        throw new MyArrayDataException(i, j, array);
                    }
                }
                sum += Integer.parseInt(array[i][j]);
            }
        }

        return sum;

    }
}
