/**
 * Created by GaBi on 27.11.2015.
 */
/*
Создать программу, проверяющую и сообщающую на экран,
является ли целое число записанное в переменную n, чётным
либо нечётным.
 */

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        System.out.print("Enter integer number: ");
        if (n.hasNextInt()){
            int EvenOrOddNumber = n.nextInt();
            if (EvenOrOddNumber % 2 == 0)
                System.out.println("An even number was entered!");
            else System.out.println("An odd number was entered!");
        }
        else System.out.print("You have not entered an integer number. Please enter an integer number!");
    }
}
