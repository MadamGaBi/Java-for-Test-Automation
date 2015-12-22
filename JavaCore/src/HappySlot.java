/**
 * Created by GaBi on 11.12.2015.
 */
import java.util.Scanner;

public class HappySlot {
    public static void main(String[] args){
        String[] slot = {"lemon", "lemon", "lemon", "lemon", "lemon", "lemon", "lemon",
//                "cherry", "cherry", "cherry", "cherry", "cherry", "cherry",
//                "pear", "pear", "pear", "pear", "pear",
//                "peach", "peach", "peach", "peach",
//                "777", "777",
                "BAR"};
        int cash = 0;
        boolean ending = false;
        while (!ending) {
            int cost = (int)(Math.random() * 100 + 1);
            System.out.println("The cost of the game: $" + cost);
            Scanner cashScan = new Scanner(System.in);
            System.out.print("Insert cash: $");
            if (cashScan.hasNextInt()) {
                cash = cashScan.nextInt();
            if (cash >= cost) {
                int slot1 = (int) (Math.random() * slot.length);
                int slot2 = (int) (Math.random() * slot.length);
                int slot3 = (int) (Math.random() * slot.length);
                System.out.println("Your luck is: ");
                System.out.println(slot[slot1] + "  " + slot[slot2] + "  " + slot[slot3]);
                if (slot[slot1].equals(slot[slot2]) && slot[slot2].equals(slot[slot3])){
//                    flag = true;
                    cash  = (cash - cost) + 2 * cost;
                    System.out.println("Congratulations! Your win is $" + cash);
                } else
                    System.out.println("Unfortunately, You have lost!");
            } else
                System.out.println("You have too little money! The game costs more! Take it back: $" + cash);
            } else {
                System.out.println("Invalid data!");
            }
            System.out.println("Let's play again? Y/N");
            Scanner game = new Scanner(System.in);
            String choice = game.next();
            if (choice.equals("N")) {
                ending = true;
            }
        }
    }
}
