package Src;
import java.sql.*;
public class JDBC_Select
{
    public static void main(String[] args) 
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","12345");
            Statement st;
            st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select * from student");
            int sno;
            String sname;
            while(rs.next())
            {
                sno = rs.getInt("sno");
                sname = rs.getString("sname").trim();
                System.out.println("sno : "+sno+" name : "+sname);
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
