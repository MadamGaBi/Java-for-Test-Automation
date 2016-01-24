/**
 * Created by GaBi on 15.01.2016.
 */
class Finally {
    public static void main(String args[]){
        try{
            int a[]=new int[4];
            a[1]=2;
//            a[5]=3;
            System.out.println("This is try block");
            System.exit(0);
        }
        catch (ArithmeticException e){
            System.out.println("This is catch1 block");
        }
        catch (Exception e){
            System.out.println("This is catch2 block");
        }
        finally {
            System.out.println("This is finally block");
        }
    }
}
