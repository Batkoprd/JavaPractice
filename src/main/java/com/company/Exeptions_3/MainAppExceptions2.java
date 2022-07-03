package main.java.com.company.Exeptions_3;

import java.util.Arrays;

public class MainAppExceptions2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    if(arr[i][j] == 7 || arr[i][j] == 12) {
                        System.out.println("Выкидываем кастомное MyMatrixException: ");
                        throw new MyMatrixException(i,j,arr);
                }
                } catch (MyMatrixException e) {
                    System.out.println("Было поймано кастомное MyMatrixException: " + e);
                    System.out.println("Присваиваем ячейке матрицы, из-за которой возникло исключение, новое значение.");
                    arr[e.getRow()][e.getColumn()] = 666;
                }
            }
        }
        System.out.println("Матрица приобрела вид: ");
        for (int[] s : arr) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println("---------------------------------");


        int[] data = {1,2,3,4,5};
        // int index = User input
        int index = 12;

        /* В тех ситуациях, если можно защититься ifом, то лучше защищаться ifом
        if (index < data.length) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

         */

        try {
            System.out.println("Вызываем ArrayIndexOutOfBoundsException в блоке try.");
            System.out.println(data[index]);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Ловим ArrayIndexOutOfBoundsException в блоке catch " + e);
        } finally {
            System.out.println("При правильной работе приложения и без попыток системного прерывания блок finally\n" +
                    "будет выполняться всегда.");
        }
    }
}
