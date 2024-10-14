package Exception_handling;
class ManyException2 {
    public static void main(String[] args) {
        try{
            int arr[] = new int[3];
            arr[0]=10;
            arr[1]=20;
            arr[2]=30/0;//ArithmeticException
            arr[3]=30;//ArrayIndexOutOfBoundsException 
            String name = null;
            System.out.println(name.length());//NullPointerException
          
        }
        catch(NullPointerException e)
        {
            System.out.println("NullPointerException occuer..");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occuer..");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBoundsException occuer..");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occuer..");
        }
    }   
}
//Child class ko pahle likhna hai + Excute pahle hoga
//only one catch block excute hoga + jo exception compiler ko pahle milega
