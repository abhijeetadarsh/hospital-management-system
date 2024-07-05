package online.abhijeetadarsh.hospital.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/hospital_db";
    private String username = "abhijeetadarsh";
    private String password = "1234";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected Successfully.");
            initializeDatabase("database/init_db.sql");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
            throw new SQLException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private void initializeDatabase(String sqlFilePath) throws SQLException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
             Statement statement = connection.createStatement()) {
            StringBuilder sqlQuery = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlQuery.append(line);
                if (line.trim().endsWith(";")) {
                    statement.execute(sqlQuery.toString());
                    sqlQuery.setLength(0);  // Clear the StringBuilder for the next query
                }
            }
            System.out.println("Database Initialized Successfully.");
        } catch (IOException e) {
            System.out.println("Error reading SQL file: " + e.getMessage());
            throw e;
        } catch (SQLException e) {
            System.out.println("Error executing SQL script: " + e.getMessage());
            throw e;
        }
    }
}
