/**
 * Created by GaBi on 19.02.2016.
 */
public class SurnameNameExceptions extends Exception{
    private String surName;
    private String symb = "Another exception";
    public String getSurName(){return surName;}
    public SurnameNameExceptions(String message, String surN){
        super(message);
        surName=surN;
    }
    public String getsymb(){
        String s = (surName.replaceAll("[a-zA-Z'\\- ]", ""));
        if(!s.equals("")){
            symb = "Excessive symbols: " + s;
        }
        return (symb);
    }
}
