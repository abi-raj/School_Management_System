package database;

import models.Teacher;

import java.sql.*;
import java.util.ArrayList;

interface TeacherTableOperations{

    void createTable();
    boolean teacher_tableExists();
    boolean checkTeacherLogin(String id,String password);

    boolean createTeacher(Teacher user);
    Teacher viewTeacher(String id);
    boolean updateTeacher(Teacher user);
    boolean deleteTeacher(String id,String password);


    //Data types for below void methods are yet to be defined
    void replyQuestion();
    void markAttendance();
    void editStudent();
    void postMaterials();
    void addGrades();
    void approveLeave();
   // boolean teacherExist(String id);

}
public class TeacherDBHelper implements TeacherTableOperations{
    private static final String url = "jdbc:postgresql://localhost:5432/teacher";
    private static final String driverName = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "12345";
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
    @Override
    public  void createTable(){
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(createTableQuery);
            System.out.println("Table Teacher created");
            conn.close();
        }catch(Exception e){
            System.out.println("Exception Occured: "+e);
        }
    }
    @Override
    public boolean teacher_tableExists() {

        try {

            Connection con = getConnection();

            ResultSet tables = con.getMetaData().getTables(null, null, "teacher_details", null);
            if (tables.next()) {
                System.out.println("Teacher table exists");
                con.close();
                return true;
            } else {
                System.out.println("Teacher Table doesn't exist");
                createTable();

            }
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
        }

        return false;
    }
//    @Override
//    public  boolean teacherExist(String id){
//        teacher_tableExists();
//        ResultSet Allusers=null;
//        ArrayList<String> users=null;
//        String checkQuery=String.format("select teacher_id from teacher_details");
//        try{
//            Connection con=getConnection();
//            PreparedStatement stmt = con.prepareStatement(checkQuery);
//            Allusers = stmt.executeQuery();
//             users=new ArrayList<>();
//            int i=1;
//            while(Allusers.next()){
//                users.add(Allusers.getString(i));
//                i++;
//            }
//
//
//        }catch(Exception e){
//            System.out.println("Exception"+e);
//        }
//        return users.contains(id);
//    }
    @Override
    public boolean createTeacher(Teacher user){
        teacher_tableExists();
        String insertQuery = String.format("insert into teacher_details values('%s','%s','%s','%s',%d,'%s',%d)", user.getTeacher_id(),user.getPassword(), user.getName(), user.getEmail(), user.getExperience(), user.getPhone(), user.getSalary());

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            stmt.executeUpdate();
            System.out.println("user record inserted");
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occured:"+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkTeacherLogin(String id, String password) {
        teacher_tableExists();
        try {
            String selectQuery = String.format("select * from teacher_details where teacher_id='%s' and password='%s'", id, password);
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            conn.close();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }

        return false;
    }

    public Teacher viewTeacher(String id){
        Teacher user = null;
        teacher_tableExists();
        try {
            Connection con = getConnection();
            String selectUserQuery = String.format("select * from teacher_details where teacher_id='%s'", id);
            PreparedStatement stmt = con.prepareStatement(selectUserQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
//                System.out.println(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean updateTeacher(Teacher user){
        teacher_tableExists();
        try {
            Connection conn = getConnection();
            String updateQuery =String.format( "update teacher_details set password='%s',name='%s',email='%s',experience=%d,phone='%s',salary=%d where teacher_id='%s'",user.getPassword(),user.getName(),user.getEmail(),user.getExperience(),user.getPhone(),user.getSalary(),user.getTeacher_id());
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.executeUpdate();
            conn.close();
            System.out.println("Updated");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Updation Failed");
        return false;
    }

    @Override
    public boolean deleteTeacher(String id,String password){
        teacher_tableExists();
        try {
            Connection conn = getConnection();
            String deleteQuery = String.format("delete from teacher_details where teacher_id='%s' and password='%s'", id, password);
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.executeQuery();
            conn.close();
            System.out.println("Record Deleted");
            return true;
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return false;
    }

    @Override
    public void replyQuestion() {

    }

    @Override
    public void markAttendance() {

    }

    @Override
    public void editStudent() {

    }

    @Override
    public void postMaterials() {

    }

    @Override
    public void addGrades() {

    }

    @Override
    public void approveLeave() {

    }

    public static void main(String[] args) throws Exception {
       // createTable();
        Teacher t=new Teacher("19eucs005","123","ajai","abc@gmail",3,"96325648",24000);
       //new TeacherDBHelper().createTeacher(t);
//        Teacher u=new TeacherDBHelper().viewTeacher("19eucs005");
//        System.out.println(u.getName());
        //Teacher t=new Teacher("19eucs005","1234","pradeep","abc@gmail",3,"96325648",24000);
        //new TeacherDBHelper().deleteTeacher("19eucs005","123");

    }
}
