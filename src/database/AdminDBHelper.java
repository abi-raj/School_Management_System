package database;


interface AdminTableOperations{
    boolean checkAdminLogin(String id,String password);
    boolean createAdmin(String id,String password);
    void sendEmailNotification();
    void markPayroll(String teacher_id,int salary);
    void viewAttendance();
    void addEventData();

}
public class AdminDBHelper {

}
