public class LambdaExample2 {
    interface A
    {
        int add(int a, int b);
    }
    public static void main(String[] args) {
        
        /* 
        Private void add(int a,int b)
        {
            SOP(a+b);
        }*/
        A addition = (a,b) -> (a+b);
        System.out.println(addition.add(5,7));

    }
    
}
