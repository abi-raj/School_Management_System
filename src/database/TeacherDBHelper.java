package database;

import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherDBHelper {

    public static void main(String[] args) throws Exception {
        // Teacher teacher = new Teacher("19eucs005", "12345", "Ajay", "12",
        // "ajai@gmail", 3, "9545454545", 5000000, 0);
        // System.out.println(TeacherDBHelper.allTeacherEmails().get(0));

    }

    public static void createTable() {
        try {
            Connection conn = Connector.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(CreateQueries.createTeacher);
            System.out.println("Table Teacher created");
        } catch (Exception e) {
            System.out.println("Exception on createTable: " + e);
        }
    }

    public static boolean teacher_tableExists() {
        try {
            Connection con = Connector.getConnection();
            ResultSet tables = con.getMetaData().getTables(null, null, TeacherTable.tableName, null);
            if (tables.next()) {
                System.out.println("Teacher table exists");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception occured on teacher_tableExists: " + e);

        }
        createTable();
        return false;
    }

    public static ArrayList<String> allTeacherEmails() {
        ArrayList<String> fin = new ArrayList<String>();
        try {
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT email from teacher_details");
            ResultSet rs = stmt.executeQuery();
            for (; rs.next();) {
                String email = rs.getString("email");
                fin.add(email);
            }

        } catch (Exception e) {
            System.out.println("Exception occured on allTeacherEmails: " + e);

        }
        return fin;

    }

    public static boolean createTeacher(Teacher user) {
        // teacher_tableExists();
        String insertQuery = String.format(TeacherTable.createTeacher, user.getTeacher_id(), user.getPassword(),
                user.gettClass(), user.getName(), user.getEmail(), user.getExperience(), user.getPhone(),
                user.getSalary(), 0);

        try {
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.executeUpdate();
            System.out.println("User Record inserted");
            return true;
        } catch (Exception e) {
            System.out.println("Exception occured on createTeacher:" + e.getMessage());
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
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }

        return false;
    }

    public static ArrayList<Materials> getTeacherMaterials(String id) {
        ArrayList<Materials> alMaterials = new ArrayList<>();
        try {
            Connection con = Connector.getConnection();
            String query = String.format(MaterialsTable.getTeacherMaterials, id);
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Materials material = new Materials(rs.getString(1), rs.getString(2), rs.getString(3));
                alMaterials.add(material);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return alMaterials;
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
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
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
            stmt.executeUpdate();
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
            String stdQuery = String.format("select * from student where student_id='%s'", id);
            String std = null;
            try {
                PreparedStatement stmt = con.prepareStatement(stdQuery);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    std = rs.getString(4);
                }

                // System.out.println(rs.getString(1));
            } catch (Exception e) {
                System.out.println("Exception:" + e);
            }
            String attendanceQuery = String.format("insert into attendance values('%s','%s','%s','%s')", id, std, date,
                    status);
            try {
                PreparedStatement stmt = con.prepareStatement(attendanceQuery);
                stmt.executeUpdate();
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

    public static int approvedLeaveCount(String id) {
        Connection con = Connector.getConnection();
        int count = 0;
        try {
            String countquery = String.format(CountQueries.approvedLeaveRequestsCount, id);
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

    public static int PendingLeaveCount(String email) {
        Connection con = Connector.getConnection();
        int count = 0;
        try {
            String countquery = String.format(CountQueries.pendingLeaveRequestsCount, email);
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

    public static int totalInquiryCount() {
        Connection con = Connector.getConnection();
        int count = 0;
        try {
            String countquery = (CountQueries.totalInquiryCount);
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

    public static int respondedInquiryCount() {
        Connection con = Connector.getConnection();
        int count = 0;
        try {
            String countquery = (CountQueries.respondedInquiryCount);
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
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                // System.out.println(rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public static ArrayList<Teacher> allTeachers() {
        ArrayList<Teacher> alTeachers = new ArrayList<>();
        try {
            Connection con = Connector.getConnection();
            String query = TeacherTable.allTeachers;
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Teacher teacher = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                alTeachers.add(teacher);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return alTeachers;
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

    public static ArrayList<String> getDistinctDatesAttendance() {
        ArrayList<String> str = new ArrayList<>();
        try {
            Connection con = Connector.getConnection();
            String dateQuery = AttendanceTable.selectDistinctDates;
            PreparedStatement stmt = con.prepareStatement(dateQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                str.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("exception occurred " + e.getMessage());
        }
        return str;
    }

    public static ArrayList<Attendance> getAttendanceByDate(String date, String std) {
        ArrayList<Attendance> alAttendance = new ArrayList<>();
        try {
            String query = String.format(AttendanceTable.selectAttendanceDate, date, std);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4));
                alAttendance.add(attendance);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return alAttendance;
    }

    public static ArrayList<Marks> getMarksByClass(String std) {
        ArrayList<Marks> alMarks = new ArrayList<>();
        try {
            String query = String.format(MarksTable.marksByClass, std);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Marks mark = new Marks(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                alMarks.add(mark);
            }
        } catch (Exception rx) {
            System.out.println("Exception occurred : " + rx.getMessage());
        }

        return alMarks;

    }

    public static String getpwd(String id) {
        String pwd = "";
        try {
            Connection con = Connector.getConnection();
            String pwdQuery = String.format(TeacherTable.getpwd, id);
            PreparedStatement stmt = con.prepareStatement(pwdQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pwd = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return pwd;
    }

    public static boolean reAssign(int assigned, String id) {
        try {
            Connection con = Connector.getConnection();
            String query = String.format(TeacherTable.assignPayroll, assigned, id);
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
