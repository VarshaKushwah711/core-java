package Assigment_45;
//1. The perimeter of a rectangle is 230 cm. If the length of the rectangle is 70 cm, find its breadth and area.
public class Ass1_FindBreadthOfRectangle {
    
    public static int findBreadth(int p, int l)
    {
        return p/2-l;
    }
    public static int findArea(int l, int b)
    {
        return l*b;
    }
    public static void main(String[] args) {
        
        int perimeter = 230;     //in cm
        int length = 70;        //in cm
        
        int breadth = findBreadth(perimeter, length);
        System.out.println("Breadth of rectangle: " + breadth + " cm");
        
        int area = findArea(length, breadth);
        System.out.println("Area of rectangle: " + area + " cm²");
        
    }
}
