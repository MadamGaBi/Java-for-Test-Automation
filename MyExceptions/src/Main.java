/**
 * Created by GaBi on 19.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(EnterName.getName("Bila Galyna Bila Galyna Bila Galyna Bila Galyna Bila Galyna Bila Galyna Bila Galyna Bila Galyna Bila GalynaGalyna Bila Galyna Bila Galyna Bila Galyna Bila Galyna Bila Galyna"));
        } catch (SurnameNameExceptions ex) {
            System.out.println(ex.getsymb());
            System.out.println(ex.getMessage());
            System.out.println("----------------------------------------------");
        }
        try {
            System.out.println(EnterName.getName(""));
        } catch (SurnameNameExceptions ex) {
            System.out.println(ex.getsymb());
            System.out.println(ex.getMessage());
            System.out.println("----------------------------------------------");

        }
        try {
            System.out.println(EnterName.getName("A"));
        } catch (SurnameNameExceptions ex) {
            System.out.println(ex.getsymb());
            System.out.println(ex.getMessage());
            System.out.println("----------------------------------------------");

        }
        try {
            System.out.println(EnterName.getName("Djj2-39n n$%mg"));
        } catch (SurnameNameExceptions ex) {
            System.out.println(ex.getsymb());
            System.out.println(ex.getMessage());
            System.out.println("----------------------------------------------");

        }
    }
}
