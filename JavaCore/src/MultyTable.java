/**
 * Created by GaBi on 25.12.2015.
 */
/*
Для проверки остаточных знаний учеников после летних каникул, учитель младших
классов решил начинать каждый урок с того, чтобы задавать каждому ученику пример
из таблицы умножения, но в классе 15 человек, а примеры среди них не должны
повторяться. В помощь учителю напишите программу, которая будет выводить на
экран 15 случайных примеров из таблицы умножения (от 2*2 до 9*9, потому что
задания по умножению на 1 и на 10 — слишком просты). При этом среди 15 примеров
не должно быть повторяющихся (примеры 2*3 и 3*2 и им подобные пары считать
повторяющимися).
*/
import java.util.ArrayList;

public class MultyTable {
    public static void buildTable() {
        /*
        Print a multiplication table from 1 to 10
         */
        int[ ][ ] da = new int[10][10];
        for(int i=0; i<da.length; i++) {
            for(int j=0; j<da[i].length; j++) {
                da[i][j] = ((i+1)*(j+1));
            }
        }
        System.out.println("Check your result with a multiplication table: ");
        for(int i=0; i<da.length; i++) {
            for(int j=0; j<da[i].length; j++) {
                System.out.print(da[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void choosingExamples() {
        /*
        Choose 15 examples from the multiplication table from 2 to 9 without repeat
         */
        int index = 0;
        ArrayList<String> ch = new ArrayList<>();
        for (int i=2; i<=9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                ch.add(i + " * " + j + " = ?");
            }
        }
        System.out.println("Examples: ");
        while (index < 15){
            int num = (int)(Math.random() * ch.toArray().length);
            System.out.println(ch.remove(num));
            index++;
        }
    }
    public static void main(String[] args) {
        choosingExamples();
        buildTable();
    }
}
