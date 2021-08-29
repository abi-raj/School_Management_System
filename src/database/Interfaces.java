package database;

import java.util.ArrayList;
import models.*;

interface DBcredentials {
    static final String url = "jdbc:postgresql://localhost:5432/bootcamp";
    static final String driverName = "org.postgresql.Driver";
    static final String username = "postgres";
    static final String password = "Test@123";
}

interface StudentTableOperations {
    boolean payFees(String id, int amount);

    boolean askQuestion(String id, String description);

    ArrayList<Forum> getQuestionsResponse(String id);

    boolean applyLeave(String id, String date, String reason);

    ArrayList<Leave> getLeaveStatus(String id);

    ArrayList<Materials> getMaterials(String std);

    ArrayList<Marks> viewGrades(String id);

    boolean createStudent(Student student);

    boolean checkStudentExists(String id);

    boolean checkStudentLogin(String id, String password);

    boolean updateStudent(Student student);

    boolean deleteStudent(String id);

    Student viewProfile(String id);

}

interface TeacherTableOperations {

    void createTable();

    boolean teacher_tableExists();

    boolean checkTeacherLogin(String id, String password);

    boolean createTeacher(Teacher user);

    Teacher viewTeacher(String id);

    boolean updateTeacher(Teacher user);

    boolean deleteTeacher(String id);

    // Data types for below void methods are yet to be defined
    void replyQuestion(Forum query);

    void markAttendance(String id, String date, String status);

    void editStudent(Student user);

    boolean postMaterials(String id, String Class, String description);

    void addGrades(Marks std);

    void approveLeave(Leave user);

    void RejectLeave(Leave user);

    void LeavePending(Leave user);

    int getLeaveCount(String email);

    Teacher getTeacherId(String email);

    // boolean teacherExist(String id);
    ArrayList<Forum> allUnrespondedQueries();
}

interface AdminTableOperations {
    boolean checkAdminLogin(String id, String password);

    boolean createAdmin(String id, String password);

    void sendEmailNotification(); // Has to be done by the Epic Guy

    boolean markPayroll(String teacher_id, int salary);

    ArrayList<Attendance> viewAttendance(String std);

    void addEventData(); // required clarification

}