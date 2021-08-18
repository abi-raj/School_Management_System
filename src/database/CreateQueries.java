package database;

public class CreateQueries {

    public static final String createAdmin="create table admin(admin_id varchar(20),password varchar(20))";
    public static final String createTeacher="create table teacher_details(teacher_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),email varchar(30) UNIQUE,experience int,phone varchar(10),salary int)";
    public static final String createStudent="create table student(student_id varchar(10) PRIMARY KEY,password varchar(50),name varchar(20),std varchar(20),email varchar(30) UNIQUE,gender varchar(50),dob varchar(15),phone varchar(10),fees int)";
    public static final String createAttendance="create table attendance(std_id varchar(10),class varchar(20),date varchar(20),status varchar(20),FOREIGN KEY(std_id) references student(student_id))";
    public static final String createExam="create table exams(exam_title varchar(20) PRIMARY KEY,start_date varchar(20),end_date varchar(20))";
    public static final String createForum="create table forum(std_id varchar(10),description varchar(20),response varchar(20),FOREIGN KEY(std_id) references student(student_id))";
    public static final String createLeave="create table leave(std_id varchar(10),date varchar(20),reason varchar(20),status varchar(20),FOREIGN KEY(std_id) references student(student_id))";
    public static final String createMaterials="create table materials(teacher_id varchar(20),class varchar(20),materials varchar(20),FOREIGN KEY(teacher_id) references teacher_details(teacher_id))";
    public static final String createMarks="create table marks(student_id varchar(20),sub1 int,sub2 int,sub3 int,sub4 int,sub5 int,FOREIGN KEY(student_id) references student(student_id))";
    public static final String createGrades="create table grades(student_id varchar(20),exam_title varchar(20),grade_type varchar(10),FOREIGN KEY(student_id) references student(student_id),FOREIGN KEY(exam_title) references exams(exam_title))";
}
