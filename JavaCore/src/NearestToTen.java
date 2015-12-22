/**
 * Created by BIL on 27.11.2015.
 */
/*
Создать программу, выводящую на экран ближайшее к 10 из
двух чисел, записанных в переменные m и n. Например, среди
чисел 8,5 и 11,45 ближайшее к десяти 11,45.
 */
import java.util.Scanner;

public class NearestToTen {
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        System.out.print("Enter first number to compare with ten: ");
        if (n.hasNextFloat()){
            float FirstNumber = n.nextFloat();
            Scanner m = new Scanner(System.in);
            System.out.print("Enter second number to compare with ten: ");
            if (m.hasNextFloat()){
                float SecondNumber = m.nextFloat();
                if (Math.abs(FirstNumber - 10) > Math.abs(SecondNumber - 10))
                    System.out.print("Number " + SecondNumber + " is nearest to 10 then " + FirstNumber + "!");
                else System.out.print("Number " + FirstNumber + " is nearest to 10 then " + SecondNumber + "!");

            }
        }
    }
}
