/**
 * Created by GaBi on 15.01.2016.
 */
class First {
    public static void main(String args[]){
        int a=5;
        try{
//            int a=5;
            int b=30/0;
            System.out.println("First error");
        }
        catch (ArithmeticException e){
            System.out.println("Second error");
        }
        try{
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println("Second error");
        }
    }
}
