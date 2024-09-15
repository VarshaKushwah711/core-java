interface Drawable //interface
{
    void draw();
}
class Rectangle implements Drawable//class 1
{
    public void draw()
    {
        System.out.println("Drawing rectangle..");
    }
}
class Circle implements Drawable//class 2 implements interfce
{
    public void draw()
    {
        System.out.println("Drawing circle..");
    }
}
public class Interface2 
{
    public static void main(String[] args) 
    {
        Drawable dobj = new Circle();//call circle method 
        dobj.draw();
        Drawable obj = new Rectangle();//call rectangle method
        obj.draw();
        Circle ob = new Circle();
        ob.draw();

    }
}
