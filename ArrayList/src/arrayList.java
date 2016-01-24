import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by GaBi on 15.01.2016.
 */

public class arrayList {
    public static void main(String[] args){
    ArrayList catnamesList = new ArrayList();
    catnamesList.add("Васька");
    catnamesList.add("Мурзик");
    catnamesList.add("Рыжик");
        for (int i=0; i<catnamesList.size(); i++){
            System.out.println(catnamesList.get(i));
        }
    System.out.println(catnamesList.size());
    }
}
