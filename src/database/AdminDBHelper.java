package database;

import models.Attendance;
import models.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

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
}
