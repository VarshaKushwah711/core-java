
public class LambdaMathExample 
{
    interface MathOperation 
    {
    int Operate(int a, int b);
    }
    //Overloading method with three parameter
    private static int Operate(int a, int b, MathOperation operation)//refrence variable not object )
    {
        return operation.Operate(a, b);   
    }
    
    public static void main(String[] args) {

        //Lambda expression for addition
        MathOperation add = (a,b)->a+b;

        //Lambda expression for subtraction
        MathOperation subtract = (a,b)->a-b;

        //Perform addition
        System.out.println("5+3=" + Operate(5,3,add));

        //perform subtraction
        System.out.println("5-3=" + Operate(5,3,subtract));
    } 
}


