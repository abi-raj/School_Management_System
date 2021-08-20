package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Objects;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class TeacherGUI  {

    JPanel contentPane;
    JPanel homepanel ;
    JPanel attendancepanel;
    JPanel gradespanel ;
    JPanel leaveformpanel ;
    JPanel studentpanel ;
    JPanel learningpanel;
    JPanel forumpanel ;
    JPanel payrollpanel ;
    private JTextField a_stu_name;
    private JTextField a_student_date;


    public TeacherGUI() {
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 100, 1336, 814);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(0, 0));
        f.setContentPane(contentPane);


        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        contentPane.add(p);

        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(29,217,171));
        sidebar.setBounds(0, 0, 120, 814);
        p.add(sidebar);
        sidebar.setLayout(null);

        JButton home = new JButton();
        home.setBounds(41, 58, 43, 63);
        home.setToolTipText("Home");
        home.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/home profile.png"))));
        home.setBackground(new Color(29,217,171));
        home.setLayout(null);
        home.setFocusPainted(false);
        home.setBorder(null);
        sidebar.add(home);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(true);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(false) ;

            }
        });

        JButton attendance = new JButton();
        attendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(true);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(false) ;
            }

        });
        attendance.setBounds(41, 224, 45, 63);
        attendance.setToolTipText("Attendance");
        attendance.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("images/attendance.png")))));
        attendance.setBackground(new Color(29,217,171));
        attendance.setLayout(null);
        attendance.setFocusPainted(false);
        attendance.setBorder(null);
        sidebar.add(attendance);

        JButton grade = new JButton();
        grade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(true) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(false) ;
            }
        });
        grade.setBounds(39, 310, 45, 56);
        grade.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/grade.png"))));
        grade.setBackground(new Color(29,217,171));
        grade.setLayout(null);
        grade.setFocusPainted(false);
        grade.setBorder(null);
        grade.setToolTipText("Grades");
        sidebar.add(grade);

        JButton student = new JButton();
        student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(true) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(false) ;
            }
        });
        student.setBounds(39, 151, 45, 47);
        student.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/student.png"))));
        student.setLayout(null);
        student.setFocusPainted(false);
        student.setBorder(null);
        student.setBackground(new Color(29,217,171));
        student.setToolTipText("Student Details\r\n");
        sidebar.add(student);

        JButton leaveform = new JButton();
        leaveform.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(true) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(false) ;
            }

        });
        leaveform.setToolTipText("Leave Form");
        leaveform.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/leave.png"))));
        leaveform.setLayout(null);
        leaveform.setBackground(new Color(29,217,171));
        leaveform.setFocusPainted(false);
        leaveform.setBorder(null);
        leaveform.setBounds(41, 475, 45, 56);
        sidebar.add(leaveform);

        JButton inquiry = new JButton("");
        inquiry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(true) ;
                payrollpanel.setVisible(false) ;
            }
        });
        inquiry.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/chat icon.png"))));
        inquiry.setToolTipText("Inquiry Forum");
        inquiry.setBackground(new Color(29,217,171));
        inquiry.setLayout(null);
        inquiry.setFocusPainted(false);
        inquiry.setBorder(null);
        inquiry.setBounds(39, 566, 45, 47);
        sidebar.add(inquiry);

        JButton learning = new JButton();
        learning.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(true);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(false) ;
            }
        });
        learning.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/learning.png"))));
        learning.setToolTipText("Learning Materials");
        learning.setBackground(new Color(29,217,171));
        learning.setLayout(null);
        learning.setFocusPainted(false);
        learning.setBorder(null);
        learning.setBounds(39, 389, 45, 63);
        sidebar.add(learning);

        JButton payroll = new JButton();
        payroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false) ;
                leaveformpanel.setVisible(false) ;
                studentpanel.setVisible(false) ;
                learningpanel.setVisible(false);
                forumpanel.setVisible(false) ;
                payrollpanel.setVisible(true) ;

            }
        });
        payroll.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/payroll.png"))));
        payroll.setToolTipText("Payroll");
        payroll.setLayout(null);
        payroll.setFocusPainted(false);
        payroll.setBorder(null);
        payroll.setBounds(41, 644, 45, 63);
        payroll.setBackground(new Color(29,217,171));
        sidebar.add(payroll);




        homepanel = new JPanel();
        homepanel.setBounds(124, 0, 1336, 1000);
        homepanel.setBackground(Color.WHITE);
        homepanel.setLayout(null);
        p.add(homepanel);



        JLabel teacher_name=new JLabel("Teacher Name");
        teacher_name.setBounds(200,271,300,40);
        teacher_name.setFont(new Font("Segoe UI",Font.BOLD, 36));
        teacher_name.setForeground(new Color(102, 102, 102));
        homepanel.add(teacher_name);


        JLabel teacher_email=new JLabel("emailaddress@schoolname.com");
        teacher_email.setBounds(200,321,300,40);
        teacher_email.setFont(new Font("Segoe UI",Font.PLAIN, 18));
        teacher_email.setForeground(new Color(102, 102, 102));
        homepanel.add(teacher_email);


        JLabel teacher_phone=new JLabel("9876543210");
        teacher_phone.setBounds(200,371,300,40);
        teacher_phone.setFont(new Font("Segoe UI",Font.PLAIN, 18));
        teacher_phone.setForeground(new Color(102, 102, 102));
        homepanel.add(teacher_phone);


        JLabel teacher_work_exp=new JLabel("5 years work experience");
        teacher_work_exp.setBounds(200,421,300,40);
        teacher_work_exp.setFont(new Font("Segoe UI",Font.PLAIN, 18));
        teacher_work_exp.setForeground(new Color(102, 102, 102));
        homepanel.add(teacher_work_exp);


        JLabel teacher_profile=new JLabel();
        teacher_profile.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/avatar.png"))));
        teacher_profile.setBounds(585,218,300,281);
        teacher_profile.setFont(new Font("Segoe UI",Font.PLAIN, 18));
        teacher_profile.setForeground(new Color(102, 102, 102));
        homepanel.add(teacher_profile);

        JPanel welcometext = new JPanel();
        welcometext.setBounds(50, 20, 1100, 154);
        welcometext.setBackground(new Color(250,250,250));
        welcometext.setLayout(null);
        homepanel.add(welcometext);

        JLabel text1 = new JLabel("Welcome Teacher !");
        text1.setForeground(new Color(52,52,52));
        text1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        text1.setBounds(60, 21, 454, 46);
        welcometext.add(text1);

        JLabel text2 = new JLabel("Have a good day.....");
        text2.setForeground(Color.GRAY);
        text2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text2.setBounds(60, 77, 226, 26);
        welcometext.add(text2);





        attendancepanel = new JPanel();
        attendancepanel.setBackground(new Color(250,250,250));
        attendancepanel.setBounds(132, 0, 1336, 1000);
        attendancepanel.setLayout(null);
        p.add(attendancepanel);

        JPanel updateAttendance = new JPanel();
        updateAttendance.setBackground(Color.WHITE);
        updateAttendance.setBounds(40, 22, 1100, 350);
        updateAttendance.setLayout(null);
        attendancepanel.add(updateAttendance);

        JLabel l1 = new JLabel("Attendance Entry");
        l1.setBounds(70,30,300,40);
        updateAttendance.add(l1);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 36));

        JLabel a_student = new JLabel("Student Name");
        a_student.setFont(new Font("Segoe UI", Font.BOLD, 16));
        a_student.setBounds(70, 114, 279, 31);
        updateAttendance.add(a_student);

        JLabel a_date = new JLabel("Date");
        a_date.setFont(new Font("Segoe UI", Font.BOLD, 16));
        a_date.setBounds(546, 114, 150, 30);
        updateAttendance.add(a_date);

        a_stu_name = new JTextField();
        a_stu_name.setBounds(70, 164, 342, 47);
        updateAttendance.add(a_stu_name);
        a_stu_name.setMargin(new Insets(5, 10, 5, 5));
        a_stu_name.setColumns(10);

        a_student_date = new JTextField();
        a_student_date.setBounds(546, 164, 300, 47);
        updateAttendance.add(a_student_date);
        a_stu_name.setMargin(new Insets(5, 10, 5, 5));
        a_student_date.setColumns(10);

        JButton updatebutton = new JButton("Update");
        updatebutton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        updatebutton.setForeground(Color.WHITE);
        updatebutton.setBackground(new Color(255, 160, 122));
        updatebutton.setBounds(70,250,100, 40);
        updatebutton.setLayout(null);
        updatebutton.setFocusPainted(false);
        updatebutton.setBorder(null);
        updateAttendance.add(updatebutton);


        String data[][]={ {"001","Aisha","P"},
                {"102","Jay","P"},
                {"101","Steafn","A"}};
        String column[]={"ID","NAME","P/A"};
        JTable jt=new JTable(data,column);
        jt.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "NAME", "P/A"},
                        {"001", "Aisha", "P"},
                        {"102", "Jay", "P"},
                        {"101", "Stefan", "A"},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "ID", "NAME", "P/A"
                }
        ));
        jt.setRowHeight(jt.getRowHeight() + 20);
        jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jt.setBounds(40,389,1100,349);
        attendancepanel.add(jt);


        gradespanel = new JPanel();
        gradespanel.setBackground(Color.white);
        gradespanel.setBounds(132, 0, 1336, 777);
        gradespanel.setLayout(null);
        p.add(gradespanel);

        JPanel grade_info = new JPanel();
        grade_info.setBackground(new Color(250,250,250));
        grade_info.setBounds(24, 27, 1150, 142);
        grade_info.setLayout(null);
        gradespanel.add(grade_info);

        JLabel g_l1 = new JLabel("Student Grade Record");
        g_l1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        g_l1.setBounds(47, 31, 694, 47);
        grade_info.add(g_l1);

        JLabel g_l2 = new JLabel("Edit, update and assign student grades here!");
        g_l2.setForeground(Color.GRAY);
        g_l2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        g_l2.setBounds(57, 84, 398, 33);
        grade_info.add(g_l2);

        String g_data[][]={ {"19eucs001","Abiraj","10","98","100","78","56","99"}};
        String g_column[]={"ID","NAME","STD","SCIENCE","MATHS","ENGLISH","TAMIL","SOCIAL"};
        JTable g_jt=new JTable(g_data,g_column);
        g_jt.setBorder(new LineBorder(new Color(0, 0, 0)));
        g_jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        g_jt.setRowHeight(jt.getRowHeight() + 20);
        g_jt.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID","NAME","STD","SCIENCE","MATHS","ENGLISH","TAMIL","SOCIAL"},
                        {"19eucs001", "Abiraj", "10", "98", "100", "78", "56", "99", null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                        "ID", "NAME", "STD", "SCIENCE", "MATHS", "ENGLISH", "TAMIL", "SOCIAL", "New column", "New column", "New column"
                }
        ));
        g_jt.setBounds(27,277,1150,437);
        gradespanel.add(g_jt);



        studentpanel = new JPanel();
        studentpanel.setBackground(Color.white);
        studentpanel.setBounds(124, 0, 1336, 1000);
        studentpanel.setLayout(null);
        p.add(studentpanel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250,250,250));
        panel.setBounds(60, 66, 1100, 200);
        panel.setLayout(null);
        studentpanel.add(panel);

        JLabel s_text1 = new JLabel("Student Record");
        s_text1.setFont(new Font("Segoe UI", Font.BOLD, 30));
        s_text1.setBounds(80, 50, 489, 40);
        panel.add(s_text1);

        JLabel s_text2 = new JLabel("Class 10");
        s_text2.setForeground(Color.GRAY);
        s_text2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        s_text2.setBounds( 80,100, 214, 30);
        panel.add(s_text2);


        String s_data[][]={ {"19eucs001","Abiraj","10","abi@gmail.com","30-11-2001","Male","9655047766"}};
        String s_column[]={"ID","NAME","STD","EMAIL","DOB","GENDER","PHONE"};
        JTable s_jt=new JTable(s_data,s_column);
        s_jt.setModel(new DefaultTableModel(
                new Object[][] {
                        {"S.NO.","ID", "NAME", "STD", "EMAIL", "DOB", "GENDER", "PHONE"},
                                {"1","19eucs001", "Abiraj", "10", "abi@gmail.com", "30-11-2001", "Male", "9655047766"},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null},
                        {null, null, null, null, null, null, null,null}

                },
                new String[] {
                        "SNO","ID", "NAME", "STD", "EMAIL", "DOB", "GENDER", "PHONE"
                }
        ));
        s_jt.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        s_jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        s_jt.setBounds(60,312,1100,421);
        s_jt.setBackground(Color.white);
        s_jt.setRowHeight(s_jt.getRowHeight() + 20);
        studentpanel.add(s_jt);



        learningpanel = new JPanel();
        learningpanel.setBackground(Color.white);
        learningpanel.setBounds(124, 0, 1336, 777);
        learningpanel.setLayout(null);
        p.add(learningpanel);

        JPanel learn_info = new JPanel();
        learn_info.setBackground(new Color(250, 250, 250));
        learn_info.setBounds(34, 10, 1150, 134);
        learn_info.setLayout(null);
        learningpanel.add(learn_info);

        JLabel l_l1 = new JLabel("Leaning Materials & Syllabus");
        l_l1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        l_l1.setBounds(30, 26, 481, 37);
        learn_info.add(l_l1);

        JLabel l_l2 = new JLabel("Post learning materials, syllabus here !");
        l_l2.setForeground(Color.GRAY);
        l_l2.setBackground(new Color(240, 240, 240));
        l_l2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        l_l2.setBounds(30, 73, 318, 37);
        learn_info.add(l_l2);

        JPanel learn_assign_panel = new JPanel();
        learn_assign_panel.setBackground(Color.WHITE);
        learn_assign_panel.setBounds(34, 203, 1150, 530);
        learn_assign_panel.setLayout(null);
        learningpanel.add(learn_assign_panel);

        JLabel assign_text = new JLabel("Assign Here !");
        assign_text.setFont(new Font("Segoe UI", Font.BOLD, 18));
        assign_text.setBounds(47, 43, 364, 52);
        learn_assign_panel.add(assign_text);

        JButton upload_btn = new JButton("Upload");
        upload_btn.setForeground(Color.WHITE);
        upload_btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        upload_btn.setBackground(new Color(255, 127, 80));
        upload_btn.setBounds(47, 134, 275, 41);
        upload_btn.setLayout(null);
        upload_btn.setFocusPainted(false);
        upload_btn.setBorder(null);
        learn_assign_panel.add(upload_btn);

        leaveformpanel = new JPanel();
        leaveformpanel.setBackground(new Color(250,250,250));
        leaveformpanel.setBounds(124, 0, 1336, 777);
        leaveformpanel.setLayout(null);
        p.add(leaveformpanel);

        JPanel leave_info = new JPanel();
        leave_info.setBounds(24, 10, 1150, 282);
        leave_info.setBackground(new Color(255,255,255));
        leaveformpanel.add(leave_info);
        leave_info.setLayout(null);

        JLabel leave_info_text = new JLabel("Leave Apply Summary");
        leave_info_text.setFont(new Font("Segoe UI", Font.BOLD, 28));
        leave_info_text.setBounds(48, 20, 444, 55);
        leave_info.add(leave_info_text);

        JPanel total_req_panel = new JPanel();
        total_req_panel.setBackground(new Color(250, 128, 114));
        total_req_panel.setBounds(48, 102, 219, 131);
        total_req_panel.setLayout(null);
        leave_info.add(total_req_panel);

        JLabel no_of_req = new JLabel("3");
        no_of_req.setForeground(Color.WHITE);
        no_of_req.setFont(new Font("Segoe UI", Font.BOLD, 36));
        no_of_req.setBounds(100, 10, 52, 67);
        total_req_panel.add(no_of_req);

        JLabel tot_req_text = new JLabel("Total Requests");
        tot_req_text.setForeground(Color.WHITE);
        tot_req_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tot_req_text.setBounds(50, 80, 123, 30);
        total_req_panel.add(tot_req_text);

        JPanel approved_req_panel = new JPanel();
        approved_req_panel.setBackground(new Color(250, 128, 114));
        approved_req_panel.setBounds(658, 102, 219, 131);
        approved_req_panel.setLayout(null);
        leave_info.add(approved_req_panel);

        JLabel no_approved = new JLabel("2");
        no_approved.setForeground(Color.WHITE);
        no_approved.setFont(new Font("Segoe UI", Font.BOLD, 36));
        no_approved.setBounds(100, 10, 52, 67);
        approved_req_panel.add(no_approved);

        JLabel tot_approved_text = new JLabel("Approved");
        tot_approved_text.setForeground(Color.WHITE);
        tot_approved_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tot_approved_text.setBounds(70, 80, 123, 30);
        approved_req_panel.add(tot_approved_text);

        JPanel disapproved_req_panel = new JPanel();
        disapproved_req_panel.setBackground(new Color(250, 128, 114));
        disapproved_req_panel.setBounds(350, 102, 219, 131);
        disapproved_req_panel.setLayout(null);
        leave_info.add(disapproved_req_panel);

        JLabel no_disapproved = new JLabel("1");
        no_disapproved.setForeground(Color.WHITE);
        no_disapproved.setFont(new Font("Segoe UI", Font.BOLD, 36));
        no_disapproved.setBounds(100, 10, 52, 67);
        disapproved_req_panel.add(no_disapproved);

        JLabel tot_disapproved_text = new JLabel("Disapproved");
        tot_disapproved_text.setForeground(Color.WHITE);
        tot_disapproved_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tot_disapproved_text.setBounds(70, 80, 123, 30);
        disapproved_req_panel.add(tot_disapproved_text);

        JPanel leave_apply_panel = new JPanel();
        leave_apply_panel.setBackground(Color.WHITE);
        leave_apply_panel.setBounds(23, 322, 1150, 445);
        leave_apply_panel.setLayout(null);
        leaveformpanel.add(leave_apply_panel);

        JLabel label2 = new JLabel("Date:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label2.setBounds(800, 26, 100, 49);
        leave_apply_panel.add(label2);

        String country[]={"20/08/2021","21/08,2021"};
        JComboBox cb=new JComboBox(country);
        cb.setBounds(880, 26,200,40);
        cb.setBackground(Color.white);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        leave_apply_panel.add(cb);


        JLabel label1 = new JLabel("Requests for Leave");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        label1.setBounds(65, 26, 295, 49);
        leave_apply_panel.add(label1);

        JLabel s1 = new JLabel("Abiraj");
        s1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        s1.setBounds(65, 105, 228, 36);
        leave_apply_panel.add(s1);

        JLabel s2 = new JLabel("Ajai Bhalaji");
        s2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        s2.setBounds(65, 176, 197, 36);
        leave_apply_panel.add(s2);

        JLabel s3 = new JLabel("Hari Prasath");
        s3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        s3.setBounds(65, 244, 228, 49);
        leave_apply_panel.add(s3);

        JButton d1 = new JButton("Disapprove");
        d1.setForeground(Color.WHITE);
        d1.setBackground(new Color(250,69,89));
        d1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        d1.setBounds(629, 175, 138, 41);
        d1.setLayout(null);
        d1.setFocusPainted(false);
        d1.setBorder(null);
        leave_apply_panel.add(d1);

        JButton a1 = new JButton("Approve");
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        a1.setBackground(new Color(46,185,115));
        a1.setBounds(431, 171, 138, 41);
        a1.setLayout(null);
        a1.setFocusPainted(false);
        a1.setBorder(null);
        leave_apply_panel.add(a1);

        JButton a2 = new JButton("Approve");
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        a2.setBackground(new Color(46,185,115));
        a2.setBounds(431, 249, 138, 41);
        a2.setLayout(null);
        a2.setFocusPainted(false);
        a2.setBorder(null);
        leave_apply_panel.add(a2);

        JButton a3 = new JButton("Approve");
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        a3.setBackground(new Color(46,185,115));
        a3.setBounds(431, 104, 138, 41);
        a3.setLayout(null);
        a3.setFocusPainted(false);
        a3.setBorder(null);
        leave_apply_panel.add(a3);

        JButton d3 = new JButton("Disapprove");
        d3.setForeground(Color.WHITE);
        d3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        d3.setBackground(new Color(250,69,89));
        d3.setBounds(629, 105, 138, 41);
        d3.setLayout(null);
        d3.setFocusPainted(false);
        d3.setBorder(null);
        leave_apply_panel.add(d3);

        JButton d2 = new JButton("Disapprove");
        d2.setForeground(Color.WHITE);
        d2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        d2.setBackground(new Color(250,69,89));
        d2.setBounds(629, 249, 138, 41);
        d2.setLayout(null);
        d2.setFocusPainted(false);
        d2.setBorder(null);
        leave_apply_panel.add(d2);

        forumpanel = new JPanel();
        forumpanel.setBackground(Color.white);
        forumpanel.setBounds(124, 0, 1336, 777);
        forumpanel.setLayout(null);
        p.add(forumpanel);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(24, 21, 1012, 100);
        panel_2.setBackground(new Color(250,250,250));
        panel_2.setLayout(null);
        forumpanel.add(panel_2);


        JLabel forum_head = new JLabel("Respond to  Student Inquiry");
        forum_head.setFont(new Font("Segoe UI", Font.BOLD, 28));
        forum_head.setBounds(50, 20, 441, 54);
        panel_2.add(forum_head);



        JPanel forum_response_panel = new JPanel();
        forum_response_panel.setBackground(Color.WHITE);
        forum_response_panel.setBounds(39, 103, 704, 664);
        forumpanel.add(forum_response_panel);
        forum_response_panel.setLayout(null);

        JLabel forum_info_text = new JLabel("All Student Inquiries");
        forum_info_text.setBounds(50, 40, 381, 51);
        forum_info_text.setFont(new Font("Segoe UI", Font.BOLD, 24));
        forum_response_panel.add(forum_info_text);




        JLabel inq_s_id_head = new JLabel("Student ID:");
        inq_s_id_head.setFont(new Font("Segoe UI", Font.BOLD, 14));
        inq_s_id_head.setBounds(44, 113, 116, 31);
        forum_response_panel.add(inq_s_id_head);

        JLabel inq_recieved_head = new JLabel("Inquiry:");
        inq_recieved_head.setFont(new Font("Segoe UI", Font.BOLD, 14));
        inq_recieved_head.setBounds(164, 115, 89, 20);
        forum_response_panel.add(inq_recieved_head);


        JTextArea inquiry_textarea = new JTextArea();
        inquiry_textarea.setBackground(new Color(248, 248, 255));
        inquiry_textarea.setWrapStyleWord(true);
        inquiry_textarea.setRows(3);
        inquiry_textarea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        inquiry_textarea.setBounds(164, 150, 492, 163);
        forum_response_panel.add(inquiry_textarea);

        JButton respond_btn_1 = new JButton("Reply");
        respond_btn_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        respond_btn_1.setBackground(new Color(250, 128, 114));
        respond_btn_1.setForeground(Color.white);
        respond_btn_1.setBounds(164, 330, 124, 31);
        respond_btn_1.setLayout(null);
        respond_btn_1.setFocusPainted(false);
        respond_btn_1.setBorder(null);
        forum_response_panel.add(respond_btn_1);

        JLabel forum_s_id_1 = new JLabel("001");
        forum_s_id_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
        forum_s_id_1.setBounds(44, 210,45,40);
        forum_response_panel.add(forum_s_id_1);

        JTextArea inquiry_textarea_2 = new JTextArea();
        inquiry_textarea_2.setBackground(new Color(248, 248, 255));
        inquiry_textarea_2.setWrapStyleWord(true);
        inquiry_textarea_2.setRows(3);
        inquiry_textarea_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        inquiry_textarea_2.setBounds(164, 380, 492, 163);
        forum_response_panel.add(inquiry_textarea_2);

        JButton respond_btn_2 = new JButton("Reply");
        respond_btn_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        respond_btn_2.setBackground(new Color(250, 128, 114));
        respond_btn_2.setBounds(164, 550,124,31);
        respond_btn_2.setLayout(null);
        respond_btn_2.setForeground(Color.white);
        respond_btn_2.setFocusPainted(false);
        respond_btn_2.setBorder(null);
        forum_response_panel.add(respond_btn_2);

        JLabel forum_s_id_2 = new JLabel("002");
        forum_s_id_2.setFont(new Font("Segoe UI", Font.BOLD, 23));
        forum_s_id_2.setBounds(44, 450,100,30);
        forum_response_panel.add(forum_s_id_2);

        JPanel inquiry_rec_panel = new JPanel();
        inquiry_rec_panel.setBackground(new Color(255, 160, 122));
        inquiry_rec_panel.setBounds(789, 250, 237, 154);
        inquiry_rec_panel.setLayout(null);
        forumpanel.add(inquiry_rec_panel);

        JLabel no_of_inq = new JLabel("2");
        no_of_inq.setForeground(new Color(255, 255, 255));
        no_of_inq.setFont(new Font("Segoe UI", Font.BOLD, 42));
        no_of_inq.setBounds(114, 21, 43, 64);
        inquiry_rec_panel.add(no_of_inq);


        JPanel inq_responded_panel = new JPanel();
        inq_responded_panel.setBackground(new Color(255, 160, 122));
        inq_responded_panel.setBounds(789, 450, 237, 154);
        inq_responded_panel.setLayout(null);
        forumpanel.add(inq_responded_panel);

        JLabel tot_inq_text_1 = new JLabel("Total Inquiries");
        tot_inq_text_1.setBounds(60, 90, 127, 28);
        inquiry_rec_panel.add(tot_inq_text_1);
        tot_inq_text_1.setForeground(new Color(255, 255, 255));
        tot_inq_text_1.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel responded_inq = new JLabel("0");
        responded_inq.setBounds(114, 21, 45, 51);
        inq_responded_panel.add(responded_inq);
        responded_inq.setForeground(new Color(255, 255, 255));
        responded_inq.setFont(new Font("Segoe UI", Font.BOLD, 42));


        JLabel responded_inq_text = new JLabel("Inquiries Responded");
        responded_inq_text.setBounds(50, 90, 218, 28);
        inq_responded_panel.add(responded_inq_text);
        responded_inq_text.setForeground(new Color(255, 255, 255));
        responded_inq_text.setFont(new Font("Segoe UI", Font.BOLD, 16));



        payrollpanel = new JPanel();
        payrollpanel.setBackground(Color.white);
        payrollpanel.setBounds(124, 0, 1336, 777);
        payrollpanel.setLayout(null);
        p.add(payrollpanel);

        JPanel payroll_info = new JPanel();
        payroll_info.setBackground(new Color(250,250,250));
        payroll_info.setBounds(10, 21, 1150, 158);
        payroll_info.setLayout(null);
        payrollpanel.add(payroll_info);

        JLabel p_l1 = new JLabel("Hello Teacher !");
        p_l1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        p_l1.setBounds(46, 26, 340, 34);
        payroll_info.add(p_l1);

        JLabel p_l2 = new JLabel("Excited for your pay ?");
        p_l2.setForeground(Color.GRAY);
        p_l2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        p_l2.setBounds(46, 70, 252, 21);
        payroll_info.add(p_l2);

        f.setVisible( true );
        f.setLayout(null);
        f.setResizable(false);


    }



}
