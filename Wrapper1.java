//Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
public class Wrapper1 
{
    public static void main(String[] args) 
    {
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);

        System.out.println(myInt.intValue());
        
    }   
}
