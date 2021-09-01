package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//To Create all the tables required
public class DummyClass {
    private static final String url = "jdbc:postgresql://localhost:5432/teacher";
    private static final String driverName = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "12345";
    // private static final String createTableQuery = "create table student(student_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),std varchar(20),email varchar(30) UNIQUE,gender varchar(50),dob varchar(15),phone varchar(10),fees int)";
    private Connection connection = null;

    public static void main(String[] args) throws SQLException {
    String[] allQueries = {
            CreateQueries.createAdmin,
            CreateQueries.createTeacher,
            CreateQueries.createStudent,
            CreateQueries.createForum,
            CreateQueries.createAttendance,
            CreateQueries.createLeave,
            CreateQueries.createMarks,
            CreateQueries.createMaterials,
            CreateQueries.createExam,
    };
    DummyClass dummy = new DummyClass();
    for(String str:allQueries){
        dummy.createTable(str);
    }
    }
    public Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to Bootathon Database");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
    public void createTable(String query) throws SQLException {
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(query);
            System.out.println("table created");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
