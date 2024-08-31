package Src;
import java.sql.*;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:MySQL://localhost:3306/school";
        String user = "root";
        String password = "12345";
        try{
            //1. Create a connection
            Connection con  = DriverManager.getConnection(url,user,password);

            //2. Create a statement
            Statement st = con.createStatement();

            //3. Execute Query
            String sql = "insert into student"+"(sno, sname, address, contactNo, fees, courseName, department, HOD) "+ "values(114,'shreya','ujjain','9875645865',15000,'BCOM','commerce','rahul sen')";

            st.executeUpdate(sql);

            System.out.println("Insert complete");

            //4. Close connection
			con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
    
}
