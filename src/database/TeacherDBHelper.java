package database;

import models.*;

import java.sql.*;
import java.util.*;

public class TeacherDBHelper {
    public static void createTable() {
        try {
            Connection conn = Connector.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(CreateQueries.createTeacher);
            System.out.println("Table Teacher created");
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception Occured: " + e);
        }
    }

    public static boolean teacher_tableExists() {

        try {

            Connection con = Connector.getConnection();

            ResultSet tables = con.getMetaData().getTables(null, null, TeacherTable.tableName, null);
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

    //
    // public static boolean teacherExist(String id){
    // teacher_tableExists();
    // ResultSet Allusers=null;
    // ArrayList<String> users=null;
    // String checkQuery=String.format("select teacher_id from teacher_details");
    // try{
    // Connection con=Connector.getConnection();
    // PreparedStatement stmt = con.prepareStatement(checkQuery);
    // Allusers = stmt.executeQuery();
    // users=new ArrayList<>();
    // int i=1;
    // while(Allusers.next()){
    // users.add(Allusers.getString(i));
    // i++;
    // }
    //
    //
    // }catch(Exception e){
    // System.out.println("Exception"+e);
    // }
    // return users.contains(id);
    // }

    public static boolean createTeacher(Teacher user) {
        teacher_tableExists();
        String insertQuery = String.format(TeacherTable.createTeacher, user.getTeacher_id(), user.getPassword(),
                user.getName(), user.gettClass(), user.getEmail(), user.getExperience(), user.getPhone(),
                user.getSalary());

        try {
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            stmt.executeUpdate();
            System.out.println("user record inserted");
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occured:" + e.getMessage());
        }
        return false;
    }

    public static boolean checkTeacherLogin(String id, String password) {
        teacher_tableExists();
        try {
            String selectQuery = String.format(TeacherTable.teacherLogin, id, password);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            conn.close();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }

        return false;
    }

    public static Teacher viewTeacher(String id) {
        Teacher user = null;
        teacher_tableExists();
        try {
            Connection con = Connector.getConnection();
            String selectUserQuery = String.format(TeacherTable.viewTeacher, id);
            PreparedStatement stmt = con.prepareStatement(selectUserQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8));
                // System.out.println(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static boolean updateTeacher(Teacher user) {
        teacher_tableExists();
        try {
            Connection conn = Connector.getConnection();
            String updateQuery = String.format(TeacherTable.updateTeacher, user.getPassword(), user.getName(),
                    user.gettClass(), user.getEmail(), user.getExperience(), user.getPhone(), user.getSalary(),
                    user.getTeacher_id());
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

    public static boolean deleteTeacher(String id) {
        teacher_tableExists();
        try {
            Connection conn = Connector.getConnection();
            String deleteQuery = String.format(TeacherTable.deleteTeacher, id);
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

    public static void replyQuestion(Forum query) {
        Connection con = Connector.getConnection();
        try {
            String updatequery = String.format(ForumTable.updateResponse, query.getResponse(), query.getDescription(),
                    "No response yet");
            PreparedStatement stmt = con.prepareStatement(updatequery);
            stmt.executeUpdate();
            System.out.println("Replied");

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }

    public static void markAttendance(String id, String date, String status) {
        teacher_tableExists();
        Connection con = Connector.getConnection();
        if (StudentDBHelper.checkStudentExists(id)) {
            String stdQuery = String.format("select std from student where student_id='%s'", id);
            String std = null;
            try {
                PreparedStatement stmt = con.prepareStatement(stdQuery);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    std = rs.getString(1);
                }
                System.out.println(rs.getString(1));
            } catch (Exception e) {
                System.out.println("Exception:" + e);
            }
            String attendanceQuery = String.format("insert into attendance values('%s','%s','%s','%s')", id, std, date,
                    status);
            try {
                PreparedStatement stmt = con.prepareStatement(attendanceQuery);
                stmt.executeUpdate();
                con.close();
            } catch (Exception e) {
                System.out.println("Exception occured:" + e.getMessage());
            }
        } else {
            System.out.println("Student does not exist");
        }
    }

    public static void editStudent(Student user) {
        Connection con = Connector.getConnection();
        try {
            String editdetails = String.format(StudentTable.updateStudent, user.getPassword(), user.getName(),
                    user.getStd(), user.getEmail(), user.getGender(), user.getDob(), user.getPhone(), user.getFees(),
                    user.getId());
            PreparedStatement stmt = con.prepareStatement(editdetails);
            stmt.executeUpdate();
            System.out.println(user.getId() + "'s Details Updated");

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }

    public static boolean postMaterials(String id, String Class, String description) {
        try {
            // table check yet to be defined
            String insertmaterials = String.format(MaterialsTable.postMaterials, id, Class, description);
            String checkClass = String.format("select class from teacher_details where teacher_id='%s'", id);
            Connection con = Connector.getConnection();

            PreparedStatement stmt2 = con.prepareStatement(checkClass);
            ResultSet rs = stmt2.executeQuery();

            ArrayList<String> Allclasses = new ArrayList<>();
            while (rs.next()) {
                Allclasses.add(rs.getString(1));
            }
            if (Allclasses.contains(Class)) {
                PreparedStatement stmt = con.prepareStatement(insertmaterials);
                stmt.executeUpdate();
                System.out.println("Materials posted");
                return true;
            } else {
                System.out.println("Enter Valid Details");

            }
            return false;
        } catch (Exception e) {
            System.out.println("Exception:" + e);
            return false;
        }
    }

    public static void addGrades(Marks std) {
        Connection con = Connector.getConnection();
        try {
            String insertQuery = String.format(MarksTable.insertMarks, std.getStudent_id(), std.getExam_title(),
                    std.getSub1(), std.getSub2(), std.getSub3(), std.calcGrade());
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.executeUpdate();
            System.out.println(std.getStudent_id() + "'s Marks Entered");

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }

    }

    public static void approveLeave(Leave user) {
        Connection con = Connector.getConnection();
        try {
            String updatequery = String.format(LeaveTable.leaveStatus, LeaveTable.statusApproved, user.getStudent_id(),
                    user.getDate());
            PreparedStatement stmt = con.prepareStatement(updatequery);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }

    }

    public static void RejectLeave(Leave user) {
        Connection con = Connector.getConnection();
        try {
            String updatequery = String.format(LeaveTable.leaveStatus, LeaveTable.statusRejected, user.getStudent_id(),
                    user.getDate());
            PreparedStatement stmt = con.prepareStatement(updatequery);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
    }

    public static void LeavePending(Leave user) {
        Connection con = Connector.getConnection();
        try {
            String updatequery = String.format(LeaveTable.leaveStatus, LeaveTable.statusPending, user.getStudent_id(),
                    user.getDate());
            PreparedStatement stmt = con.prepareStatement(updatequery);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }

    }

    public static int getLeaveCount(String email) {
        Connection con = Connector.getConnection();
        int count = 0;
        try {
            String countquery = String.format(LeaveTable.leaveCount, email);
            PreparedStatement stmt = con.prepareStatement(countquery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return count;
    }

    public static Teacher getTeacherId(String email) {
        Teacher user = null;
        try {
            Connection con = Connector.getConnection();
            String selectUserQuery = String.format(TeacherTable.fetchid, email);
            PreparedStatement stmt = con.prepareStatement(selectUserQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8));
                // System.out.println(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public static ArrayList<Forum> allUnrespondedQueries() {
        ArrayList<Forum> alForum = new ArrayList<Forum>();

        try {
            Connection con = Connector.getConnection();
            String query = ForumTable.selectForumNotResponded;
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Forum forum = new Forum(rs.getString(1), rs.getString(2), rs.getString(3));
                alForum.add(forum);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return alForum;
    }

    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("19eucs005", "12345", "Ajay", "12", "ajai@gmail", 3, "9545454545", 5000000);
        TeacherDBHelper.createTeacher(teacher);
    }

    public static ArrayList<String> getDistinctDates() {
        ArrayList<String> dates = new ArrayList<String>();
        try {
            Connection con = Connector.getConnection();
            String dateQuery = LeaveTable.selectDistinctDate;
            PreparedStatement stmt = con.prepareStatement(dateQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dates.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("exception occurred " + e.getMessage());
        }

        return dates;
    }

    public static ArrayList<Leave> getPendingLeavesFromDate(String date) {
        ArrayList<Leave> pendingLeaves = new ArrayList<>();
        try {
            Connection con = Connector.getConnection();
            String dateQuery = String.format(LeaveTable.selectPendingLeaves, date);
            PreparedStatement stmt = con.prepareStatement(dateQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Leave leave = new Leave(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                pendingLeaves.add(leave);
            }
        } catch (Exception e) {
            System.out.println("exception occurred " + e.getMessage());
        }

        return pendingLeaves;
    }

    public static String totalStudents(String std) {
        Connection con = Connector.getConnection();
        String count = null;
        try {
            String countQuery = String.format(TeacherTable.totStudents, std);
            PreparedStatement stmt = con.prepareStatement(countQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

}
