/**
 * Created by GaBi on 20.11.2015.
 */
import java.util.Scanner; // импортируем класс

public class Calculator {
    public static int sum(int a, int b){
        int result = a + b;
        return result;
    }
    public static int sub(int a, int b){
        int result = a - b;
        return result;
    }
    public static int div(int a, int b){
        int result = a / b;
        return result;
    }
    public static int mult(int a, int b){
        int result = a * b;
        return result;
    }
    public static void main(String[] args) {
        String choice;
        int theFirstNumber;
        int theSecondNumber;
        boolean finished = false;

        while (!finished){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            theFirstNumber = sc.nextInt();
            System.out.print("Выберите одно из действий: + сумма, - вычитание, / деление, * умножение: ");
            choice = sc.next();
            if (choice.equals("+") || choice.equals("-") || choice.equals("/") || choice.equals("*")) {
                System.out.print("Введите второе целое число: ");
                if (sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                    theSecondNumber = sc.nextInt();
                    if (theSecondNumber == 0 && choice.equals("/")) {
                        System.out.print("Деление на ноль невозможно");
                        finished = true;
                    } else {
                        switch (choice) {
                            case "+":
                                System.out.print(sum(theFirstNumber, theSecondNumber));
                                break;
                            case "-":
                                System.out.print(sub(theFirstNumber, theSecondNumber));
                                break;
                            case "/":
                                System.out.print(div(theFirstNumber, theSecondNumber));
                                break;
                            case "*":
                                System.out.print(mult(theFirstNumber, theSecondNumber));
                                break;
                            default:
                                System.out.print("Плохо с математикой?");
                                break;
                        }
                        finished = true;
                    }
                } else {
                    System.out.print("Ну разве это целое число? Попробуй с начала! \n");
                }
            }
            else {System.out.print("В математике нет такой операции! Давай с начала, но внимательно! \n");}
        }
        else {System.out.print("Ну разве это целое число? Попробуй ещё разок! \n");}
        }
    }
}
