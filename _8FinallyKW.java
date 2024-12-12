package Exception_handling;

public class _8FinallyKW {
    public static void main(String[] args) {
        try{
            int arr[] = {1,2,3};
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Finally block always excute either exception occuer or not.");
        } 
    }
}
//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
