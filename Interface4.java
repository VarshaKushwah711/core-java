//Interface inheritance
interface printable
{
    void print();
}
interface showable extends printable
{
    void show();
}
class I4 implements showable
{
    public void print() 
    {
        System.out.println("printable interface and print method..");
    }
    public void show()
    {
        System.out.println("showable interface and show method..");
    }
}
public class Interface4 
{
    public static void main(String[] args) 
    {
        I4 obj = new I4();
        obj.print();
        obj.show();
        
    }
    
}
