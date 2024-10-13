package Exception_handling;

public class _2ArrayIndexOutOfBound1
 {
    public static void main(String[] args) {
        try{
            int arr[] = {10,20,30};
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);//Exception throw
            System.out.println("Rest of the code in try block");//not print
        }
        catch(Exception e)
        {
            //System.out.println(e);
            e.printStackTrace();//Give discription and line of exception
        }
        System.out.println("Rest of code after try and catch");//print

    }
}

