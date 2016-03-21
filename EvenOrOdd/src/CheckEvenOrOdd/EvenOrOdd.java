package CheckEvenOrOdd;

/**
 * Created by GaBi on 27.01.2016.
 */
public class EvenOrOdd {
    public boolean checkNumber(String stringNumber) throws IllegalArgumentException {
        /*
        Enter integer number and check if it is even or odd
         */
        boolean result;
        int intNumber = Integer.valueOf(stringNumber);
        result = (intNumber % 2 == 0);
        return result;
    }
}


