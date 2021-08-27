package database;

import models.*;

import java.sql.*;
import java.util.ArrayList;

public class StudentDBHelper {

    public static void main(String[] args) throws SQLException {
        // System.out.println(new StudentDBHelper().viewProfile("19eucs001").getFees());
        // Student student = new Student("19eucs001", "12345", "Abiraj Rajendran", "10",
        // "abi@gmail.com", "Male", "30-11-2001", "9655047766", 10000);
        System.out.println(StudentDBHelper.getLeaveStatus("19eucs001"));
        // System.out.println(new StudentDBHelper().createStudent(student));
        // System.out.println(new StudentDBHelper().checkStudentExists("19eucs001"));
    }

    public static void createTable() throws SQLException {
        Connection conn = Connector.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(CreateQueries.createStudent);
        System.out.println("Student table created");
    }

    public static boolean tableExists() {
        try {
            Connection con = Connector.getConnection();
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

    public static boolean payFees(String id, int amount) {
        Student student = viewProfile(id);
        int existingFees = student.getFees();
        if (existingFees - amount < 0) {
            return false;
        } else {
            student.setFees(existingFees - amount);
            return updateStudent(student);

        }

    }

    public static boolean askQuestion(String id, String description) {
        try {
            String askForum = String.format(ForumTable.insertForum, id, description, "No response yet");
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(askForum);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return false;
    }

    public static ArrayList<Forum> getQuestionsResponse(String id) {
        ArrayList<Forum> forumsResult = new ArrayList<>();
        try {
            String selectQuery = String.format(ForumTable.selectStudentResponse, id);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Forum forum = new Forum(rs.getString(1), rs.getString(2), rs.getString(3));
                forumsResult.add(forum);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }

        return forumsResult;
    }

    public static boolean applyLeave(String id, String date, String reason) {

        try {
            String applyQuery = String.format(LeaveTable.insertLeave, id, date, reason, LeaveTable.statusPending);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(applyQuery);
            stmt.executeUpdate();
            System.out.println("Leave applied");
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return false;
    }

    public static boolean checkLeaveAlreadyPresent(String id, String date) {
        try {
            String checkLeave = String.format(LeaveTable.checkLeaveExists, id, date);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(checkLeave);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return false;
    }

    public static ArrayList<Leave> getLeaveStatus(String id) {
        ArrayList<Leave> leaveResult = new ArrayList<>();
        try {
            String selectLeave = String.format(LeaveTable.selectStudentLeave, id);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(selectLeave);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Leave leave = new Leave(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                // System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"
                // "+rs.getString(4));
                leaveResult.add(leave);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }

        return leaveResult;
    }

    public static ArrayList<Materials> getMaterials(String std) {
        ArrayList<Materials> materialsResult = new ArrayList<>();
        try {
            String selectLeave = String.format(MaterialsTable.selectMaterials, std);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(selectLeave);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Materials material = new Materials(rs.getString(1), rs.getString(2), rs.getString(3));
                materialsResult.add(material);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }

        return materialsResult;
    }

    public static ArrayList<Marks> viewGrades(String id) {
        ArrayList<Marks> marksResult = new ArrayList<>();
        try {
            String selectMarks = String.format(MarksTable.selectStudentMarks, id);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(selectMarks);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Marks marks = new Marks(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                marksResult.add(marks);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return marksResult;
    }

    public static boolean createStudent(Student student) {
        tableExists();
        String insertQuery = String.format(StudentTable.createStudent, student.getId(), student.getPassword(),
                student.getName(), student.getStd(), student.getEmail(), student.getGender(), student.getDob(),
                student.getPhone(), student.getFees());
        try {
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            stmt.executeUpdate();
            System.out.println("Student record inserted");

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean checkStudentExists(String id) {
        tableExists();
        try {
            String selectQuery = String.format(StudentTable.checkStudentPresent, id);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
        return false;
    }

    public static boolean checkStudentLogin(String id, String password) {
        tableExists();
        try {
            String selectQuery = String.format(StudentTable.checkStudentLogin, id, password);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }

        return false;
    }

    public static boolean updateStudent(Student student) {
        try {
            Connection conn = Connector.getConnection();
            String updateQuery = String.format(StudentTable.updateStudent, student.getPassword(), student.getName(),
                    student.getStd(), student.getEmail(), student.getGender(), student.getDob(), student.getPhone(),
                    student.getFees(), student.getId());
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
        return false;
    }

    public static boolean deleteStudent(String id) {
        tableExists();
        try {
            Connection conn = Connector.getConnection();
            String deleteQuery = String.format(StudentTable.deleteStudent, id);
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return false;
    }

    public static Student viewProfile(String id) {
        Student student = null;
        tableExists();
        try {
            Connection con = Connector.getConnection();
            String selectUserQuery = String.format(StudentTable.selectSingleStudent, id);
            PreparedStatement stmt = con.prepareStatement(selectUserQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                // System.out.println(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public Leave getSingleLeave(String id, String date) {
        Leave leave = null;

        try {
            String checkLeave = String.format(LeaveTable.checkLeaveExists, id, date);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(checkLeave);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                leave = new Leave(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return leave;
    }
}
