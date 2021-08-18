package database;

import models.Student;
import models.Teacher;

import java.sql.*;

interface StudentTableOperations {
    void payFees(int amount);

    //Data types for below void methods are yet to be defined
    void askQuestion(String id,String description);
    void getQuestionResponse();
    void applyLeave();
    void getLeaveStatus();
    void getMaterials();
    void viewGrades();


    boolean createStudent(Student student);

    boolean checkStudentExists(String id); //before inserting check already exists
    boolean checkStudentLogin(String id,String password);
    boolean updateStudent(Student student);
    boolean deleteStudent(String id);

    Student viewProfile(String id);

}

public class StudentDBHelper implements StudentTableOperations {
    private static final String url = "jdbc:postgresql://localhost:5432/bootathon";
    private static final String driverName = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "Test@123";
    private static final String createTableQuery = "create table student(student_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),std varchar(20),email varchar(30) UNIQUE,gender varchar(50),dob varchar(15),phone varchar(10),fees int)";
    private Connection connection = null;

    public static void main(String[] args) throws SQLException {
//        System.out.println(new StudentDBHelper().viewProfile("19eucs001").getFees());
Student student = new Student("19eucs001","12345","Abiraj Rajendran","10","abi@gmail.com","Male","30-11-2001","9655047766",10000);
        System.out.println(new StudentDBHelper().updateStudent(student));
//        System.out.println(new StudentDBHelper().createStudent(student));
//        System.out.println(new StudentDBHelper().checkStudentExists("19eucs001"));
    }

    public Connection getConnection() {
        try {
            if(connection == null) {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Bootathon Database");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public void createTable() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        stmt.executeUpdate(createTableQuery);
        System.out.println("Student table created");
    }

    public boolean tableExists() {

        try {

            Connection con = getConnection();

            ResultSet tables = con.getMetaData().getTables(null, null, "student", null);
            if (tables.next()) {
                System.out.println("Student table exists");
                return true;
            } else {
                System.out.println("Student Table doesn't exist");
                createTable();

            }
            return true;
        } catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
        }

        return false;
    }

    @Override
    public void payFees(int amount) {

    }

    @Override
    public void askQuestion(String id, String description) {

    }



    @Override
    public void getQuestionResponse() {

    }

    @Override
    public void applyLeave() {

    }

    @Override
    public void getLeaveStatus() {

    }

    @Override
    public void getMaterials() {

    }

    @Override
    public void viewGrades() {

    }




    @Override
    public boolean createStudent(Student student) {
        tableExists();
        String insertQuery = String.format("insert into student values('%s','%s','%s','%s','%s','%s','%s','%s','%d')", student.getId(),student.getPassword(),student.getName(),student.getStd(),student.getEmail(),student.getGender(),student.getDob(),student.getPhone(),student.getFees());
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            stmt.executeUpdate();
            System.out.println("Student record inserted");

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkStudentExists(String id) {
        tableExists();
        try {
            String selectQuery = String.format("select * from student where student_id='%s'",id);
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkStudentLogin(String id, String password) {
        tableExists();
        try {
            String selectQuery = String.format("select * from student where student_id='%s' and password='%s'", id, password);
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        try{
            Connection conn = getConnection();
            String updateQuery = String.format("update student set password='%s',name='%s',std='%s',email='%s',gender='%s',dob='%s',phone='%s',fees='%d' where student_id='%s'",student.getPassword(),student.getName(),student.getStd(),student.getEmail(),student.getGender(),student.getDob(),student.getPhone(),student.getFees(),student.getId() );
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Exception occurred " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        tableExists();
        try {
            Connection conn = getConnection();
            String deleteQuery = String.format("delete from student where regno='%s'", id);
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return false;
    }

    @Override
    public Student viewProfile(String id) {
        Student student = null;
        tableExists();
        try {
            Connection con = getConnection();
            String selectUserQuery = String.format("select * from student where student_id='%s'", id);
            PreparedStatement stmt = con.prepareStatement(selectUserQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                student =new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
//                System.out.println(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
}
