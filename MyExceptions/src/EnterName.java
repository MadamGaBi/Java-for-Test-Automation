/**
 * Created by GaBi on 19.02.2016.
 */

public class EnterName {
    public static String getName(String surName) throws SurnameNameExceptions {
        if (surName.length() > 40) throw  new SurnameNameExceptions("Exception: Out of range", surName);
        if (surName.equals("")) throw  new SurnameNameExceptions("Exception: Is empty", surName);
        if (surName.length() == 1) throw  new SurnameNameExceptions("Exception: Can't be 1 symbol", surName);
        if (!surName.matches("^[a-zA-Z'\\- ]+$")) throw  new SurnameNameExceptions("Exception: Incorrect symbol", surName);
    return surName;
    }
}
