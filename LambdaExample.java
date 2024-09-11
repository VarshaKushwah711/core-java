public class LambdaExample {

    //@FunctionalInterface
    interface square
    {
        int calculate(int x);
    }
    public int calculate(int x, int y)
    {
        return x*x*y;
    }
    public static void main(String[] args) {
        //square sq = (int x) -> x*x; //we can write this
        int y = 10;//local var
        square sq = x -> x*x;//lambda exp.
        System.out.println(sq.calculate(y));
        System.out.println(new LambdaExample().calculate(5, 2));
    }
}
/*Lambda Expression-
Anonymous function
-	Not having name
-	Not having return type
-	Not having modifier
-	 -> needs to be added
Cleaning rules-
.	 If body have just one statement then we can remove {}
.	 Use type inference, compiler guess the situation and context
.    No return keyword
.	 If only one parameter remove small brackets

Benefits-
1.To enable functional programming
2.To make code more readable,maintainable and concise code
3. To enable parallel processing
4.Reduce jar file size
5. Eliminate unnecessary variables

 */