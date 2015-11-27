/**
 * Created by GaBi on 20.11.2015.
 */
/*
    Number Guessing Game. A summary:
    In method main():
        - Randomly select one of those colors in the array as the target
        - Optionally: display the target (to help with debugging);
        - Go into a loop which
            - Shows the range of numbers and asks the player for their guess 'I am thinking of a number in the range 1 to 100. What is the number?'
            - Displays a message such as 'You have not entered an integer number. Please enter an integer number in the range 1 to 100.’ If the text entered by the player is not an integer number, OR:
            - Using the method check_guess():
                - Displays a message such as ‘Your number is too large!’ if that is true, OR:
                - Displays a message such as ‘Your number is too small!’ if that is true, OR:
                - If the player’s input is the same as the target, displays a message which includes the total number of guesses such as ‘You got it! The number was 56. It took you 5 guesses to get the number!’
            - Stops if the player’s input is the same as the target
*/

import java.util.Scanner;
import java.util.Random;

public class Guess {
    public static boolean check_guess(int guess_input, int target, int guesses){
        if ((guess_input < 1) || (guess_input > 100)) {
            System.out.print("Please enter an integer number in the range 1 to 100.");
            return false;
        }
        if (guess_input > target) {
            System.out.print("Your number is too large!");
            return false;
        }
        if (guess_input < target) {
            System.out.print("Your number is too small!");
            return false;
        }
        if (guess_input == target) {
            System.out.print("You got it! The number was " + target + ".\nIt took you " + guesses +
                    " guesses to get the number!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int target;
        int guess_input_number;
        boolean finished = false;
        int guesses = 0;
        Random randomSet = new Random();
        target = randomSet.nextInt(101);
        System.out.println(target); // to help with debugging :)
        System.out.print("I am thinking of a number in the range 1 to 100. What is the number?");
        while (!finished) {
            Scanner sc = new Scanner(System.in);
            guesses += 1;
            if (sc.hasNextInt()) {
                guess_input_number = sc.nextInt();
                finished = check_guess(guess_input_number, target, guesses);
            }
            else {
                System.out.print("You have not entered an integer number. Please enter an integer number in the range 1 to 100.");
            }
        }
    }
}

