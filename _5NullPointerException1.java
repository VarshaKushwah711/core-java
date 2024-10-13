package Exception_handling;
class NullPointerException1 {
    public static void main(String[] args) {
        try{
            String name = null;
            System.out.println(name);
            System.out.println(name.length());//throw exception 
            System.out.println("Rest of the code in try block");//Not print
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
/*java.lang.NullPointerException: Cannot invoke "String.length()" because "name" is null
        at Exception_handling.NullPointerException.main(NullPointerException.java:8) */
