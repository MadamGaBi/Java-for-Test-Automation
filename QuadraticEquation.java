/**
 * Created by GaBi on 27.11.2015.
 */
/*
В три переменные a, b и c записаны три вещественных числа.
Создать программу, которая будет находить и выводить на
экран вещественные корни квадратного уравнения
ax²+bx+c=0, либо сообщать, что корней нет.
 */
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args){
        String Ups = "Ups! You have entered not numbers";
        Scanner n = new Scanner(System.in);
        System.out.print("Enter a: ");
        if (n.hasNextFloat()){
            float a = n.nextFloat();
            System.out.print("Enter b: ");
            if (n.hasNextFloat()){
                float b = n.nextFloat();
                System.out.print("Enter c: ");
                if (n.hasNextFloat()){
                    float c = n.nextFloat();
                    float d = b*b - 4*a*c;
                    if (a == 0){
                        double x0 = (-c / b);
                        System.out.println("x = " + x0);
                    }
                    else if ((d > 0) && (a != 0)){
                        double x1 = (-b + Math.sqrt(d)) / (2*a);
                        double x2 = (-b - Math.sqrt(d)) / (2*a);
                        System.out.println("x1 = " + x1);
                        System.out.println("x2 = " + x2);
                    }
                    else if ((d == 0) && (a != 0)){
                        double x = (-b) / (2*a);
                        System.out.println("x1 = x2 = " + x);
                    }else System.out.println("No real solution!");
                }else System.out.println(Ups);
            }else System.out.println(Ups);
        } else System.out.println(Ups);
    }
}

