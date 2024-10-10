package Src;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root"; 
    private static final String PASSWORD = "12345"; 

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
             
            // Create the users table
            createUsersTable(connection);
            
            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Create User");
                System.out.println("2. Read Users");
                System.out.println("3. Update User");
                System.out.println("4. Delete User");
                System.out.println("5. Exit");
                int choice = getValidInteger(scanner);

                switch (choice) {
                    case 1:
                        // Create User
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        createUser(connection, name, email);
                        break;

                    case 2:
                        // Read Users
                        readUsers(connection);
                        break;

                    case 3:
                        // Update User
                        System.out.print("Enter user ID to update: ");
                        int idToUpdate = getValidInteger(scanner);
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        updateUser(connection, idToUpdate, newName, newEmail);
                        break;

                    case 4:
                        // Delete User
                        System.out.print("Enter user ID to delete: ");
                        int idToDelete = getValidInteger(scanner);
                        deleteUser(connection, idToDelete);
                        break;

                    case 5:
                        // Exit
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createUsersTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "name VARCHAR(100)," +
                     "email VARCHAR(100))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Users table created or already exists.");
        }
    }

    private static void createUser(Connection connection, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        }
    }

    private static void readUsers(Connection connection) throws SQLException {
        String sql = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Users:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        }
    }

    private static void updateUser(Connection connection, int id, String name, String email) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
        }
    }

    private static void deleteUser(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
        }
    }

    private static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number:");
            }
        }
    }
}
