public class LambdaExample3 
{
    interface A 
    {
        int getstrlength(String str);
    }
    public static void main(String[] args) {
        A get = str -> str.length();
        System.out.println("length:"+get.getstrlength("Varsha"));
    }
}
