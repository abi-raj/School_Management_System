package database;


import models.Attendance;
import models.Exam;
import models.Teacher;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import database.ValidationHelper;

interface AdminTableOperations {
    boolean checkAdminLogin(String id, String password);

public class AdminDBHelper {

    public static void main(String[] args) {
        System.out.println(AdminDBHelper.checkAdminLogin("19teach001", "12345"));
    }

    public static boolean checkAdminLogin(String id, String password) {
        try {
            String selectQuery = String.format(AdminTable.checkAdminLogin, id, password);
            Connection conn = Connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Exception occurred admin login " + e.getMessage());
        }
        return false;
    }

    public static boolean createAdmin(String id, String password) {
        try {
            String insertQuery = String.format(AdminTable.insertAdmin, id, password);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in admin creation " + e.getMessage());
        }
        return false;
    }

    public static void sendEmailNotification() {

    }

    public static boolean markPayroll(String teacher_id, int salary) {
        Teacher teacher = TeacherDBHelper.viewTeacher(teacher_id);
        if (salary > 0) {
            teacher.setSalary(salary);
            return TeacherDBHelper.updateTeacher(teacher);
        }

        return false;
    }

    public static ArrayList<Attendance> viewAttendance(String std) {
        ArrayList<Attendance> attendanceResult = new ArrayList<>();
        try {
            String selectAttendance = String.format(AttendanceTable.getClassAttendance, std);
            Connection con = Connector.getConnection();
            PreparedStatement stmt = con.prepareStatement(selectAttendance);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4));
                attendanceResult.add(attendance);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return attendanceResult;
    }

    public static void addEventData() {

    }

    public static int getTotalStudentCount() {
        Connection con = Connector.getConnection();
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

    public static int getTeacherCount() {
        Connection con = Connector.getConnection();
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

    public static int getStudentCountByClass(String std) {
        Connection con = Connector.getConnection();
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

    public static boolean createExam(Exam exam) {
        try {
            Connection con = Connector.getConnection();
            String insertQuery = String.format(ExamsTable.insertExam, exam.getTitle(), exam.getStart_date(),
                    exam.getEnd_date());
            PreparedStatement stmt = con.prepareStatement(insertQuery);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }


        return false;
    }

    public static boolean updateExam(Exam exam) {

        try {
            Connection con = Connector.getConnection();
            String updateQuery = String.format(ExamsTable.updateExam, exam.getStart_date(), exam.getEnd_date(),
                    exam.getTitle());
            PreparedStatement stmt = con.prepareStatement(updateQuery);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }

        return false;
    }

    public static boolean deleteExam(String title) {
        try {
            Connection con = Connector.getConnection();
            String deleteQuery = String.format(ExamsTable.deleteExam, title);
            PreparedStatement stmt = con.prepareStatement(deleteQuery);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }


        return false;
    }

    public static ArrayList<Exam> getExams() {
        ArrayList<Exam> alExam = new ArrayList<>();
        try {
            Connection con = Connector.getConnection();
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

    public static int getPresentToday(String date, String std) {
        Connection con = Connector.getConnection();
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

    public static double attendancePercentage(String date, String std) {
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

    public static ArrayList<String> getAllClass() {
        ArrayList<String> alClass = new ArrayList<>();
        try {
            Connection con = Connector.getConnection();

            PreparedStatement stmt = con.prepareStatement(StudentTable.getAllClass);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                alClass.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
        return alClass;
    }
}
