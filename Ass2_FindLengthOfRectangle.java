package Assigment_45;
import java.util.Scanner;
//2. The area of a rectangle is 96 cm². If the breadth of the rectangle is 8 cm, find its length and perimeter. 

public class Ass2_FindLengthOfRectangle {

    public static void main(String[] args) {
    

        Scanner sc = new Scanner(System.in);
        
        try{

            System.out.print("Enter the area of rectangle (cm²): ");
            int area = sc.nextInt();

            System.out.print("Enter the breadth of rectangle (cm): ");
            int b = sc.nextInt();

            if(b<=0)
            {
                System.out.println("Breadth can't be zero or negative");
            }

            int length = area/b;
            System.out.println("Length of the rectangle: " + length + " cm");
        }
        catch(Exception e)
        {
            System.out.println();
        }
        finally
        {
            sc.close();
        }

    }
    
}
