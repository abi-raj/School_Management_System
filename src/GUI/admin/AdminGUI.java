package GUI.admin;

import database.AdminDBHelper;
import database.StudentDBHelper;
import database.TeacherDBHelper;
import models.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


public class AdminGUI extends JFrame {

    TeacherDBHelper teacherDBHelper = new TeacherDBHelper();
    JComboBox<String> cb_2;
    JComboBox<String> cb;
    JComboBox<String> std;
    JPanel contentPane;
    JPanel homepanel,p;
    JPanel notification_panel;
    JPanel exampanel;
    //JPanel leaveformpanel;
    JPanel teacherpanel;
//    JPanel learningpanel;
   // JPanel forumpanel;
    JPanel payrollpanel;
    JPanel total_studentspanel;
    JPanel total_teacherspanel;
    JTextField Title_text,Start_text,End_Text,viewStart,viewEnd,txt_Toaddr,txtSubject,txt_event_Title;
    JTextArea txt_Body,txt_desc;
    JPanel select_ToOptionpanel;
    JLabel performance_lbl,pay_calculatedlbl;
    ButtonGroup bg=new ButtonGroup();
    JRadioButton specific_radiobtn,Toall_radiobtn,rdbtnToAllTeachers,rdbtnBoth;
    ArrayList<Forum> inquiries;
    String[][] teacherRecordArray;
    JComboBox<String> f_id_cb;
    ArrayList<Exam> alExams = new ArrayList<>();
    AdminDBHelper adminDBHelper = new AdminDBHelper();
    Teacher teacher = null;
    Attendance attendance = null;
    Color BG_COLOR = new Color(176, 0, 32);
    Color BG_GREEN = new Color(11, 138, 62);
    Color BG_BLUE = new Color(28, 133, 232);
    JList<String> a = new JList<>();
    private JTextField a_stu_name;
    private JTextField a_student_date;


    public AdminGUI(Teacher teacher) {
        this.teacher = teacher;
        //setTeacher(email);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1336, 814);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        addTeacherRecords();

         p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        contentPane.add(p);

        JPanel sidebar = new JPanel();
        sidebar.setBackground(BG_COLOR);
        sidebar.setBounds(0, 0, 120, 814);
        p.add(sidebar);
        sidebar.setLayout(null);

        UIManager.put("ToolTip.background", new Color(253, 253, 150));


        JButton home = new JButton();
        home.setBounds(41, 85, 43, 63);
        home.setToolTipText("Home");
        home.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/home profile.png"))));
        home.setBackground(BG_COLOR);
        home.setLayout(null);
        home.setFocusPainted(false);
        home.setBorder(null);
        sidebar.add(home);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(true);
                notification_panel.setVisible(false);
                exampanel.setVisible(false);
                //leaveformpanel.setVisible(false);
                teacherpanel.setVisible(false);
                //learningpanel.setVisible(false);
                //forumpanel.setVisible(false);
                payrollpanel.setVisible(false);

            }
        });

        JButton mail = new JButton();
        mail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(false);
                notification_panel.setVisible(true);
                exampanel.setVisible(false);
                //leaveformpanel.setVisible(false);
                teacherpanel.setVisible(false);
                //learningpanel.setVisible(false);
                //forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }

        });
        mail.setBounds(41, 340, 45, 70);
        mail.setToolTipText("Mail");
        mail.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("../icons/mail.png")))));
        mail.setForeground(Color.white);
        mail.setBackground(BG_COLOR);
        mail.setLayout(null);
        mail.setFocusPainted(false);
        mail.setBorder(null);
        sidebar.add(mail);

        JButton exams = new JButton();
        exams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                notification_panel.setVisible(false);
                exampanel.setVisible(true);
                //leaveformpanel.setVisible(false);
                teacherpanel.setVisible(false);
                //learningpanel.setVisible(false);
                //forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }
        });
        exams.setBounds(39, 475, 45, 56);
        exams.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/grade.png"))));
        exams.setBackground(BG_COLOR);
        exams.setLayout(null);
        exams.setFocusPainted(false);
        exams.setBorder(null);
        exams.setToolTipText("Exam Info");
        sidebar.add(exams);

        JButton student = new JButton();
        student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTeacherRecords();
                homepanel.setVisible(false);
                notification_panel.setVisible(false);
                exampanel.setVisible(false);
                //leaveformpanel.setVisible(false);
                teacherpanel.setVisible(true);
                //learningpanel.setVisible(false);
                //forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }
        });
        student.setBounds(39, 220, 45, 47);
        student.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/student.png"))));
        student.setLayout(null);
        student.setFocusPainted(false);
        student.setBorder(null);
        student.setBackground(BG_COLOR);
        student.setToolTipText("Teacher Details\r\n");
        sidebar.add(student);

//        JButton leaveform = new JButton();
//        leaveform.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//
//                homepanel.setVisible(false);
//                notification_panel.setVisible(false);
//                exampanel.setVisible(false);
//               // leaveformpanel.setVisible(true);
//                teacherpanel.setVisible(false);
//                //learningpanel.setVisible(false);
//               /// forumpanel.setVisible(false);
//                payrollpanel.setVisible(false);
//            }
//
//        });
//        leaveform.setToolTipText("Leave Form");
//        leaveform.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/leave.png"))));
//        leaveform.setLayout(null);
//        leaveform.setBackground(BG_COLOR);
//        leaveform.setFocusPainted(false);
//        leaveform.setBorder(null);
//        leaveform.setBounds(41, 475, 45, 56);
//        sidebar.add(leaveform);
//
////        JButton inquiry = new JButton("");
////        inquiry.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent arg0) {
//                homepanel.setVisible(false);
//                notification_panel.setVisible(false);
//                exampanel.setVisible(false);
//                //leaveformpanel.setVisible(false);
//                teacherpanel.setVisible(false);
//                //learningpanel.setVisible(false);
//                //forumpanel.setVisible(true);
//                payrollpanel.setVisible(false);
//            }
//        });
//        inquiry.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/chat icon.png"))));
//        inquiry.setToolTipText("Inquiry Forum");
//        inquiry.setBackground(BG_COLOR);
//        inquiry.setLayout(null);
//        inquiry.setFocusPainted(false);
//        inquiry.setBorder(null);
//        inquiry.setBounds(39, 566, 45, 47);
//        sidebar.add(inquiry);

//        JButton learning = new JButton();
//        learning.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                homepanel.setVisible(false);
//                notification_panel.setVisible(false);
//                exampanel.setVisible(false);
//                //leaveformpanel.setVisible(false);
//                teacherpanel.setVisible(false);
//                //learningpanel.setVisible(true);
//                //forumpanel.setVisible(false);
//                payrollpanel.setVisible(false);
//            }
//        });
//        learning.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/learning.png"))));
//        learning.setToolTipText("Learning Materials");
//        learning.setBackground(BG_COLOR);
//        learning.setLayout(null);
//        learning.setFocusPainted(false);
//        learning.setBorder(null);
//        learning.setBounds(39, 389, 45, 63);
//        sidebar.add(learning);


        homepanel = new JPanel();
        homepanel.setBounds(124, 0, 1336, 1000);
        homepanel.setBackground(Color.WHITE);
        homepanel.setLayout(null);
        p.add(homepanel);
        dashboardComponents();
        examComponents();
        mailComponents();
        payrollComponents();



//        JLabel teacher_name = new JLabel("Teacher Name");
//        teacher_name.setBounds(400, 271, 300, 40);
//        teacher_name.setFont(new Font("Segoe UI", Font.BOLD, 36));
//        teacher_name.setForeground(new Color(102, 102, 102));
//        teacher_name.setText(teacher.getName());
//        homepanel.add(teacher_name);


//        JLabel teacher_email = new JLabel("emailaddress@schoolname.com");
//        teacher_email.setBounds(400, 321, 300, 40);
//        teacher_email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        teacher_email.setForeground(new Color(102, 102, 102));
//        teacher_email.setText(teacher.getEmail());
//        homepanel.add(teacher_email);


//        JLabel teacher_phone = new JLabel("9876543210");
//        teacher_phone.setBounds(400, 371, 300, 40);
//        teacher_phone.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        teacher_phone.setForeground(new Color(102, 102, 102));
//        teacher_phone.setText(teacher.getPhone());
//        homepanel.add(teacher_phone);


//        JLabel teacher_work_exp = new JLabel("5 years work experience");
//        teacher_work_exp.setBounds(400, 421, 300, 40);
//        teacher_work_exp.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        teacher_work_exp.setForeground(new Color(102, 102, 102));
//        teacher_work_exp.setText(teacher.getExperience() + " years work experience");
//        homepanel.add(teacher_work_exp);


//        JLabel teacher_profile = new JLabel();
//        teacher_profile.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/avatar.png"))));
//        teacher_profile.setBounds(100, 230, 300, 281);
//        teacher_profile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        teacher_profile.setForeground(new Color(102, 102, 102));
//        homepanel.add(teacher_profile);

//        JLabel logout_img = new JLabel();
//        logout_img.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/logout.png"))));
//        logout_img.setBounds(100, 650, 30, 40);
//        homepanel.add(logout_img);


//        JButton logout_button = new JButton("Log out");
//        logout_button.setBounds(115, 650, 100, 40);
//        logout_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        logout_button.setForeground(new Color(255, 98, 98));
//        logout_button.setForeground(new Color(255, 98, 98));
//        logout_button.setLayout(null);
//        logout_button.setBackground(Color.WHITE);
//        logout_button.setBorder(null);
//        logout_button.setFocusPainted(false);
//        Font font = logout_button.getFont();
//        Map attributes = font.getAttributes();
//        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//        logout_button.setFont(font.deriveFont(attributes));
//        homepanel.add(logout_button);
//        logout_button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int logout_result = JOptionPane.showConfirmDialog(p, "Are you sure want to Logout?", "",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE);
//                if (logout_result == JOptionPane.YES_OPTION) {
//                    dispose();
//                    new LoginGUI();
//                } else if (logout_result == JOptionPane.NO_OPTION) {
//                } else {
//
//                }
//            }
//        });





//        JButton schedule_events_button = new JButton("View Important Schedules & Events");
//        schedule_events_button.setLayout(null);
//        schedule_events_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        schedule_events_button.setForeground(Color.WHITE);
//        schedule_events_button.setBackground(BG_COLOR);
//        schedule_events_button.setBounds(800, 230, 350, 70);
//        schedule_events_button.setFocusPainted(false);
//        schedule_events_button.setBorder(null);
//        schedule_events_button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new EventsGUI();
//
//            }
//        });

//        homepanel.add(schedule_events_button);
//
//        JLabel class_text_lbl = new JLabel("Class Summary");
//        class_text_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
//        class_text_lbl.setForeground(Color.BLACK);
//        class_text_lbl.setBounds(800, 350, 300, 50);
//        homepanel.add(class_text_lbl);

//
//        JLabel class_name_lbl = new JLabel("Class 10", SwingConstants.CENTER);
//        class_name_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
//        class_name_lbl.setForeground(Color.BLACK);
//        class_name_lbl.setBounds(800, 410, 350, 50);
//        Border blackline = BorderFactory.createLineBorder(Color.black);
//        class_name_lbl.setBorder(blackline);
//        class_name_lbl.setText("Class " + teacher.gettClass());
//        homepanel.add(class_name_lbl);


//        JPanel class_summary_table = new JPanel();
//        class_summary_table.setBounds(800, 480, 350, 200);
//        class_summary_table.setLayout(null);
//        class_summary_table.setBackground(new Color(255, 109, 106));
//        homepanel.add(class_summary_table);

//        JTextArea tot_student_text = new JTextArea("Total Students in your Class        ...");
//        tot_student_text.setBounds(20, 20, 300, 50);
//        tot_student_text.setLineWrap(true);
//        tot_student_text.setWrapStyleWord(true);
//        tot_student_text.setForeground(Color.white);
//        tot_student_text.setBackground(new Color(255, 109, 106));
//        tot_student_text.setFont(new Font("Segoe UI", Font.BOLD, 20));
//        class_summary_table.add(tot_student_text);
//
//        JLabel tot_students = new JLabel("54");
//        tot_students.setBounds(20, 80, 100, 80);
//        tot_students.setFont(new Font("Segoe UI", Font.BOLD, 80));
//        tot_students.setForeground(Color.white);
//        tot_students.setText(teacherDB.totalStudents(teacher.gettClass()));
//        class_summary_table.add(tot_students);



//        JLabel a_student = new JLabel("Student ID:");
//        a_student.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        a_student.setBounds(70, 114, 279, 31);
//        notification.add(a_student);
//
//        String s_id[] = {"001", "002", "003", "004"};
//        JComboBox a_stu_id = new JComboBox(s_id);
//        a_stu_id.setBounds(70, 164, 200, 47);
//        a_stu_id.setBackground(Color.white);
//        a_stu_id.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        notification.add(a_stu_id);
//
//        JLabel a_date = new JLabel("Date:");
//        a_date.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        a_date.setBounds(350, 114, 100, 30);
//        notification.add(a_date);
//
//
//        JTextField a_student_date = new JTextField();
//        a_student_date.setBounds(350, 164, 200, 47);
//        notification.add(a_student_date);
//        a_student_date.setMargin(new Insets(5, 10, 5, 5));
//        a_student_date.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        a_student_date.setColumns(10);
//
//        JLabel a_mark_p_or_ab = new JLabel("Mark Present/Absent:");
//        a_mark_p_or_ab.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        a_mark_p_or_ab.setBounds(600, 114, 300, 30);
//        notification.add(a_mark_p_or_ab);
//
//        JRadioButton present = new JRadioButton("Present");
//        JRadioButton absent = new JRadioButton("Absent");
//        present.setBounds(600, 164, 100, 50);
//        absent.setBounds(730, 164, 100, 50);
//        present.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        present.setBorder(null);
//        absent.setBorder(null);
//        present.setBackground(Color.WHITE);
//        absent.setBackground(Color.WHITE);
//        absent.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(present);
//        bg.add(absent);
//        notification.add(present);
//        notification.add(absent);
//
//
//        JButton updatebutton = new JButton("Update");
//        updatebutton.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        updatebutton.setForeground(Color.WHITE);
//        updatebutton.setBackground(new Color(255, 160, 122));
//        updatebutton.setBounds(70, 250, 100, 40);
//        updatebutton.setLayout(null);
//        updatebutton.setFocusPainted(false);
//        updatebutton.setBorder(null);
//        updatebutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        notification.add(updatebutton);
//
//
//        String data[][] = {{"001", "Aisha", "P"},
//                {"102", "Jay", "P"},
//                {"101", "Steafn", "A"}};
//        String column[] = {"ID", "NAME", "P/A"};
//        JTable jt = new JTable(data, column);
//        jt.setModel(new DefaultTableModel(
//                new Object[][]{
//                        {"ID", "NAME", "P/A"},
//                        {"001", "Aisha", "P"},
//                        {"102", "Jay", "P"},
//                        {"101", "Stefan", "A"},
//                        {null, null, null},
//                        {null, null, null},
//                        {null, null, null},
//                        {null, null, null},
//                        {null, null, null},
//                        {null, null, null},
//
//
//                },
//                new String[]{
//                        "ID", "NAME", "P/A"
//                }
//        ));
//        jt.setRowHeight(jt.getRowHeight() + 20);
//        jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//        jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//        jt.setBounds(40, 400, 1100, 350);
//        notification_panel.add(jt);



//
//        JLabel g_l2 = new JLabel("Edit, update and assign student grades here!");
//        g_l2.setForeground(Color.GRAY);
//        g_l2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//        g_l2.setBounds(57, 84, 398, 33);
//        grade_info.add(g_l2);
//
//        JLabel exam_name_lbl = new JLabel("Examination Name:");
//        exam_name_lbl.setBounds(24, 200, 200, 40);
//        exam_name_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(exam_name_lbl);
//
//        String exam_name[] = {"Quarterly Exam", "Half Yearly Exam"};
//        JComboBox grades_exam_name_cb = new JComboBox(exam_name);
//        grades_exam_name_cb.setBounds(220, 200, 200, 40);
//        grades_exam_name_cb.setBackground(Color.white);
//        grades_exam_name_cb.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        gradespanel.add(grades_exam_name_cb);
//
//        JLabel student_id_lbl = new JLabel("Student ID:");
//        student_id_lbl.setBounds(460, 200, 200, 40);
//        student_id_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(student_id_lbl);

//        String grade_student_id[] = {"001", "002", "003", "004"};
//        JComboBox grade_student_id_cb = new JComboBox(grade_student_id);
//        grade_student_id_cb.setBounds(580, 200, 200, 40);
//        grade_student_id_cb.setBackground(Color.white);
//        grade_student_id_cb.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        gradespanel.add(grade_student_id_cb);
//
//        JLabel subject_name_lbl = new JLabel("S.no.   Subject Name                   Grades");
//        subject_name_lbl.setBounds(24, 350, 500, 40);
//        subject_name_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(subject_name_lbl);
//
//        JSeparator s = new JSeparator();
//        s.setOrientation(SwingConstants.HORIZONTAL);
//        s.setForeground(Color.BLACK);
//        s.setBounds(24, 400, 500, 40);
//        gradespanel.add(s);
//
//        JLabel sub_name_science_lbl = new JLabel("1.         Science :");
//        sub_name_science_lbl.setBounds(24, 430, 200, 40);
//        sub_name_science_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(sub_name_science_lbl);
//
//        JTextField t_sub_name_science = new JTextField();
//        t_sub_name_science.setBounds(220, 430, 200, 40);
//        t_sub_name_science.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        t_sub_name_science.setMargin(new Insets(10, 10, 10, 10));
//        gradespanel.add(t_sub_name_science);
//
//
//        JLabel sub_name_maths_lbl = new JLabel("2.          Maths :");
//        sub_name_maths_lbl.setBounds(24, 500, 200, 40);
//        sub_name_maths_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(sub_name_maths_lbl);
//
//        JTextField t_sub_name_maths = new JTextField();
//        t_sub_name_maths.setBounds(220, 500, 200, 40);
//        t_sub_name_maths.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        t_sub_name_maths.setMargin(new Insets(10, 10, 10, 10));
//        gradespanel.add(t_sub_name_maths);
//
//
//        JLabel sub_name_social_lbl = new JLabel("3.          Social :");
//        sub_name_social_lbl.setBounds(24, 570, 200, 40);
//        sub_name_social_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(sub_name_social_lbl);
//
//        JTextField t_sub_name_social = new JTextField();
//        t_sub_name_social.setBounds(220, 570, 200, 40);
//        t_sub_name_social.setMargin(new Insets(10, 10, 10, 10));
//        t_sub_name_social.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        gradespanel.add(t_sub_name_social);
//
//        JButton assign_grades_btn = new JButton("Assign Grade");
//        assign_grades_btn.setBounds(94, 670, 200, 40);
//        assign_grades_btn.setForeground(Color.white);
//        assign_grades_btn.setBackground(new Color(252, 132, 116));
//        assign_grades_btn.setLayout(null);
//        assign_grades_btn.setFocusPainted(false);
//        assign_grades_btn.setBorder(null);
//        assign_grades_btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        gradespanel.add(assign_grades_btn);


        teacherpanel = new JPanel();
        teacherpanel.setBackground(Color.white);
        teacherpanel.setBounds(124, 0, 1336, 1000);
        teacherpanel.setLayout(null);
        p.add(teacherpanel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 250, 250));
        panel.setBounds(60, 66, 1100, 200);
        panel.setLayout(null);
        teacherpanel.add(panel);

        JLabel s_text1 = new JLabel("Teachers Record");
        s_text1.setFont(new Font("Segoe UI", Font.BOLD, 30));
        s_text1.setBounds(50, 50, 489, 40);
        panel.add(s_text1);

        JButton addTeacherButton = new JButton("Add");

        addTeacherButton.setLayout(null);
        addTeacherButton.setFocusPainted(false);
        addTeacherButton.setBorder(null);
        addTeacherButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        addTeacherButton.setBounds(50, 120, 100, 35);
        addTeacherButton.setBackground(BG_GREEN);
        addTeacherButton.setForeground(Color.white);
        panel.add(addTeacherButton);
        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTeacher();
            }
        });

        JButton editTeacher = new JButton("Edit");

        editTeacher.setLayout(null);
        editTeacher.setFocusPainted(false);
        editTeacher.setBorder(null);
        editTeacher.setFont(new Font("Segoe UI", Font.BOLD, 15));
        editTeacher.setBounds(200, 120, 100, 35);
        editTeacher.setBackground(BG_BLUE);
        editTeacher.setForeground(Color.white);
        panel.add(editTeacher);
        editTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModTeacher();
            }
        });

        String[] s_column = {"S.NO", "ID", "NAME", "CLASS", "EMAIL", "EXP", "PHONE", "SALARY"};
        JTable s_jt = new JTable(teacherRecordArray, s_column);

        s_jt.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        s_jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        s_jt.setBounds(60, 312, 1100, 421);
        s_jt.setBackground(Color.white);
        s_jt.setRowHeight(s_jt.getRowHeight() + 20);
        teacherpanel.add(s_jt);


//        learningpanel = new JPanel();
//        learningpanel.setBackground(Color.white);
//        learningpanel.setBounds(124, 0, 1336, 777);
//        learningpanel.setLayout(null);
//        p.add(learningpanel);
//
//        JPanel learn_info = new JPanel();
//        learn_info.setBackground(new Color(250, 250, 250));
//        learn_info.setBounds(34, 10, 1150, 134);
//        learn_info.setLayout(null);
//        learningpanel.add(learn_info);
//
//        JLabel l_l1 = new JLabel("Learning Materials & Syllabus");
//        l_l1.setFont(new Font("Segoe UI", Font.BOLD, 32));
//        l_l1.setBounds(30, 26, 481, 37);
//        learn_info.add(l_l1);
//
//        JLabel l_l2 = new JLabel("Post learning materials, syllabus here !");
//        l_l2.setForeground(Color.GRAY);
//        l_l2.setBackground(new Color(240, 240, 240));
//        l_l2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//        l_l2.setBounds(30, 73, 318, 37);
//        learn_info.add(l_l2);
//
//        JPanel learn_assign_panel = new JPanel();
//        learn_assign_panel.setBackground(Color.WHITE);
//        learn_assign_panel.setBounds(34, 203, 1150, 530);
//        learn_assign_panel.setLayout(null);
//        learningpanel.add(learn_assign_panel);
//
//        JLabel assign_text = new JLabel("Assign Here !");
//        assign_text.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        assign_text.setBounds(47, 43, 364, 52);
//        learn_assign_panel.add(assign_text);
//
//        JButton upload_btn = new JButton("Upload");
//        upload_btn.setForeground(Color.WHITE);
//        upload_btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        upload_btn.setBackground(new Color(255, 127, 80));
//        upload_btn.setBounds(47, 134, 275, 41);
//        upload_btn.setLayout(null);
//        upload_btn.setFocusPainted(false);
//        upload_btn.setBorder(null);
//        learn_assign_panel.add(upload_btn);
//
//        leaveformpanel = new JPanel();
//        leaveformpanel.setBackground(new Color(250, 250, 250));
//        leaveformpanel.setBounds(124, 0, 1336, 777);
//        leaveformpanel.setLayout(null);
//        p.add(leaveformpanel);
//
//
//        JPanel leave_info = new JPanel();
//        leave_info.setBounds(24, 10, 1150, 282);
//        leave_info.setBackground(new Color(255, 255, 255));
//        leaveformpanel.add(leave_info);
//        leave_info.setLayout(null);
//
//        JLabel leave_info_text = new JLabel("Leave Apply Summary");
//        leave_info_text.setFont(new Font("Segoe UI", Font.BOLD, 28));
//        leave_info_text.setBounds(48, 20, 444, 55);
//        leave_info.add(leave_info_text);
//
//        JPanel total_req_panel = new JPanel();
//        total_req_panel.setBackground(new Color(250, 128, 114));
//        total_req_panel.setBounds(48, 102, 219, 131);
//        total_req_panel.setLayout(null);
//        leave_info.add(total_req_panel);
//
//        JLabel no_of_req = new JLabel("3");
//        no_of_req.setForeground(Color.WHITE);
//        no_of_req.setFont(new Font("Segoe UI", Font.BOLD, 36));
//        no_of_req.setBounds(100, 10, 52, 67);
//        total_req_panel.add(no_of_req);
//
//        JLabel tot_req_text = new JLabel("Total Requests");
//        tot_req_text.setForeground(Color.WHITE);
//        tot_req_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        tot_req_text.setBounds(50, 80, 123, 30);
//        total_req_panel.add(tot_req_text);
//
//        JPanel approved_req_panel = new JPanel();
//        approved_req_panel.setBackground(new Color(250, 128, 114));
//        approved_req_panel.setBounds(658, 102, 219, 131);
//        approved_req_panel.setLayout(null);
//        leave_info.add(approved_req_panel);
//
//        JLabel no_approved = new JLabel("2");
//        no_approved.setForeground(Color.WHITE);
//        no_approved.setFont(new Font("Segoe UI", Font.BOLD, 36));
//        no_approved.setBounds(100, 10, 52, 67);
//        approved_req_panel.add(no_approved);
//
//        JLabel tot_approved_text = new JLabel("Approved");
//        tot_approved_text.setForeground(Color.WHITE);
//        tot_approved_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        tot_approved_text.setBounds(70, 80, 123, 30);
//        approved_req_panel.add(tot_approved_text);
//
//        JPanel disapproved_req_panel = new JPanel();
//        disapproved_req_panel.setBackground(new Color(250, 128, 114));
//        disapproved_req_panel.setBounds(350, 102, 219, 131);
//        disapproved_req_panel.setLayout(null);
//        leave_info.add(disapproved_req_panel);
//
//        JLabel no_disapproved = new JLabel("1");
//        no_disapproved.setForeground(Color.WHITE);
//        no_disapproved.setFont(new Font("Segoe UI", Font.BOLD, 36));
//        no_disapproved.setBounds(100, 10, 52, 67);
//        disapproved_req_panel.add(no_disapproved);
//
//        JLabel tot_disapproved_text = new JLabel("Disapproved");
//        tot_disapproved_text.setForeground(Color.WHITE);
//        tot_disapproved_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        tot_disapproved_text.setBounds(70, 80, 123, 30);
//        disapproved_req_panel.add(tot_disapproved_text);
//
//        JPanel leave_apply_panel = new JPanel();
//        leave_apply_panel.setBackground(Color.WHITE);
//        leave_apply_panel.setBounds(23, 322, 1150, 445);
//        leave_apply_panel.setLayout(null);
//        leaveformpanel.add(leave_apply_panel);
//
//        JLabel label2 = new JLabel("Student ID");
//        label2.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        label2.setBounds(65, 100, 100, 49);
//        leave_apply_panel.add(label2);
//
////        String s_id[]={"001","002","003","004"};
//        cb = new JComboBox<String>();
//        cb.setBounds(65, 150, 200, 40);
//        cb.setBackground(Color.white);
//        cb.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        leave_apply_panel.add(cb);
//
//        JLabel label3 = new JLabel("Date");
//        label3.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        label3.setBounds(300, 100, 100, 49);
//        leave_apply_panel.add(label3);
//
////        String l_date[]={"21/08/2021","22/08/2021"};
//        cb_2 = new JComboBox<String>();
//        cb_2.setBounds(300, 150, 200, 40);
//        cb_2.setBackground(Color.white);
//        cb_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        leave_apply_panel.add(cb_2);
//        cb_2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index = cb_2.getSelectedIndex();
//                if (index != -1) {
//                    setStudentsLeave(cb_2.getItemAt(index));
//                }
//            }
//        });
//
//        JButton leave_req_view_btn = new JButton("View Leave Request");
//        leave_req_view_btn.setBounds(65, 220, 200, 40);
//        leave_req_view_btn.setForeground(Color.WHITE);
//        leave_req_view_btn.setBackground(new Color(150, 200, 255));
//        leave_req_view_btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        leave_req_view_btn.setLayout(null);
//        leave_req_view_btn.setFocusPainted(false);
//        leave_req_view_btn.setBorder(null);
//        leave_apply_panel.add(leave_req_view_btn);
//        JTextArea leave_req_ta = new JTextArea();
//        leave_req_view_btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index1 = cb.getSelectedIndex();
//                int index2 = cb_2.getSelectedIndex();
//                if (index1 != -1 && index2 != -1) {
//                    StudentDBHelper studentDBHelper = new StudentDBHelper();
//                    Leave leave = studentDBHelper.getSingleLeave(cb.getItemAt(index1), cb_2.getItemAt(index2));
//                    leave_req_ta.setText(leave.getReason());
//                }
//            }
//        });
//
//
//        leave_req_ta.setBounds(600, 100, 500, 200);
//        leave_req_ta.setMargin(new Insets(10, 10, 10, 10));
//        leave_req_ta.setBackground(new Color(240, 240, 240));
//        leave_req_ta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
//        leave_apply_panel.add(leave_req_ta);
//
//        JLabel label1 = new JLabel("Requests for Leave");
//        label1.setFont(new Font("Segoe UI", Font.BOLD, 28));
//        label1.setBounds(65, 26, 295, 49);
//        leave_apply_panel.add(label1);
//
//
//        JButton d1 = new JButton("Disapprove");
//        d1.setForeground(Color.WHITE);
//        d1.setBackground(new Color(250, 69, 89));
//        d1.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        d1.setBounds(750, 320, 138, 41);
//        d1.setLayout(null);
//        d1.setFocusPainted(false);
//        d1.setBorder(null);
//        leave_apply_panel.add(d1);
//
//        JButton a1 = new JButton("Approve");
//        a1.setForeground(Color.WHITE);
//        a1.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        a1.setBackground(new Color(46, 185, 115));
//        a1.setBounds(600, 320, 138, 41);
//        a1.setLayout(null);
//        a1.setFocusPainted(false);
//        a1.setBorder(null);
//        leave_apply_panel.add(a1);
//
//        a1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index1 = cb.getSelectedIndex();
//                int index2 = cb_2.getSelectedIndex();
//                if (index1 != -1 && index2 != -1) {
//                    StudentDBHelper studentDBHelper = new StudentDBHelper();
//                    Leave leave = studentDBHelper.getSingleLeave(cb.getItemAt(index1), cb_2.getItemAt(index2));
//                    teacherDBHelper.approveLeave(leave);
//                    leave_req_ta.setText("");
//                    setLeaveDates();
//
//                    //Clear Text functions
//                }
//            }
//        });
//        d1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index1 = cb.getSelectedIndex();
//                int index2 = cb_2.getSelectedIndex();
//                if (index1 != -1 && index2 != -1) {
//                    StudentDBHelper studentDBHelper = new StudentDBHelper();
//                    Leave leave = studentDBHelper.getSingleLeave(cb.getItemAt(index1), cb_2.getItemAt(index2));
//                    teacherDBHelper.RejectLeave(leave);
//                    leave_req_ta.setText("");
//                    setLeaveDates();
//                }
//            }
//        });
//
//        forumpanel = new JPanel();
//        forumpanel.setBackground(Color.white);
//        forumpanel.setBounds(124, 0, 1336, 777);
//        forumpanel.setLayout(null);
//        p.add(forumpanel);
//
//        JPanel panel_2 = new JPanel();
//        panel_2.setBounds(24, 21, 1100, 130);
//        panel_2.setBackground(new Color(250, 250, 250));
//        panel_2.setLayout(null);
//        forumpanel.add(panel_2);
//
//
//        JLabel forum_head = new JLabel("Respond to  Student Inquiry");
//        forum_head.setFont(new Font("Segoe UI", Font.BOLD, 28));
//        forum_head.setBounds(24, 10, 441, 54);
//        panel_2.add(forum_head);
//
//        JLabel forum_subhead = new JLabel("Dear Teacher!Manage Student Inquiries here.");
//        forum_subhead.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//        forum_subhead.setBounds(24, 50, 441, 54);
//        forum_subhead.setForeground(Color.GRAY);
//        panel_2.add(forum_subhead);
//
//
//        JPanel forum_response_panel = new JPanel();
//        forum_response_panel.setBackground(Color.WHITE);
//        forum_response_panel.setBounds(39, 103, 704, 664);
//        forumpanel.add(forum_response_panel);
//        forum_response_panel.setLayout(null);
//
//        JLabel forum_info_text = new JLabel("All Student Inquiries");
//        forum_info_text.setBounds(14, 80, 381, 40);
//        forum_info_text.setFont(new Font("Segoe UI", Font.BOLD, 24));
//        forum_response_panel.add(forum_info_text);
//
//
//        JLabel inq_s_id_head = new JLabel("Student ID:");
//        inq_s_id_head.setFont(new Font("Segoe UI", Font.BOLD, 17));
//        inq_s_id_head.setBounds(400, 150, 116, 31);
//        forum_response_panel.add(inq_s_id_head);
//
//        JTextField t_inq_s_id = new JTextField();
//        t_inq_s_id.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        t_inq_s_id.setBounds(510, 150, 50, 40);
//        forum_response_panel.add(t_inq_s_id);
//
//
//        JLabel inq_recieved_head = new JLabel("Inquiry ID:");
//        inq_recieved_head.setFont(new Font("Segoe UI", Font.BOLD, 17));
//        inq_recieved_head.setBounds(14, 155, 89, 20);
//        forum_response_panel.add(inq_recieved_head);
//
//
//        f_id_cb = new JComboBox<String>();
//        f_id_cb.setBounds(120, 150, 100, 40);
//        f_id_cb.setBackground(Color.white);
//        f_id_cb.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        forum_response_panel.add(f_id_cb);
//
//
//        JTextArea inquiry_textarea = new JTextArea();
//        inquiry_textarea.setBackground(new Color(240, 240, 255));
//        inquiry_textarea.setWrapStyleWord(true);
//        inquiry_textarea.setRows(3);
//        inquiry_textarea.setMargin(new Insets(10, 15, 10, 10));
//        inquiry_textarea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        inquiry_textarea.setBounds(14, 220, 540, 163);
//        forum_response_panel.add(inquiry_textarea);
//
//
//        JTextArea inquiry_textarea_2 = new JTextArea("Respond to Inquiry here....");
//        inquiry_textarea_2.setBackground(new Color(240, 240, 255));
//        inquiry_textarea_2.setWrapStyleWord(true);
//        inquiry_textarea_2.setRows(3);
//        inquiry_textarea_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        inquiry_textarea_2.setForeground(Color.gray);
//        inquiry_textarea_2.setMargin(new Insets(10, 15, 10, 10));
//        inquiry_textarea_2.setBounds(14, 420, 540, 163);
//        forum_response_panel.add(inquiry_textarea_2);
//
//        JButton respond_btn_2 = new JButton("Submit Response");
//        respond_btn_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        respond_btn_2.setBackground(new Color(250, 128, 114));
//        respond_btn_2.setBounds(14, 600, 200, 40);
//        respond_btn_2.setLayout(null);
//        respond_btn_2.setForeground(Color.white);
//        respond_btn_2.setFocusPainted(false);
//        respond_btn_2.setBorder(null);
//        forum_response_panel.add(respond_btn_2);
//        f_id_cb.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        int index1 = f_id_cb.getSelectedIndex();
//                        if (index1 != -1) {
//                            Forum forum = inquiries.get(index1);
//                            t_inq_s_id.setText(forum.getStudent_id());
//                            inquiry_textarea.setText(forum.getDescription());
//                            inquiry_textarea.setEditable(false);
//
//                        }
//                    }
//                }
//        );
//        respond_btn_2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index = f_id_cb.getSelectedIndex();
//                if (inquiry_textarea_2.getText().length() < 1) {
//                    JOptionPane.showMessageDialog(AdminGUI.this, "Please Enter Something");
//                } else if (index != -1) {
//                    Forum forum = inquiries.get(index);
//                    forum.setResponse(inquiry_textarea_2.getText());
//                    teacherDBHelper.replyQuestion(forum);
//                    setInquiries();
//                    JOptionPane.showMessageDialog(AdminGUI.this, "Replied!");
//                    inquiry_textarea_2.setText("");
//                }
//            }
//        });
//        JPanel inquiry_rec_panel = new JPanel();
//        inquiry_rec_panel.setBackground(new Color(255, 160, 122));
//        inquiry_rec_panel.setBounds(789, 250, 237, 154);
//        inquiry_rec_panel.setLayout(null);
//        forumpanel.add(inquiry_rec_panel);
//
//        JLabel no_of_inq = new JLabel("2");
//        no_of_inq.setForeground(new Color(255, 255, 255));
//        no_of_inq.setFont(new Font("Segoe UI", Font.BOLD, 42));
//        no_of_inq.setBounds(114, 21, 43, 64);
//        inquiry_rec_panel.add(no_of_inq);
//
//
//        JPanel inq_responded_panel = new JPanel();
//        inq_responded_panel.setBackground(new Color(255, 160, 122));
//        inq_responded_panel.setBounds(789, 450, 237, 154);
//        inq_responded_panel.setLayout(null);
//        forumpanel.add(inq_responded_panel);
//
//        JLabel tot_inq_text_1 = new JLabel("Total Inquiries");
//        tot_inq_text_1.setBounds(60, 90, 127, 28);
//        inquiry_rec_panel.add(tot_inq_text_1);
//        tot_inq_text_1.setForeground(new Color(255, 255, 255));
//        tot_inq_text_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
//
//        JLabel responded_inq = new JLabel("0");
//        responded_inq.setBounds(114, 21, 45, 51);
//        inq_responded_panel.add(responded_inq);
//        responded_inq.setForeground(new Color(255, 255, 255));
//        responded_inq.setFont(new Font("Segoe UI", Font.BOLD, 42));
//
//
//        JLabel responded_inq_text = new JLabel("Inquiries Responded");
//        responded_inq_text.setBounds(50, 90, 218, 28);
//        inq_responded_panel.add(responded_inq_text);
//        responded_inq_text.setForeground(new Color(255, 255, 255));
//        responded_inq_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
//
////pay
        JButton payroll = new JButton();
        payroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                notification_panel.setVisible(false);
                exampanel.setVisible(false);
                //leaveformpanel.setVisible(false);
                teacherpanel.setVisible(false);
                //learningpanel.setVisible(false);
                //forumpanel.setVisible(false);
                payrollpanel.setVisible(true);

            }
        });
        payroll.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("../images/payroll.png"))));
        payroll.setToolTipText("Events and Payroll");
        payroll.setLayout(null);
        payroll.setFocusPainted(false);
        payroll.setBorder(null);
        payroll.setBounds(41, 610, 45, 63);
        payroll.setBackground(BG_COLOR);
        sidebar.add(payroll);






//        JPanel addExams = new JPanel();
//        addExams.setBackground(new Color(230, 250, 250));
//        addExams.setBounds(25,200,500,500);
//        payrollpanel.add(addExams);

//        JLabel l_examtitle = new JLabel("Exam Title:                ");
//        l_examtitle.setBounds(0 ,400, 100, 40);
//        l_examtitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
//
//        addExams.add(l_examtitle);





//        JPanel viewExams = new JPanel();
//        viewExams.setBackground(new Color(230, 250, 250));
//        viewExams.setBounds(600,200,500,500);
//        payrollpanel.add(viewExams);



        setVisible(true);
        setLayout(null);
        setResizable(false);
       // setLeaveDates();
       // setInquiries();
        defaultVisible();

    }


    public static void main(String[] args) {

        new AdminGUI(new TeacherDBHelper().getTeacherId("ajai@gmail.com"));

    }

//    void setLeaveDates() {
//        cb_2.removeAllItems();
//        ArrayList<String> dates = teacherDBHelper.getDistinctDates();
//        for (String s : dates) {
//            cb_2.addItem(s);
//        }
//    }
//
//    void setStudentsLeave(String date) {
//        cb.removeAllItems();
//        ArrayList<Leave> leaves = teacherDBHelper.getPendingLeavesFromDate(date);
//        for (Leave l : leaves) {
//            cb.addItem(l.getStudent_id());
//        }
//    }
//
//    void setInquiries() {
//        f_id_cb.removeAllItems();
//        inquiries = teacherDBHelper.allUnrespondedQueries();
//        for (int i = 1; i <= inquiries.size(); i++) {
//            f_id_cb.addItem(i + "");
//        }
//    }
//
//    void setTeacher(String email) {
//        teacher = teacherDBHelper.getTeacherId(email);
//    }

    void addTeacherRecords() {
        ArrayList<Teacher> al = teacherDBHelper.allTeachers();
        teacherRecordArray = new String[al.size() + 1][8];

        teacherRecordArray[0][0] = "S.NO";
        teacherRecordArray[0][1] = "ID";
        teacherRecordArray[0][2] = "NAME";

        teacherRecordArray[0][3] = "CLASS";
        teacherRecordArray[0][4] = "EMAIL";
        teacherRecordArray[0][5] = "EXP";
        teacherRecordArray[0][6] = "PHONE";
        teacherRecordArray[0][7] = "SALARY";

        for (int i = 0; i < al.size(); i++) {
            teacherRecordArray[i + 1][0] = String.valueOf((i + 1));
            teacherRecordArray[i + 1][1] = al.get(i).getTeacher_id();
            teacherRecordArray[i + 1][2] = al.get(i).getName();

            teacherRecordArray[i + 1][3] = al.get(i).gettClass();
            teacherRecordArray[i + 1][4] = al.get(i).getEmail();
            teacherRecordArray[i + 1][5] = String.valueOf(al.get(i).getExperience());
            teacherRecordArray[i + 1][6] = al.get(i).getPhone();
            teacherRecordArray[i + 1][7] = String.valueOf(al.get(i).getSalary());


        }

    }
    void dashboardComponents(){
        JPanel welcometext = new JPanel();
        welcometext.setBounds(50, 20, 1100, 154);
        welcometext.setBackground(new Color(250, 250, 250));
        welcometext.setLayout(null);
        homepanel.add(welcometext);

        JLabel text1 = new JLabel("Welcome Admin !");
        text1.setForeground(new Color(52, 52, 52));
        text1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        text1.setBounds(60, 21, 454, 46);
        welcometext.add(text1);

        JLabel text2 = new JLabel("Have a good day.....");
        text2.setForeground(Color.GRAY);
        text2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text2.setBounds(60, 77, 226, 26);
        welcometext.add(text2);


        total_studentspanel = new JPanel();
        total_studentspanel.setBackground(new Color(255,109,106));
        total_studentspanel.setBounds(130, 200, 199, 123);
        homepanel.add(total_studentspanel);
        total_studentspanel.setLayout(null);

        JLabel class_students = new JLabel(" Total Students");
        class_students.setBounds(30, 10, 159, 30);
        class_students.setForeground(Color.WHITE);
        class_students.setFont(new Font("Segoe UI", Font.BOLD, 19));
        total_studentspanel.add(class_students);

        JLabel tot_students = new JLabel("...........");
        tot_students.setForeground(Color.WHITE);
        tot_students.setFont(new Font("Segoe UI", Font.BOLD, 40));
        tot_students.setBounds(78, 39, 33, 74);
        total_studentspanel.add(tot_students);

        total_teacherspanel = new JPanel();
        total_teacherspanel.setBackground(new Color(138,43,226));
        total_teacherspanel.setBounds(420, 200, 199, 123);
        homepanel.add(total_teacherspanel);
        total_teacherspanel.setLayout(null);

        JLabel tot_teachers = new JLabel(" Total Teachers");
        tot_teachers.setBounds(30, 10, 159, 30);
        tot_teachers.setForeground(Color.WHITE);
        tot_teachers.setFont(new Font("Segoe UI", Font.BOLD, 19));
        total_teacherspanel.add(tot_teachers);

        JLabel teacher_count = new JLabel("...........");
        teacher_count.setForeground(Color.WHITE);
        teacher_count.setFont(new Font("Segoe UI", Font.BOLD, 40));
        teacher_count.setBounds(78, 39, 33, 74);
        total_teacherspanel.add(teacher_count);

        JPanel leave_panel = new JPanel();
        leave_panel.setBackground(new Color(255, 109, 106));
        leave_panel.setBounds(700, 200, 199, 123);
        homepanel.add(leave_panel);
        leave_panel.setLayout(null);

        JLabel leavecount_label = new JLabel(" Leave Count");
        leavecount_label.setBounds(30, 10, 159, 30);
        leavecount_label.setForeground(Color.WHITE);
        leavecount_label.setFont(new Font("Segoe UI", Font.BOLD, 19));
        leave_panel.add(leavecount_label);

        JLabel leave_percentage = new JLabel("...........");
        leave_percentage.setForeground(Color.WHITE);
        leave_percentage.setFont(new Font("Segoe UI", Font.BOLD, 40));
        leave_percentage.setBounds(78, 39, 33, 74);
        leave_panel.add(leave_percentage);

        JPanel set_classpanel = new JPanel();
        set_classpanel.setBackground(Color.white);
        set_classpanel.setBounds(50, 350, 361, 64);
        homepanel.add(set_classpanel);
        set_classpanel.setLayout(null);

        JLabel set_class = new JLabel("Select Class:");
        set_class.setFont(new Font("Segoe UI", Font.BOLD, 20));
        set_class.setBounds(33, 10, 128, 33);
        set_classpanel.add(set_class);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        comboBox.setBounds(171, 16, 139, 27);
        set_classpanel.add(comboBox);

        JPanel class_panel = new JPanel();
        class_panel.setBackground(new Color(255,109,106));
        class_panel.setBounds(130, 450, 199, 123);
        homepanel.add(class_panel);
        class_panel.setLayout(null);

        JLabel class_student = new JLabel(" Total Students");
        class_student.setBounds(30, 10, 159, 30);
        class_student.setForeground(Color.WHITE);
        class_student.setFont(new Font("Segoe UI", Font.BOLD, 19));
        class_panel.add(class_student);

        JLabel lblNewLabel = new JLabel("...........");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblNewLabel.setBounds(78, 39, 33, 74);
        class_panel.add(lblNewLabel);

        JPanel present_panel = new JPanel();
        present_panel.setBackground(new Color(84, 99, 85));
        present_panel.setBounds(420, 450, 199, 123);
        homepanel.add(present_panel);
        present_panel.setLayout(null);

        JLabel present_label = new JLabel(" Present Today");
        present_label.setBounds(30, 10, 159, 30);
        present_label.setForeground(Color.WHITE);
        present_label.setFont(new Font("Segoe UI", Font.BOLD, 19));
        present_panel.add(present_label);

        JLabel present_count = new JLabel("...........");
        present_count.setForeground(Color.WHITE);
        present_count.setFont(new Font("Segoe UI", Font.BOLD, 40));
        present_count.setBounds(78, 39, 33, 74);
        present_panel.add(present_count);

        JPanel performance_panel = new JPanel();
        performance_panel.setBackground(new Color(255, 109, 106));
        performance_panel.setBounds(700, 450, 199, 123);
        homepanel.add(performance_panel);
        performance_panel.setLayout(null);

        JLabel performance_label = new JLabel(" Performance");
        performance_label.setBounds(30, 10, 159, 30);
        performance_label.setForeground(Color.WHITE);
        performance_label.setFont(new Font("Segoe UI", Font.BOLD, 19));
        performance_panel.add(performance_label);

        JLabel percentage = new JLabel("...........");
        percentage.setForeground(Color.WHITE);
        percentage.setFont(new Font("Segoe UI", Font.BOLD, 40));
        percentage.setBounds(78, 39, 33, 74);
        performance_panel.add(percentage);

        for (String s : adminDBHelper.getAllClass()) {
         //   System.out.println(s);
            comboBox.addItem(s);
        }
        int studentCount = adminDBHelper.getTotalStudentCount();
        int teacherCount = adminDBHelper.getTeacherCount();
        tot_students.setText(studentCount + "");
        teacher_count.setText(teacherCount + "");


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();
                if (index != -1) {
                    int classStudentCount = adminDBHelper.getStudentCountByClass(comboBox.getItemAt(index));
                    int presentTodayCount = adminDBHelper.getPresentToday("23-08-2021", comboBox.getItemAt(index));
                    double performanceCount = adminDBHelper.attendancePercentage("23-08-2021", comboBox.getItemAt(index));
                    lblNewLabel.setText(classStudentCount + "");
                    present_count.setText(presentTodayCount + "");
                    percentage.setText(performanceCount + "");

                }

            }
        });

    }
    void defaultVisible(){
        homepanel.setVisible(true);
        notification_panel.setVisible(false);
        exampanel.setVisible(false);
        //leaveformpanel.setVisible(false);
        teacherpanel.setVisible(false);
        //learningpanel.setVisible(false);
        //forumpanel.setVisible(false);
        payrollpanel.setVisible(false);
    }
    void examComponents(){
        exampanel = new JPanel();
        exampanel.setBackground(Color.white);
        exampanel.setBounds(132, 0, 1336, 777);
        exampanel.setLayout(null);
        p.add(exampanel);

        JPanel grade_info = new JPanel();
        grade_info.setBackground(new Color(250, 250, 250));
        grade_info.setBounds(24, 27, 1150, 142);
        grade_info.setLayout(null);
        exampanel.add(grade_info);

        JLabel g_l1 = new JLabel("Schedule Exams..");
        g_l1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        g_l1.setBounds(47, 31, 694, 47);
        grade_info.add(g_l1);

        JPanel addExam_panel = new JPanel();
        addExam_panel.setBounds(24, 270, 501, 446);
        addExam_panel.setBackground(new Color(250, 250, 250));
        exampanel.add(addExam_panel);
        addExam_panel.setLayout(null);

        JLabel Exam_title_label = new JLabel("Exam Title :");
        Exam_title_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
        Exam_title_label.setBounds(58, 74, 141, 35);
        addExam_panel.add(Exam_title_label);

        JLabel Start_Date_Label = new JLabel("Start Date  :");
        Start_Date_Label.setFont(new Font("Segoe UI", Font.BOLD, 23));
        Start_Date_Label.setBounds(59, 150, 140, 35);
        addExam_panel.add(Start_Date_Label);

        JLabel End_Date_label = new JLabel("End Date    :");
        End_Date_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
        End_Date_label.setBounds(58, 226, 141, 35);
        addExam_panel.add(End_Date_label);

        Title_text = new JTextField();
        Title_text.setToolTipText("Enter Exam title");
        Title_text.setBounds(222, 76, 192, 33);
        addExam_panel.add(Title_text);
//        Title_text.setColumns(10);

        Start_text = new JTextField();
        Start_text.setToolTipText("Enter Start Date");
        Start_text.setColumns(10);
        Start_text.setBounds(222, 150, 192, 33);
        addExam_panel.add(Start_text);

        End_Text = new JTextField();
        End_Text.setToolTipText("Enter End Date");
        End_Text.setColumns(10);
        End_Text.setBounds(222, 226, 192, 33);
        addExam_panel.add(End_Text);

        JButton addButton = new JButton("Add");
        addButton.setBackground(BG_GREEN);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(179, 325, 85, 33);
        addButton.setFocusPainted(false);
        addExam_panel.add(addButton);


        JPanel viewExam_panel = new JPanel();
        viewExam_panel.setBounds(560, 270, 555, 446);
        exampanel.add(viewExam_panel);
        viewExam_panel.setBackground(new Color(250, 250, 250));
        viewExam_panel.setLayout(null);

        JLabel Exam_label = new JLabel("Exam  :");
        Exam_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
        Exam_label.setBounds(58, 74, 141, 35);
        viewExam_panel.add(Exam_label);

        JComboBox<String> exams_combobox = new JComboBox<String>();
        exams_combobox.setBounds(227, 74, 199, 34);
        viewExam_panel.add(exams_combobox);

        setComboExam(exams_combobox);

        JLabel start_label = new JLabel("Start Date  :");
        start_label.setFont(new Font("Segoe UI", Font.BOLD, 23));
        start_label.setBounds(58, 158, 141, 35);
        viewExam_panel.add(start_label);

        JLabel start_label_1 = new JLabel("End Date  :");
        start_label_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
        start_label_1.setBounds(285, 158, 141, 35);
        viewExam_panel.add(start_label_1);

         viewStart = new JTextField();
        viewStart.setFont(new Font("Segoe UI", Font.BOLD, 18));
        viewStart.setBounds(58, 203, 153, 35);
        viewExam_panel.add(viewStart);
        viewStart.setColumns(10);

        viewEnd = new JTextField();
        viewEnd.setFont(new Font("Segoe UI", Font.BOLD, 18));
        viewEnd.setColumns(10);
        viewEnd.setBounds(285, 203, 153, 35);
        viewExam_panel.add(viewEnd);

        JButton update_exambtn = new JButton("UPDATE");
        update_exambtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        update_exambtn.setFocusPainted(false);
        update_exambtn.setBackground(new Color(136, 217, 242));


        update_exambtn.setBounds(77, 325, 111, 35);
        viewExam_panel.add(update_exambtn);

        JButton removebtn = new JButton("REMOVE");
        removebtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        removebtn.setBounds(298, 325, 111, 35);
        removebtn.setBackground(new Color(242, 136, 168));
        removebtn.setFocusPainted(false);
        viewExam_panel.add(removebtn);


        addButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Title_text.getText().length() == 0 || Start_text.getText().length() != 10 || End_Text.getText().length() != 10) {
                            JOptionPane.showMessageDialog(AdminGUI.this, "Enter all the fields correctly");
                        } else {
                            Exam exam = new Exam(Title_text.getText(), Start_text.getText(), End_Text.getText());
                            if (adminDBHelper.createExam(exam)) {
                                JOptionPane.showMessageDialog(AdminGUI.this, "Exam added");
                                Title_text.setText("");
                                Start_text.setText("");
                                End_Text.setText("");
                                setComboExam(exams_combobox);
                            } else {
                                JOptionPane.showMessageDialog(AdminGUI.this, "Error in adding");
                            }
                        }
                    }
                }
        );
        exams_combobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = exams_combobox.getSelectedIndex();
                if (index != -1) {
                    viewStart.setText(alExams.get(index).getStart_date());
                    viewEnd.setText(alExams.get(index).getEnd_date());

                }

            }
        });
        update_exambtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (viewStart.getText().length() != 10 || viewEnd.getText().length() != 10) {
                    JOptionPane.showMessageDialog(AdminGUI.this, "Enter all the fields correctly");
                } else {
                    Exam exam = new Exam((exams_combobox.getItemAt(exams_combobox.getSelectedIndex())), viewStart.getText(), viewEnd.getText());
                    if (adminDBHelper.updateExam(exam)) {
                        JOptionPane.showMessageDialog(AdminGUI.this, "Exam Updated");
                        setComboExam(exams_combobox);
                    } else {

                        JOptionPane.showMessageDialog(AdminGUI.this, "Update failed");
                    }
                }
            }
        });
        removebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (exams_combobox.getSelectedIndex() != -1) {
                    if (adminDBHelper.deleteExam(exams_combobox.getItemAt(exams_combobox.getSelectedIndex()))) {
                        JOptionPane.showMessageDialog(AdminGUI.this, "Removed");
                        setComboExam(exams_combobox);
                    } else {
                        JOptionPane.showMessageDialog(AdminGUI.this, "Error in removing");
                    }
                }

            }
        });
    }

    void setComboExam(JComboBox<String> combo) {

        alExams.clear();
        alExams = adminDBHelper.getExams();
        combo.removeAllItems();
        for (Exam ex : alExams) {
            combo.addItem(ex.getTitle());
        }

    }
    void mailComponents(){
        notification_panel = new JPanel();
        notification_panel.setBackground(new Color(250, 250, 250));
        notification_panel.setBounds(132, 0, 1336, 1000);
        notification_panel.setLayout(null);
        p.add(notification_panel);

        JPanel notification = new JPanel();
        notification.setBackground(Color.WHITE);
        notification.setBounds(40, 22, 1100, 130);
        notification.setLayout(null);
        notification_panel.add(notification);

        JLabel l1 = new JLabel("Send Notification");
        l1.setBounds(70, 50, 300, 30);
        notification.add(l1);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 28));

        select_ToOptionpanel = new JPanel();
        select_ToOptionpanel.setBounds(40, 170, 380, 543);
        select_ToOptionpanel.setBackground(new Color( 244, 250, 221));
        notification_panel.add(select_ToOptionpanel);
        select_ToOptionpanel.setLayout(null);

         specific_radiobtn = new JRadioButton("Specific");
        specific_radiobtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(specific_radiobtn);
        specific_radiobtn.setFocusPainted(false);
        specific_radiobtn.setBackground(new Color( 244, 250, 221));
        specific_radiobtn.setBounds(62, 62, 239, 36);
        select_ToOptionpanel.add(specific_radiobtn);

         Toall_radiobtn = new JRadioButton("To all Students");
        Toall_radiobtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(Toall_radiobtn);
        Toall_radiobtn.setBounds(62, 145, 239, 36);
        Toall_radiobtn.setFocusPainted(false);
        Toall_radiobtn.setBackground(new Color( 244, 250, 221));
        select_ToOptionpanel.add(Toall_radiobtn);

         rdbtnToAllTeachers = new JRadioButton("To all Teachers");
        rdbtnToAllTeachers.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(rdbtnToAllTeachers);
        rdbtnToAllTeachers.setBounds(62, 229, 239, 36);
        rdbtnToAllTeachers.setBackground(new Color( 244, 250, 221));
        rdbtnToAllTeachers.setFocusPainted(false);
        select_ToOptionpanel.add(rdbtnToAllTeachers);

        rdbtnBoth = new JRadioButton("Both");
        rdbtnBoth.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(rdbtnBoth);
        rdbtnBoth.setBounds(62, 317, 239, 36);
        rdbtnBoth.setBackground(new Color( 244, 250, 221));
        rdbtnBoth.setFocusPainted(false);
        select_ToOptionpanel.add(rdbtnBoth);

        JPanel send_mailpanel = new JPanel();
        send_mailpanel.setBounds(500, 170, 621, 546);
        send_mailpanel.setBackground(new Color(219, 238, 244));
        notification_panel.add(send_mailpanel);
        send_mailpanel.setLayout(null);

        txt_Toaddr = new JTextField();
        txt_Toaddr.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txt_Toaddr.setText("");
                txt_Toaddr.setForeground(Color.BLACK);
                if(!specific_radiobtn.isSelected()){
                    txt_Toaddr.setEditable(false);
                    txt_Toaddr.setText("To");
                    txt_Toaddr.setForeground(Color.LIGHT_GRAY);
                }else{
                    txt_Toaddr.setEditable(true);
                }
            }

        });
        txt_Toaddr.setForeground(Color.LIGHT_GRAY);
        txt_Toaddr.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txt_Toaddr.setText("To");
        txt_Toaddr.setToolTipText("To Address");
        txt_Toaddr.setBounds(53, 50, 430, 40);
        send_mailpanel.add(txt_Toaddr);


        txtSubject = new JTextField();
        txtSubject.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txtSubject.setText("");
                txtSubject.setForeground(Color.BLACK);
            }
        });
        txtSubject.setToolTipText("Enter Subject");
        txtSubject.setText("Subject");
        txtSubject.setForeground(Color.LIGHT_GRAY);
        txtSubject.setToolTipText("Subject");
        txtSubject.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        txtSubject.setBounds(53, 129, 434, 40);
        send_mailpanel.add(txtSubject);

         txt_Body = new JTextArea();
        txt_Body.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txt_Body.setText("");
                txt_Body.setForeground(Color.BLACK);
            }
        });
        txt_Body.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txt_Body.setForeground(Color.LIGHT_GRAY);
        txt_Body.setText("Body");
        txt_Body.setToolTipText("Body");
        txt_Body.setBounds(53, 204, 434, 238);
        send_mailpanel.add(txt_Body);

        JButton clr_btn = new JButton("CLEAR");
        clr_btn.setBackground(Color.CYAN);
        clr_btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        clr_btn.setFocusPainted(false);
        clr_btn.setForeground(Color.BLACK);
        clr_btn.setBounds(80, 475, 93, 30);
        clr_btn.setBorder(new LineBorder(Color.BLACK));
        clr_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSubject.setText("Subject");
                txtSubject.setForeground(Color.LIGHT_GRAY);
                txt_Body.setText("Body");
                txt_Body.setForeground(Color.LIGHT_GRAY);
            }
        });
        send_mailpanel.add(clr_btn);

        JButton send_btn = new JButton("SEND");
        send_btn.setForeground(Color.BLACK);
        send_btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        send_btn.setFocusPainted(false);
        send_btn.setBackground(new Color(255, 109, 106));
        send_btn.setBounds(381, 475, 93, 30);
        send_btn.setBorder(new LineBorder(Color.BLACK));
        send_mailpanel.add(send_btn);

    }
    void payrollComponents(){
        payrollpanel = new JPanel();
        payrollpanel.setBackground(Color.white);
        payrollpanel.setBounds(124, 0, 1336, 777);
        payrollpanel.setLayout(null);
        p.add(payrollpanel);

        JPanel payroll_info = new JPanel();
        payroll_info.setBackground(new Color(250, 250, 250));
        payroll_info.setBounds(25, 21, 1150, 158);
        payroll_info.setLayout(null);
        payrollpanel.add(payroll_info);

        JLabel p_l1 = new JLabel("Payroll And Event Manager");
        p_l1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        p_l1.setBounds(46, 26, 390, 34);
        payroll_info.add(p_l1);

        JPanel addevent_panel = new JPanel();
        addevent_panel.setBackground(new Color(240, 255, 240));
        addevent_panel.setBounds(46, 200, 504, 572);
        payrollpanel.add(addevent_panel);
        addevent_panel.setLayout(null);

        JLabel New_eventlbl = new JLabel("Add a New Event");
        New_eventlbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        New_eventlbl.setBounds(36, 41, 187, 30);
        addevent_panel.add(New_eventlbl);

        JPanel event_panel = new JPanel();
//        event_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), Color.LIGHT_GRAY));
        event_panel.setBackground(new Color(203, 245, 241));
        event_panel.setBounds(48, 101, 398, 432);
        addevent_panel.add(event_panel);
        event_panel.setLayout(null);

        JLabel Event_titlelbl = new JLabel("Event Title");
        Event_titlelbl.setFont(new Font("Segoe UI", Font.BOLD, 17));
        Event_titlelbl.setBounds(32, 21, 157, 41);
        event_panel.add(Event_titlelbl);

        txt_event_Title = new JTextField();
        txt_event_Title.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txt_event_Title.setToolTipText("Enter Event Title");
        txt_event_Title.setBounds(42, 69, 315, 29);
        event_panel.add(txt_event_Title);

        JLabel Event_descp_lbl = new JLabel("Event Description");
        Event_descp_lbl.setFont(new Font("Segoe UI", Font.BOLD, 17));
        Event_descp_lbl.setBounds(32, 127, 157, 41);
        event_panel.add(Event_descp_lbl);

         txt_desc = new JTextArea();
        txt_desc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txt_desc.setBackground(Color.WHITE);
        txt_desc.setToolTipText("Enter Description");
        txt_desc.setBounds(42, 178, 315, 181);
        event_panel.add(txt_desc);

        JButton event_addbtn = new JButton("Add");
        event_addbtn.setForeground(Color.WHITE);
        event_addbtn.setBackground(new Color(102, 153, 102));
        event_addbtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        event_addbtn.setBounds(140, 381, 97, 29);
        event_addbtn.setFocusPainted(false);
        event_addbtn.setBorder(new LineBorder(Color.BLACK));
        event_panel.add(event_addbtn);

        JPanel assign_panel = new JPanel();
        assign_panel.setBackground(new Color(240, 255, 240));
        assign_panel.setBounds(650, 200, 470, 572);
        payrollpanel.add(assign_panel);
        assign_panel.setLayout(null);

        JLabel payroll_lbl = new JLabel("Assign Payroll");
        payroll_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        payroll_lbl.setBounds(36, 41, 187, 30);
        assign_panel.add(payroll_lbl);

        JLabel id_lbl = new JLabel("Teacher_id      :");
        id_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        id_lbl.setBounds(61, 106, 146, 30);
        assign_panel.add(id_lbl);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(217, 106, 181, 30);
        assign_panel.add(comboBox);

        JLabel perf_lbl = new JLabel("Performance   :");
        perf_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        perf_lbl.setBounds(61, 220, 149, 30);
        assign_panel.add(perf_lbl);

        JLabel pay_lbl = new JLabel("Pay Calculated:");
        pay_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pay_lbl.setBounds(61, 280, 146, 30);
        assign_panel.add(pay_lbl);

        performance_lbl = new JLabel("......");
        performance_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        performance_lbl.setBounds(232, 220, 149, 30);
        assign_panel.add(performance_lbl);

        pay_calculatedlbl = new JLabel("......");
        pay_calculatedlbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pay_calculatedlbl.setBounds(232, 280, 149, 30);
        assign_panel.add(pay_calculatedlbl);

        JButton assign_btn = new JButton("Assign");
        assign_btn.setBackground(new Color(233, 150, 122));
        assign_btn.setForeground(Color.WHITE);
        assign_btn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        assign_btn.setBounds(171, 406, 116, 35);
        assign_btn.setFocusPainted(false);
        assign_btn.setBorder(new LineBorder(Color.BLACK));
        assign_panel.add(assign_btn);
    }

}
