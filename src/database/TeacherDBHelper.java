package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDBHelper {
    private static final String url = "jdbc:postgresql://localhost:5432/bootathon";
    private static final String driverName = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "Test@123";
    private static final String createTableQuery = "create table teacher_details(teacher_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),email varchar(30) UNIQUE,experience int,phone varchar(10),salary int)";
    private static Connection connection;
    public static Connection getConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Test Database");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
    public static void createTable() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        stmt.executeUpdate(createTableQuery);
        System.out.println("Table Teacher created");
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        createTable();
    }
}
