package Exception_handling;
class ArithmeticException1
{   
    public static void main(String[] args) {
    System.out.println("hello infoBeans Foundation..");
    System.out.println("we learn exception handling in java");
    System.out.println("Exception is an unwanted event occuer in excucation in program that affect the flow of program.");
    try{
        System.out.println("Try block..");
        System.out.println(10/0);
        System.out.println("Rest of code in try block");
    }
    catch(Exception e)
    {
        //System.out.println(e);
        //System.out.println(e.getStackTrace());//[Ljava.lang.StackTraceElement;@4517d9a3
        e.printStackTrace();
        System.out.println(e.getMessage());// ----/ by zero
    }
    System.out.println("In java have try and catch block to handle exception in programs");  
}
}
