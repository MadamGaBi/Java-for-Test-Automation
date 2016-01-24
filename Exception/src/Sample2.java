/**
 * Created by GaBi on 15.01.2016.
 */
public class Sample2 {
    public static void main(String[] args){
        Sample1 obj = new Sample1();
        try {
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
    }
}