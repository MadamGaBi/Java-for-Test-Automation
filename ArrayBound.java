/**
 * Created by GaBi on 04.12.2015.
 */
/*
Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на
экран. Подсчитайте сколько в массиве чётных элементов и выведете это количество на
экран на отдельной строке.
 */
public class ArrayBound {
    public static void main(String[] args){
        int[] randomNumber;
        int j=0;
        randomNumber = new int[15];
        System.out.println("Random Numbers from 0 to 9: ");
        for (int i = 0; i <= randomNumber.length - 1; i++) {
            randomNumber[i] = (int)(Math.random() * 10);
            System.out.print(randomNumber[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i <= randomNumber.length - 1; i++) {
            if (randomNumber[i] % 2 == 0) {
                j += 1;
            }
        }
        System.out.println("Quantity of Even Numbers: " + j);
    }
}
