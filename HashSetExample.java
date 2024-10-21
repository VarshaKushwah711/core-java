package Collection_pack;

import java.util.HashSet;

public class HashSetExample
{
    public static void main(String[] args) {
        
        HashSet<String> set1 = new HashSet<>();//set remove duplicate value
        set1.add("java");
        set1.add("C");
        set1.add("C++");
        set1.add("html");
        set1.add("html");
        set1.add("php");
        set1.add("C");
        set1.add("R");
        System.out.println(set1);
        //set1.forEach();
        for (String i : set1) {
            System.out.println(i);
        }

        set1.remove("C");
        System.out.println("After Remove C: " + set1);
        
        System.out.println("Is java is present in set: " + set1.contains("java"));

        System.out.println("this set contains no elements?:"+ set1.isEmpty());

        set1.clear();//Removes all of the elements from this set

    }
    
}
