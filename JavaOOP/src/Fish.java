/**
 * Created by GaBi on 18.12.2015.
 */

public class Fish extends Pet {
    int currentDepth;
    Fish(int currentDepth){
        this.currentDepth = currentDepth;
    }
    public int dive(int howDeep){
        currentDepth=currentDepth + howDeep;
        System.out.println("Ныряю на глубину "
                + howDeep + " футов");
        System.out.println("Я на глубине "
                + currentDepth + " футов ниже уровня моря");
        return currentDepth;
    }
}

