/**
 * Created by GaBi on 04.12.2015.
 */
/*
Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на
экран сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик
(отделяя один элемент от другого началом новой строки).
 */
public class ArrayEven {
    public static void main(String[] args){
        int[] evenNumber;
        int j=2;
        evenNumber = new int[10];
        for (int i = 0; (i <= evenNumber.length - 1) && (j <= 20); i++) {
            evenNumber[i] = j;
            j=j+2;
            System.out.print(evenNumber[i] + " ");
        }
        System.out.println("");
        for (int i = 0; (i <= evenNumber.length - 1); i++) {
            System.out.println(evenNumber[i]);
        }
    }
}