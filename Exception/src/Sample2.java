/**
 * Created by GaBi on 15.01.2016.
 */
public class Sample2 {
    public static void main(String[] args){
        Sample1 obj = new Sample1();
        try {
            String a="f d s";
            String[] r=a.split(" ");
            System.out.println(r.length);
            obj.myMethod();
        } catch (ArithmeticException ex1) {
            System.out.println("This is ArithmeticException");
        } catch (NullPointerException ex2) {
            System.out.println("This is NullPointerException");
        } catch (ArrayIndexOutOfBoundsException ex3) {
            System.out.println("This is ArrayIndexOutOfBoundsException");
        } catch (Exception ex4) {
            System.out.println("This is Exception");
        }
        byte b[]=new byte[80];
        for (int i=0; i<b.length; i++)
            b[i]=(byte)System.in.read();
        Integer i=5000;
        System.out.println(i.hashCode());
    }

}
