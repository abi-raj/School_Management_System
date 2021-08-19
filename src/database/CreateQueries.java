package database;

public class CreateQueries {

    public static final String createAdmin="create table admin(admin_id varchar(20) PRIMARY KEY,password varchar(20))";
    public static final String createTeacher="create table teacher_details(teacher_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),email varchar(30) UNIQUE,experience int,phone varchar(10),salary int)";
    public static final String createStudent="create table student(student_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),std varchar(20),email varchar(30) UNIQUE,gender varchar(50),dob varchar(15),phone varchar(10),fees int)";
    public static final String createAttendance="create table attendance(std_id varchar(10),class varchar(20),date varchar(20),status varchar(20),FOREIGN KEY(std_id) references student(student_id))";
    public static final String createExam="create table exams(exam_title varchar(20) PRIMARY KEY,start_date varchar(20),end_date varchar(20))";
    public static final String createForum="create table forum(std_id varchar(10),description varchar(20),response varchar(20),FOREIGN KEY(std_id) references student(student_id))";
    public static final String createLeave="create table leave(std_id varchar(10),date varchar(20),reason varchar(20),status varchar(20),FOREIGN KEY(std_id) references student(student_id))";
    public static final String createMaterials="create table materials(teacher_id varchar(20),class varchar(20),materials varchar(20),FOREIGN KEY(teacher_id) references teacher_details(teacher_id))";
    public static final String createMarks="create table marks(student_id varchar(20),exam_title varchar(20),sub1 int,sub2 int,sub3 int,grade_type varchar(10),FOREIGN KEY(student_id) references student(student_id),FOREIGN KEY(exam_title) references exams(exam_title))";
    // public static String createGrades="create table grades(student_id varchar(20),exam_title varchar(20),grade_type varchar(10),FOREIGN KEY(student_id) references student(student_id),FOREIGN KEY(exam_title) references exams(exam_title))";
}

class StudentTable{
    public static final String tableName = "student";
    public static final String createStudent="insert into student values('%s','%s','%s','%s','%s','%s','%s','%s','%d')";
    public static final String checkStudentPresent = "select * from student where student_id='%s'";
    public static final String checkStudentLogin ="select * from student where student_id='%s' and password='%s'";
    public static final String updateStudent ="update student set password='%s',name='%s',std='%s',email='%s',gender='%s',dob='%s',phone='%s',fees='%d' where student_id='%s'";
    public static final String deleteStudent = "delete from student where regno='%s'";
    public static final String selectSingleStudent ="select * from student where student_id='%s'";
}

class LeaveTable{
    public static final String statusPending = "Pending";
    public static final String statusApproved = "Approved";
    public static final String statusRejected = "Rejected";
    public static final String tableName = "leave";
    public static final String insertLeave = "insert into leave values('%s','%s','%s','%s')";
    public static final String selectStudentLeave = "select * from leave where std_id='%s'";
}

class MaterialsTable{
    public static final String tableName = "materials";
    public static final String selectMaterials = "select * from materials where class='%s'";
}

class MarksTable{
    public static final String tableName = "marks";
    public static final String selectStudentMarks ="select * from marks where student_id = '%s'";
}

class ForumTable{
    public static  final String tableName = "forum";
    public static final String insertForum = "insert into forum values('%s','%s','%s')";
    public static final String selectStudentResponse = "select * from forum where std_id='%s'";
}

class AdminTable{
    public static  final String tableName = "admin";
    public static final String insertAdmin = "insert into admin values('%s','%s')";
    public static final String checkAdminLogin = "select * from admin where admin_id='%s' and password='%s'";
}

class AttendanceTable{
    public static  final String tableName = "admin";
    public static final String getClassAttendance ="select * from attendance where class='%s'";
}