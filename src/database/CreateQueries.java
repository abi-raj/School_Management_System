package database;

public class CreateQueries {

    public static final String createAdmin = "create table admin(admin_id varchar(20),password varchar(20))";
    public static final String createTeacher = "create table teacher_details(teacher_id varchar(10) PRIMARY KEY,password varchar(50),class varchar(20),name varchar(20),email varchar(30) UNIQUE,experience int,phone varchar(10),salary int,assigned int)";
    public static final String createStudent = "create table student(student_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),std varchar(20),email varchar(30) UNIQUE,gender varchar(50),dob varchar(15),phone varchar(10),fees int)";
    public static final String createAttendance = "create table attendance(std_id varchar(10),class varchar(20),date varchar(20),status varchar(20),FOREIGN KEY(std_id) references student(student_id) ON DELETE CASCADE)";
    public static final String createExam = "create table exams(exam_title varchar(20) PRIMARY KEY,start_date varchar(20),end_date varchar(20))";
    public static final String createForum = "create table forum(std_id varchar(10),description varchar(20),response varchar(20),FOREIGN KEY(std_id) references student(student_id) ON DELETE CASCADE)";
    public static final String createLeave = "create table leave(std_id varchar(10),date varchar(20),reason varchar(20),status varchar(20),FOREIGN KEY(std_id) references student(student_id) ON DELETE CASCADE)";
    public static final String createMaterials = "create table materials(teacher_id varchar(20),class varchar(20),materials varchar(20),FOREIGN KEY(teacher_id) references teacher_details(teacher_id) ON DELETE CASCADE)";
    public static final String createMarks = "create table marks(student_id varchar(20),exam_title varchar(20),sub1 int,sub2 int,sub3 int,grade_type varchar(10),FOREIGN KEY(student_id) references student(student_id) ON DELETE CASCADE,FOREIGN KEY(exam_title) references exams(exam_title) ON DELETE CASCADE)";
    // public static String createGrades="create table grades(student_id varchar(20),exam_title varchar(20),grade_type varchar(10),FOREIGN KEY(student_id) references student(student_id),FOREIGN KEY(exam_title) references exams(exam_title))";
}


class StudentTable {
    public static final String tableName = "student";
    public static final String createStudent = "insert into student values('%s','%s','%s','%s','%s','%s','%s','%s','%d')";
    public static final String checkStudentPresent = "select * from student where student_id='%s'";
    public static final String checkStudentLogin = "select * from student where email='%s' and password='%s'";
    public static final String updateStudent = "update student set password='%s',name='%s',std='%s',email='%s',gender='%s',dob='%s',phone='%s',fees='%d' where student_id='%s'";
    public static final String deleteStudent = "delete from student where student_id='%s'";
    public static final String selectSingleStudent = "select * from student where student_id='%s'";
    public static final String getAllClass = "select distinct std from student";
    public static final String studentByClass ="select * from student where std='%s'";
}

class LeaveTable {
    public static final String statusPending = "Pending";
    public static final String statusApproved = "Approved";
    public static final String statusRejected = "Rejected";
    public static final String tableName = "leave";
    public static final String insertLeave = "insert into leave values('%s','%s','%s','%s')";
    public static final String leaveStatus = "update leave set status='%s' where std_id='%s' and date='%s'";
    public static final String selectStudentLeave = "select * from leave where std_id='%s'";
    public static final String checkLeaveExists = "select * from leave where std_id='%s' and date='%s'";
    public static final String selectDistinctDate = "select distinct date from leave ";
    public static final String selectPendingLeaves = "select * from leave where date='%s' and status='Pending'";

    public static final String leaveCount = "select count(date) from leave where std_id in(select student_id from student where std in (select class from teacher_details where email='%s'))";
}

class MaterialsTable {
    public static final String tableName = "materials";
    public static final String selectMaterials = "select * from materials where class='%s'";
    public static final String postMaterials = "insert into materials values('%s','%s','%s')";
}

class MarksTable {
    public static final String tableName = "marks";
    public static final String selectStudentMarks = "select * from marks where student_id = '%s'";
    public static final String insertMarks = "insert into marks values('%s','%s','%s','%s','%s','%s')";
    public static final String marksByClass = "select * from marks where student_id in(select student_id from student where std='%s')";
}

class ForumTable {
    public static final String tableName = "forum";
    public static final String insertForum = "insert into forum values('%s','%s','%s')";
    public static final String selectStudentResponse = "select * from forum where std_id='%s'";
    public static final String updateResponse = "update forum set response='%s' where description='%s' and response='%s'";
    public static final String selectForumNotResponded = "select * from forum where response='No response yet'";
}

class TeacherTable {
    public static final String tableName = "teacher_details";
    public static final String createTeacher = "insert into teacher_details values('%s','%s','%s','%s','%s',%d,'%s',%d,%d)";
    public static final String updateTeacher = "update teacher_details set password='%s',name='%s',class='%s',email='%s',experience=%d,phone='%s',salary=%d  where teacher_id='%s'";
    public static final String deleteTeacher = "delete from teacher_details where teacher_id='%s'";
    public static final String viewTeacher = "select * from teacher_details where teacher_id='%s'";
    public static final String teacherLogin = "select * from teacher_details where email='%s' and password='%s'";
    public static final String fetchid = "select * from teacher_details where email='%s'";
    public static final String totStudents = "select count(name) from student where std='%s'";
    public static final String allTeachers = "select * from teacher_details";
    public static final String getpwd="select password from teacher_details where teacher_id='%s'";

}

class AdminTable {
    public static final String tableName = "admin";
    public static final String insertAdmin = "insert into admin values('%s','%s')";
    public static final String checkAdminLogin = "select * from admin where admin_id='%s' and password='%s'";
}

class AttendanceTable {
    public static final String tableName = "admin";
    public static final String getClassAttendance = "select * from attendance where class='%s'";
    public static final String selectDistinctDates = "select distinct date from attendance  ";
    public static final String selectAttendanceDate = "select * from attendance where date='%s' and class='%s'";

}

class CountQueries{
    public static final String totalStudentCount = "select count(student_id) from student"; //Admin
    public static final String studentCountByClass = "select count(student_id) from student where std='%s'"; //Admin
    public static final String teacherCount ="select count(teacher_id) from teacher_details"; //Admin
    public static final String totalInquiryCount = "select count(std_id) from forum"; //Teacher
    public static final String respondedInquiryCount = "select count(std_id) from forum where response not in ('No response yet')";  //Teacher
    public static final String totalLeaveRequestsCount = "select count(date) from leave where std_id in(select student_id from student where std in (select class from teacher_details where email='%s'))"; //Teacher
    public static final String approvedLeaveRequestsCount = "select count(date) from leave where std_id in(select student_id from student where std in (select class from teacher_details where email='%s')) and status='Approved'"; //Teacher
    public static final String pendingLeaveRequestsCount = "select count(date) from leave where std_id in(select student_id from student where std in (select class from teacher_details where teacher_id='%s')) and status='Pending'"; //Teacher
    public static final String datedLeaveCount = "select count(std_id) from leave where status='Approved' and date='%s'"; //Admin additional dash
    public static final String datedLeaveCountByClass = "select count(date) from leave where std_id in(select student_id from student where std='%s') and date='%s'"; //Admin (dobut)
    public static final String attendanceTodayByClass = "select count(std_id) from attendance where date='%s' and class='%s' and status='Present'"; //Admin

}

class ExamsTable{
    public static final String insertExam = "insert into exams values('%s','%s','%s')";
    public static final String updateExam = "update exams set start_date='%s',end_date='%s' where exam_title='%s'";
    public static final String deleteExam = "delete from exams where exam_title='%s'";
    public static final String selectExam = "select * from exams ";
}