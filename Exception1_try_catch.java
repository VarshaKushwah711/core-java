public class Exception1_try_catch
{
    public static void main(String[] args) {
        try{
            int mul = 10/0;//Arithmetic Exception
            //code that may raise exception 
            System.out.println("Rest of the code in try block...");//not excuted if excp. occurs
        }
        catch(ArithmeticException e)//used to handle the exception by declaring the type of exception within the paramter + can have multiple catch with a single try block
        {
            System.out.println(e);
        }
        System.out.println("Rest of the code...");
    }
}
