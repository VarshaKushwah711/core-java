package Exception_handling;
import java.util.Scanner;
class ManyException {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the value of n : ");
        int n = obj.nextInt();
        obj.close();
        try{
            System.out.println(10/n);
            String name = null;
            System.out.println(name.length());
        }
        catch(NullPointerException e)
        {
            System.out.println(e);
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
