package Src;

/*
CREATE DATABASE test_db;
USE test_db;
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);
*/

//code for full CRUD operation using JDBC 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DriverManager;


class JDBCUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/test_db?useSSL=false";
    private static final String USER = "root";
    private static final String PS = "12345";

    public static Connection getConnection() throws SQLException 
    {
        return DriverManager.getConnection(URL,USER,PS);
    }
    public static void printSQLException(SQLException ex)
    {
        for(Throwable e : ex)
        {
            if(e instanceof SQLException)
            {
                e.printStackTrace(System.err);
                System.err.println("SQLState:"+((SQLException)e).getSQLState());
                System.err.println("Error code: "+ ((SQLException)e).getErrorCode());
                System.out.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while(t!=null)
                {
                    System.out.println("Cause: "+t);
                    t = t.getCause();
                }
            }
        }
    }    
}

class Implementation
{
    private static final Scanner sc = new Scanner(System.in);
    
    public void SelectEmployee()
    {
        String sql = "select id, name, email, country, salary from employees where id=?";
        try(Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            //Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee Id: ");
            int EmpId = sc.nextInt();
            ps.setInt(1,EmpId);
            //pstmt.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Country: " + rs.getString("country"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }
            else
            {
                System.out.println("No employee found with ID: " + EmpId);
            }
        }
        catch(SQLException e)
        {
            JDBCUtils.printSQLException(e);
        }
    }

    public void insertEmployee()
    {
        String sql = "insert into employees (name, email, country, salary) values (?,?,?,?)";
        try(Connection conn = JDBCUtils.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            //Scanner sc = new Scanner(System.in);
            System.out.print("Enter employee name: ");
            pstmt.setString(1,sc.nextLine());
            sc.nextLine();
            System.out.print("Enter employee email: ");
            pstmt.setString(2, sc.nextLine());
            System.out.print("Enter employee country: ");
            pstmt.setString(3,sc.nextLine());
            //sc.nextLine();
            System.out.print("Enter employee salary: ");
            pstmt.setInt(4,sc.nextInt());
            //sc.nextLine();

            pstmt.executeUpdate();

            System.out.println("Recrod created");
        }
        catch(SQLException e)
        {
            JDBCUtils.printSQLException(e);
        }
    }
    
    public void updateEmployee()
    {
        String sql = "update employees SET name = ?, email = ?, country = ?, salary = ? Where id = ?";
        try(Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps =  conn.prepareStatement(sql)){
            
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Enter employee ID to update: ");
            //Scanner sc = new Scanner(System.in);
            int EmpId = sc2.nextInt();
            sc2.nextLine();
            System.out.print("Enter new employee name: ");
            ps.setString(1, sc2.nextLine());
            System.out.print("Enter new employee email: ");
            ps.setString(2, sc2.next());
            sc2.nextLine();
            System.out.print("Enter new employee country: ");
            ps.setString(3, sc2.nextLine());
            sc.nextLine();
            //System.out.println();
            System.out.print("Enter new employee salary: ");
            ps.setInt(4, sc2.nextInt());
            //sc2.next();
            ps.setInt(5, EmpId);
            ps.executeUpdate();
            System.out.println("Record updated");
            
        }
        catch(SQLException e)
        {
            JDBCUtils.printSQLException(e);
        }
    }
    public void deleteEmployee()
    {
        String sql = "DELETE FROM employees WHERE id = ?";
        try(Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            System.out.print("Enter employee ID to delete: ");            
            //Scanner sc = new Scanner(System.in);
            int EmpId = sc.nextInt();
            ps.setInt(1,EmpId);
            //ps.setInt(1,1);
            ps.executeUpdate();
            System.out.println("Record deleted");
            
        }
        catch(SQLException e)
        {
            JDBCUtils.printSQLException(e);
        }

    }
    public static void main(String[] args) {
        int choice;
        Implementation obj = new Implementation();

        System.out.println("Welcome to CodingWorld limited \nPlease Enter your Choice: ");

        boolean repeat = true;

        while(repeat)
        {
            System.out.println("1. Add New Employee \n2. View Employee \n3. Update Existing employee \n4. Delete Exisitng Employee \n5. Exit");
            //Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    obj.insertEmployee();
                    break;
                case 2:
                    obj.SelectEmployee();
                    break;
                case 3:
                    obj.updateEmployee();
                    break;
		        case 4: 
                    obj.deleteEmployee();
                    break;
	 	        case 5: 
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
        
            }
            System.out.println("Do you want to perform other opration? (yes/no): ");
            String response = sc.next();
            if(response.equalsIgnoreCase("No"))
            {
                repeat = false;
                System.out.println("Thank You...");
            }

        }
    }
}
