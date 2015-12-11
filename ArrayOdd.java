/**
 * Created by GaBi on 04.12.2015.
 */
/*
Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а
затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97
95 93 … 7 5 3 1).
 */
public class ArrayOdd {
    public static void main(String[] args){
        int[] oddNumber;
        int j=1;
        oddNumber = new int[50];
        for (int i = 0; (i <= oddNumber.length - 1) && (j < 100); i++) {
            oddNumber[i] = j;
            j=j+2;
            System.out.print(oddNumber[i] + " ");
        }
        System.out.println("");
        for (int i = oddNumber.length-1; i >= 0; i--) {
            System.out.print(oddNumber[i] + " ");
        }
    }
}
