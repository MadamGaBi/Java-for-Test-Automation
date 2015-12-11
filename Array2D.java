/**
 * Created by GaBi on 04.12.2015.
 */
/*
Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых
чисел из отрезка [-5;5]. Вывести массив на экран. После в отдельной строке
вывести на экран значение максимального элемента этого массива.

Определить и вывести на экран индекс строки с наибольшим по модулю произведением элементов.
Если таких строк несколько, то вывести индекс первой встретившейся из них.

Преобразовать массив таким образом, чтобы на первом месте в каждой строке стоял её наибольший элемент.
При этом изменять состав массива нельзя, можно только переставлять элементы в рамках
одной строки. Порядок остальных элементов строки не важен (т.е. можно соврешить
только одну перестановку, а можно отсортировать по убыванию каждую строку).
Вывести преобразованный массив на экран.
 */
import java.util.Arrays;

public class Array2D {
    public static int[] findMaxValue (int[ ][ ] da){
       /*
       Find max element of matrix, numbers of row (maxRow) and column (maxCol) with max element
        */
        int max = da[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < da.length; i++) {
            for (int j = 0; j < da[i].length; j++) {
                if (max < da[i][j]){
                    max = da[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        int[] mas = {max, maxRow + 1, maxCol + 1};
        return (mas);
    }

    public static void findRowMaxMult (int[ ][ ] da){
        /*
        Multiply elements in every row (maxMult), find number of row (newMaxRow) in matrix with max multiplication
         */
        int[] maxMult = new int[da.length];
        for(int i=0; i<da.length; i++) {
            maxMult[i] = 1;
            for(int j=0; j<da[i].length; j++) {
                maxMult[i] *= Math.abs(da[i][j]);
            }
        }
        for(int i=0; i<maxMult.length; i++) {
            System.out.println("Multiplication of elements in row " + (i + 1) + " is " + maxMult[i]);
        }
        int max = maxMult[0];
        int newMaxRow = 0;
        for (int i = 0; i <= maxMult.length-1; i++) {
            if (max < maxMult[i]){
                max = maxMult[i];
                newMaxRow = i;
            }
        }
        System.out.println("Row maximum multiplication of elements is " + max + " in row " + (newMaxRow + 1));
    }

    public static void sortRowsArray(int[ ][ ] da){
        /*
        Print matrix with sorted rows
         */
        for(int i=0; i<da.length; i++) {
            Arrays.sort(da[i]);
        }
        for(int i=0; i<da.length; i++) {
            for(int j=da[i].length - 1; j>=0; j--) {
                System.out.print(da[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        /*
        Fill and print matrix with random elements
         */
        int[ ][ ] da = new int[8][5];
        for(int i=0; i<da.length; i++) {
            for(int j=0; j<da[i].length; j++) {
                da[i][j] = (int)(Math.random()*11 - 5);
            }
        }
        System.out.println("Matrix with random elements: ");
        for(int i=0; i<da.length; i++) {
            for(int j=0; j<da[i].length; j++) {
                System.out.print(da[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("Maximum of matrix is " + findMaxValue(da)[0]);
        System.out.print(" in row " + findMaxValue(da)[1]);
        System.out.print(" and in column " + findMaxValue(da)[2]);
        System.out.println("");
        System.out.println("--------------------------------------------");
        findRowMaxMult(da);
        System.out.println("--------------------------------------------");
        System.out.println("Matrix with sorted rows: ");
        sortRowsArray(da);
    }
}
