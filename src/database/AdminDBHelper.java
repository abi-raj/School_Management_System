package database;


import models.Attendance;
import models.Exam;
import models.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

interface AdminTableOperations {
    boolean checkAdminLogin(String id, String password);

    boolean createAdmin(String id, String password);

    void sendEmailNotification(); //Has to be done by the Epic Guy

    boolean markPayroll(String teacher_id, int salary);

    ArrayList<Attendance> viewAttendance(String std);

    void addEventData(); //required clarification

}

public class AdminDBHelper implements AdminTableOperations {
    private static final String url = "jdbc:postgresql://localhost:5432/teacher";
    private static final String driverName = "org.postgresql.Driver";
    private static final String username = "postgres";
    private static final String password = "12345";
    private Connection connection = null;

    public static void main(String[] args) {
        System.out.println(new AdminDBHelper().checkAdminLogin("19teach001", "12345"));
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

    @Override
    public boolean checkAdminLogin(String id, String password) {
        try {
            String selectQuery = String.format(AdminTable.checkAdminLogin, id, password);
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred admin login " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean createAdmin(String id, String password) {
        try {
            String insertQuery = String.format(AdminTable.insertAdmin, id, password);
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in admin creation " + e.getMessage());
        }
        return false;
    }

    @Override
    public void sendEmailNotification() {

    }

    @Override
    public boolean markPayroll(String teacher_id, int salary) {
        TeacherDBHelper tHelper = new TeacherDBHelper();
        Teacher teacher = tHelper.viewTeacher(teacher_id);
        if (salary > 0) {
            teacher.setSalary(salary);
            return tHelper.updateTeacher(teacher);
        }

        return false;
    }

    @Override
    public ArrayList<Attendance> viewAttendance(String std) {
        ArrayList<Attendance> attendanceResult = new ArrayList<>();
        try {
            String selectAttendance = String.format(AttendanceTable.getClassAttendance, std);
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(selectAttendance);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                attendanceResult.add(attendance);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return attendanceResult;
    }


    @Override
    public void addEventData() {


    }

    public int getTotalStudentCount() {
        Connection con = getConnection();
        int count = 0;
        try {
            String countquery = (CountQueries.totalStudentCount);
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

    public int getTeacherCount() {
        Connection con = getConnection();
        int count = 0;
        try {
            String countquery = (CountQueries.teacherCount);
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

    public int getStudentCountByClass(String std) {
        Connection con = getConnection();
        int count = 0;
        try {
            String countquery = String.format(CountQueries.studentCountByClass, std);
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

    public boolean createExam(Exam exam) {
        try {
            Connection con = getConnection();
            String insertQuery = String.format(ExamsTable.insertExam, exam.getTitle(), exam.getStart_date(), exam.getEnd_date());
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }


        return false;
    }

    public boolean updateExam(Exam exam) {
        try {
            Connection con = getConnection();
            String updateQuery = String.format(ExamsTable.updateExam, exam.getStart_date(), exam.getEnd_date(), exam.getTitle());
            PreparedStatement stmt = con.prepareStatement(updateQuery);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }


        return false;
    }

    public boolean deleteExam(Exam exam) {
        try {
            Connection con = getConnection();
            String deleteQuery = String.format(ExamsTable.deleteExam, exam.getTitle());
            PreparedStatement stmt = con.prepareStatement(deleteQuery);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }


        return false;
    }

    public ArrayList<Exam> getExams() {
        ArrayList<Exam> alExam = new ArrayList<>();
        try {
            Connection con = getConnection();
            String selectQuery = ExamsTable.selectExam;
            PreparedStatement stmt = con.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Exam exam = new Exam(rs.getString(1), rs.getString(2), rs.getString(3));
                alExam.add(exam);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return alExam;
    }

    public int getPresentToday(String date, String std) {
        Connection con = getConnection();
        int count = 0;
        try {
            String countquery = String.format(CountQueries.attendanceTodayByClass, date, std);
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

    public double attendancePercentage(String date, String std) {
        double per = 0;
        try {
            double totalCount = getStudentCountByClass(std);
            double presentToday = getPresentToday(date, std);
            per = (presentToday / totalCount) * 100;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return per;
    }
}
