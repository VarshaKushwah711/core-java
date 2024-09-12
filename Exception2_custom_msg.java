public class Exception2_custom_msg //we can displaying custom message on exception 
{
    public static void main(String[] args) {
         try{
            System.out.println(10/0);
         }
         catch(Exception e)
         {  //Displaying the custom message  
            System.out.println("Can't divide  by zero!!!!");
         }
    }

    
}
