package GUI;

import database.StudentDBHelper;
import database.TeacherDBHelper;
import models.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class TeacherGUI extends JFrame {

    JComboBox<String> cb_2;
    JComboBox<String> cb;
    JPanel contentPane;
    JPanel homepanel;
    JPanel attendancepanel;
    JPanel gradespanel;
    JPanel leaveformpanel;
    JPanel studentpanel;
    JPanel learningpanel;
    JPanel forumpanel;
    JPanel payrollpanel;
    ArrayList<Forum> inquiries;
    JComboBox<String> f_id_cb;
    TeacherDBHelper teacherDB = new TeacherDBHelper();
    Teacher teacher = null;
    Attendance attendance = null;
    DefaultTableModel defModel = new DefaultTableModel();
    DefaultTableModel dateDefModel = new DefaultTableModel();
    DefaultTableModel gradeDefModel = new DefaultTableModel();

    public TeacherGUI(Teacher teacher) {
        this.teacher = teacher;
        // setTeacher(email);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1336, 814);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        contentPane.add(p);

        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(29, 217, 171));
        sidebar.setBounds(0, 0, 120, 814);
        p.add(sidebar);
        sidebar.setLayout(null);

        UIManager.put("ToolTip.background", new Color(253, 253, 150));

        JButton home = new JButton();
        home.setBounds(41, 58, 43, 63);
        home.setToolTipText("Home");
        home.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/home profile.png"))));
        home.setBackground(new Color(29, 217, 171));
        home.setLayout(null);
        home.setFocusPainted(false);
        home.setBorder(null);
        sidebar.add(home);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(true);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(false);
                learningpanel.setVisible(false);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(false);

            }
        });

        JButton attendance = new JButton();
        attendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(true);
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(false);
                learningpanel.setVisible(false);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }

        });
        attendance.setBounds(41, 224, 45, 63);
        attendance.setToolTipText("Attendance");
        attendance.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("images/attendance.png")))));
        attendance.setBackground(new Color(29, 217, 171));
        attendance.setLayout(null);
        attendance.setFocusPainted(false);
        attendance.setBorder(null);
        sidebar.add(attendance);

        JButton grade = new JButton();
        grade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(true);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(false);
                learningpanel.setVisible(false);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }
        });
        grade.setBounds(39, 310, 45, 56);
        grade.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/grade.png"))));
        grade.setBackground(new Color(29, 217, 171));
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
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(true);
                learningpanel.setVisible(false);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }
        });
        student.setBounds(39, 151, 45, 47);
        student.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/student.png"))));
        student.setLayout(null);
        student.setFocusPainted(false);
        student.setBorder(null);
        student.setBackground(new Color(29, 217, 171));
        student.setToolTipText("Student Details\r\n");
        sidebar.add(student);

        JButton leaveform = new JButton();
        leaveform.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(true);
                studentpanel.setVisible(false);
                learningpanel.setVisible(false);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }

        });
        leaveform.setToolTipText("Leave Form");
        leaveform.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/leave.png"))));
        leaveform.setLayout(null);
        leaveform.setBackground(new Color(29, 217, 171));
        leaveform.setFocusPainted(false);
        leaveform.setBorder(null);
        leaveform.setBounds(41, 475, 45, 56);
        sidebar.add(leaveform);

        JButton inquiry = new JButton("");
        inquiry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                attendancepanel.setVisible(false);
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(false);
                learningpanel.setVisible(false);
                forumpanel.setVisible(true);
                payrollpanel.setVisible(false);
            }
        });
        inquiry.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/chat icon.png"))));
        inquiry.setToolTipText("Inquiry Forum");
        inquiry.setBackground(new Color(29, 217, 171));
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
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(false);
                learningpanel.setVisible(true);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(false);
            }
        });
        learning.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/learning.png"))));
        learning.setToolTipText("Learning Materials");
        learning.setBackground(new Color(29, 217, 171));
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
                gradespanel.setVisible(false);
                leaveformpanel.setVisible(false);
                studentpanel.setVisible(false);
                learningpanel.setVisible(false);
                forumpanel.setVisible(false);
                payrollpanel.setVisible(true);

            }
        });
        payroll.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/payroll.png"))));
        payroll.setToolTipText("Payroll");
        payroll.setLayout(null);
        payroll.setFocusPainted(false);
        payroll.setBorder(null);
        payroll.setBounds(41, 644, 45, 63);
        payroll.setBackground(new Color(29, 217, 171));
        sidebar.add(payroll);

        homepanel = new JPanel();
        homepanel.setBounds(124, 0, 1336, 1000);
        homepanel.setBackground(Color.WHITE);
        homepanel.setLayout(null);
        p.add(homepanel);

        JLabel teacher_name = new JLabel("Teacher Name");
        teacher_name.setBounds(400, 271, 300, 40);
        teacher_name.setFont(new Font("Segoe UI", Font.BOLD, 36));
        teacher_name.setForeground(new Color(102, 102, 102));
        teacher_name.setText(teacher.getName());
        homepanel.add(teacher_name);

        JLabel teacher_email = new JLabel("emailaddress@schoolname.com");
        teacher_email.setBounds(400, 321, 300, 40);
        teacher_email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        teacher_email.setForeground(new Color(102, 102, 102));
        teacher_email.setText(teacher.getEmail());
        homepanel.add(teacher_email);

        JLabel teacher_phone = new JLabel("9876543210");
        teacher_phone.setBounds(400, 371, 300, 40);
        teacher_phone.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        teacher_phone.setForeground(new Color(102, 102, 102));
        teacher_phone.setText(teacher.getPhone());
        homepanel.add(teacher_phone);

        JLabel teacher_work_exp = new JLabel("5 years work experience");
        teacher_work_exp.setBounds(400, 421, 300, 40);
        teacher_work_exp.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        teacher_work_exp.setForeground(new Color(102, 102, 102));
        teacher_work_exp.setText(teacher.getExperience() + " years work experience");
        homepanel.add(teacher_work_exp);

        JLabel teacher_profile = new JLabel();
        teacher_profile.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/avatar.png"))));
        teacher_profile.setBounds(100, 230, 300, 281);
        teacher_profile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        teacher_profile.setForeground(new Color(102, 102, 102));
        homepanel.add(teacher_profile);

        JLabel notify_img = new JLabel();
        notify_img.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/notify.png"))));
        notify_img.setBounds(150, 670, 30, 40);
        homepanel.add(notify_img);

        JButton logout_button = new JButton("Log out");
        logout_button.setBounds(50, 670, 100, 40);
        logout_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        logout_button.setForeground(Color.black);
        logout_button.setLayout(null);
        logout_button.setBackground(Color.WHITE);
        logout_button.setBorder(null);
        logout_button.setFocusPainted(false);
        Font font = logout_button.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        logout_button.setFont(font.deriveFont(attributes));
        homepanel.add(logout_button);
        logout_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int logout_result = JOptionPane.showConfirmDialog(p, "Are you sure want to Logout?", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (logout_result == JOptionPane.YES_OPTION) {
                    dispose();
                    new LoginGUI();
                } else if (logout_result == JOptionPane.NO_OPTION) {
                } else {

                }
            }
        });

        JPanel welcometext = new JPanel();
        welcometext.setBounds(50, 20, 1100, 154);
        welcometext.setBackground(new Color(250, 250, 250));
        welcometext.setLayout(null);
        homepanel.add(welcometext);

        JLabel text1 = new JLabel("Welcome Teacher !");
        text1.setForeground(new Color(52, 52, 52));
        text1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        text1.setBounds(60, 21, 454, 46);
        welcometext.add(text1);

        JLabel text2 = new JLabel("Have a good day.....");
        text2.setForeground(Color.GRAY);
        text2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text2.setBounds(60, 77, 226, 26);
        welcometext.add(text2);

        JButton schedule_events_button = new JButton("View Important Schedules & Events");
        schedule_events_button.setLayout(null);
        schedule_events_button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        schedule_events_button.setForeground(Color.WHITE);
        schedule_events_button.setBackground(new Color(29, 217, 171));
        schedule_events_button.setBounds(800, 230, 350, 70);
        schedule_events_button.setFocusPainted(false);
        schedule_events_button.setBorder(null);
        schedule_events_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EventsGUI();

            }
        });

        homepanel.add(schedule_events_button);

        JLabel class_text_lbl = new JLabel("Class Summary");
        class_text_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        class_text_lbl.setForeground(Color.BLACK);
        class_text_lbl.setBounds(800, 350, 300, 50);
        homepanel.add(class_text_lbl);

        JLabel class_name_lbl = new JLabel("Class 10", SwingConstants.CENTER);
        class_name_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        class_name_lbl.setForeground(Color.BLACK);
        class_name_lbl.setBounds(800, 410, 350, 50);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        class_name_lbl.setBorder(blackline);
        class_name_lbl.setText("Class " + teacher.gettClass());
        homepanel.add(class_name_lbl);

        JPanel class_summary_table = new JPanel();
        class_summary_table.setBounds(800, 480, 350, 200);
        class_summary_table.setLayout(null);
        class_summary_table.setBackground(new Color(255, 109, 106));
        homepanel.add(class_summary_table);

        JTextArea tot_student_text = new JTextArea("Total Students in your Class        ...");
        tot_student_text.setBounds(20, 20, 300, 50);
        tot_student_text.setLineWrap(true);
        tot_student_text.setWrapStyleWord(true);
        tot_student_text.setForeground(Color.white);
        tot_student_text.setBackground(new Color(255, 109, 106));
        tot_student_text.setFont(new Font("Segoe UI", Font.BOLD, 20));
        class_summary_table.add(tot_student_text);

        JLabel tot_students = new JLabel("54");
        tot_students.setBounds(20, 80, 100, 80);
        tot_students.setFont(new Font("Segoe UI", Font.BOLD, 80));
        tot_students.setForeground(Color.white);
        tot_students.setText(TeacherDBHelper.totalStudents(teacher.gettClass()));
        class_summary_table.add(tot_students);

        attendancepanel = new JPanel();
        attendancepanel.setBackground(new Color(250, 250, 250));
        attendancepanel.setBounds(132, 0, 1336, 1000);
        attendancepanel.setLayout(null);
        p.add(attendancepanel);

        JPanel updateAttendance = new JPanel();
        updateAttendance.setBackground(Color.WHITE);
        updateAttendance.setBounds(40, 22, 1100, 350);
        updateAttendance.setLayout(null);
        attendancepanel.add(updateAttendance);

        JLabel l1 = new JLabel("Attendance Entry");
        l1.setBounds(70, 30, 300, 40);
        updateAttendance.add(l1);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 36));

        JLabel a_student = new JLabel("Student ID:");
        a_student.setFont(new Font("Segoe UI", Font.BOLD, 18));
        a_student.setBounds(350, 114, 100, 30);
        updateAttendance.add(a_student);

//70, 164, 200, 47
        JComboBox<String> a_stu_id = new JComboBox<String>();
        setTeacherComboBox(a_stu_id);
        a_stu_id.setBounds(350, 164, 200, 47);
        a_stu_id.setBackground(Color.white);
        a_stu_id.setFont(new Font("Segoe UI", Font.BOLD, 18));
        updateAttendance.add(a_stu_id);

        JLabel a_date = new JLabel("Date:");
        a_date.setFont(new Font("Segoe UI", Font.BOLD, 18));
        a_date.setBounds(70, 114, 279, 31);
        updateAttendance.add(a_date);

        JTextField a_student_date = new JTextField();
        a_student_date.setBounds(70, 164, 200, 47);
        updateAttendance.add(a_student_date);
        a_student_date.setMargin(new Insets(5, 10, 5, 5));
        a_student_date.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        a_student_date.setColumns(10);

        JLabel a_mark_p_or_ab = new JLabel("Mark Present/Absent:");
        a_mark_p_or_ab.setFont(new Font("Segoe UI", Font.BOLD, 18));
        a_mark_p_or_ab.setBounds(600, 114, 300, 30);
        updateAttendance.add(a_mark_p_or_ab);

        JRadioButton present = new JRadioButton("Present");
        JRadioButton absent = new JRadioButton("Absent");
        present.setBounds(600, 164, 100, 50);
        absent.setBounds(730, 164, 100, 50);
        present.setFont(new Font("Segoe UI", Font.BOLD, 18));
        present.setBorder(null);
        absent.setBorder(null);
        present.setBackground(Color.WHITE);
        absent.setBackground(Color.WHITE);
        absent.setFont(new Font("Segoe UI", Font.BOLD, 18));
        ButtonGroup bg=new ButtonGroup();
        bg.add(present);bg.add(absent);
        updateAttendance.add(present);
        updateAttendance.add(absent);


        JComboBox<String> date_dd = new JComboBox<String>();
        setDistinctAttendanceDates(date_dd);
        date_dd.setBounds(550, 400, 200, 47);
        date_dd.setBackground(Color.white);
        date_dd.setFont(new Font("Segoe UI", Font.BOLD, 18));
        attendancepanel.add(date_dd);

        JButton updatebutton = new JButton("Update");
        updatebutton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        updatebutton.setForeground(Color.WHITE);
        updatebutton.setBackground(new Color(255, 160, 122));
        updatebutton.setBounds(70, 250, 100, 40);
        updatebutton.setLayout(null);
        updatebutton.setFocusPainted(false);
        updatebutton.setBorder(null);
        updatebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = a_stu_id.getSelectedIndex();
                if (index != -1) {
                    String date = a_student_date.getText();
                    if (date.length() != 10) {
                        a_date.setForeground(new Color(255, 0, 0));
                    } else if (bg.getSelection() == null) {
                        a_mark_p_or_ab.setForeground(new Color(255, 0, 0));
                    } else {
                        a_date.setForeground(Color.black);
                        a_mark_p_or_ab.setForeground(Color.black);
                        if (present.isSelected()) {
                            TeacherDBHelper.markAttendance(a_stu_id.getItemAt(index), a_student_date.getText(), "Present");
                            setDistinctAttendanceDates(date_dd);
                        } else {
                            TeacherDBHelper.markAttendance(a_stu_id.getItemAt(index), a_student_date.getText(), "Absent");
                            setDistinctAttendanceDates(date_dd);
                        }
                        if (a_stu_id.getItemCount() == 1) {
                            a_stu_id.removeAllItems();
                        } else {
                            a_stu_id.remove(index);
                        }

                        bg.clearSelection();
                    }
                }
            }
        });
        updateAttendance.add(updatebutton);

        JLabel consolidated_att_lbl = new JLabel("Select the date to display the consolidated attendance:");
        consolidated_att_lbl.setBounds(40, 400, 500, 47);
        consolidated_att_lbl.setBackground(Color.white);
        consolidated_att_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
        attendancepanel.add(consolidated_att_lbl);


//        String pick_date[]={""};
//        JComboBox date_dd = new JComboBox(pick_date);
//        date_dd.setBounds(550, 400, 200, 47);
//        date_dd.setBackground(Color.white);
//        date_dd.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        attendancepanel.add(date_dd);

        date_dd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = date_dd.getSelectedIndex();
                if (index != -1) {
                    setAllConsolidatedAttendance(date_dd.getItemAt(index), teacher.gettClass());
                }
            }
        });

        String[] column = {"S.NO", "ID", "P/A"};
        for (String s : column) {
            dateDefModel.addColumn(s);
        }
        JTable jt = new JTable();
        jt.setModel(dateDefModel);
        jt.setRowHeight(jt.getRowHeight() + 20);
        jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        jt.setBounds(40, 480, 1100, 280);
        attendancepanel.add(jt);

        gradespanel = new JPanel();
        gradespanel.setBackground(Color.white);
        gradespanel.setBounds(132, 0, 1336, 777);
        gradespanel.setLayout(null);
        p.add(gradespanel);

        JPanel grade_info = new JPanel();
        grade_info.setBackground(new Color(250, 250, 250));
        grade_info.setBounds(24, 27, 1150, 142);
        grade_info.setLayout(null);
        gradespanel.add(grade_info);

        JLabel g_l1 = new JLabel("Student Grades");
        g_l1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        g_l1.setBounds(47, 31, 694, 47);
        grade_info.add(g_l1);

        JLabel g_l2 = new JLabel("Edit, update and assign student grades here!");
        g_l2.setForeground(Color.GRAY);
        g_l2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        g_l2.setBounds(57, 84, 398, 33);
        grade_info.add(g_l2);

        JLabel grade_subhead = new JLabel("Consolidated Grade Report");
        grade_subhead.setFont(new Font("Segeo UI", Font.BOLD, 24));
        grade_subhead.setForeground(Color.black);
        grade_subhead.setBorder(null);
        grade_subhead.setBounds(24, 210, 600, 80);
        gradespanel.add(grade_subhead);

        JButton assign_grade_btn = new JButton("Assign Grade");
        assign_grade_btn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/assign.png"))));
        assign_grade_btn.setToolTipText("You can add new student details here");
        assign_grade_btn.setLayout(null);
        assign_grade_btn.setForeground(Color.white);
        assign_grade_btn.setFont(new Font("Segeo UI", Font.BOLD, 16));
        assign_grade_btn.setBackground(new Color(29, 217, 171));
        assign_grade_btn.setFocusPainted(false);
        assign_grade_btn.setBorder(null);
        assign_grade_btn.setBounds(970, 230, 200, 40);
        assign_grade_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AssignGradeForm(TeacherGUI.this, teacher);
            }
        });
        gradespanel.add(assign_grade_btn);

        ///Grades


        String g_column[] = {"Exam", "ID", "Science", "Maths", "Social", "Grade",
                "Result"};

        for (String g : g_column) {
            gradeDefModel.addColumn(g);
        }

        JTable grades_jt = new JTable();
        grades_jt.setModel(gradeDefModel);
        setConsolidatedGrades();
        grades_jt.setRowHeight(jt.getRowHeight() + 20);
        grades_jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        grades_jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        grades_jt.setBounds(24, 300, 1150, 440);
        gradespanel.add(grades_jt);

        studentpanel = new JPanel();
        studentpanel.setBackground(Color.white);
        studentpanel.setBounds(124, 0, 1336, 1000);
        studentpanel.setLayout(null);
        p.add(studentpanel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 250, 250));
        panel.setBounds(30, 10, 1100, 120);
        panel.setLayout(null);
        studentpanel.add(panel);

        JLabel s_text1 = new JLabel("Student Record");
        s_text1.setFont(new Font("Segoe UI", Font.BOLD, 30));
        s_text1.setBounds(30, 10, 489, 40);
        panel.add(s_text1);

        JLabel s_text2 = new JLabel("Class 10");
        s_text2.setForeground(Color.GRAY);
        s_text2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        s_text2.setBounds(30, 60, 214, 30);
        panel.add(s_text2);

        JLabel stu_panel_subhead = new JLabel("Consolidated Student Details of Class 10");
        stu_panel_subhead.setFont(new Font("Segeo UI", Font.BOLD, 24));
        stu_panel_subhead.setForeground(Color.black);
        stu_panel_subhead.setBorder(null);
        stu_panel_subhead.setBounds(50, 210, 600, 80);
        studentpanel.add(stu_panel_subhead);

        JButton add_btn = new JButton();
        add_btn.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/add.png"))));
        add_btn.setToolTipText("You can add new student details here");
        add_btn.setLayout(null);
        add_btn.setBackground(Color.WHITE);
        add_btn.setFocusPainted(false);
        add_btn.setBorder(null);
        add_btn.setBounds(1020, 210, 64, 64);
        add_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AddStudentForm(TeacherGUI.this);
            }
        });
        studentpanel.add(add_btn);


        String s_column[] = {"ID", "NAME", "STD", "EMAIL", "DOB", "GENDER", "PHONE"};

        for (String s : s_column) {
            defModel.addColumn(s);
        }

        JTable s_jt = new JTable();
        s_jt.setModel(defModel);
        setStudentRecords();
        s_jt.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        s_jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        s_jt.setBounds(30, 320, 1100, 390);
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

        JLabel l_l1 = new JLabel("Learning Materials & Syllabus");
        l_l1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        l_l1.setBounds(30, 26, 481, 37);
        learn_info.add(l_l1);

        JLabel l_l2 = new JLabel("Post learning materials, syllabus here !");
        l_l2.setForeground(Color.GRAY);
        l_l2.setBackground(new Color(240, 240, 240));
        l_l2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        l_l2.setBounds(30, 73, 318, 37);
        learn_info.add(l_l2);

        JLabel assign_text = new JLabel(
                "Assign Learning materials Here... !                                           Uploaded Materials");
        assign_text.setFont(new Font("Segoe UI", Font.BOLD, 18));
        assign_text.setBounds(100, 170, 800, 52);
        learningpanel.add(assign_text);

        JButton upload_btn = new JButton("Upload");
        upload_btn.setForeground(Color.WHITE);
        upload_btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        upload_btn.setBackground(new Color(255, 127, 80));
        upload_btn.setBounds(150, 240, 200, 41);
        upload_btn.setLayout(null);
        upload_btn.setFocusPainted(false);
        upload_btn.setBorder(null);
        learningpanel.add(upload_btn);

        JTextArea assign_text_2 = new JTextArea("Bigger File?Please provide a Google Drive link in the box below...");
        assign_text_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        assign_text_2.setBounds(100, 360, 400, 50);
        assign_text_2.setWrapStyleWord(true);
        assign_text_2.setForeground(Color.lightGray);
        assign_text_2.setLineWrap(true);
        learningpanel.add(assign_text_2);

        JTextArea drive_link = new JTextArea("");
        drive_link.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        drive_link.setBounds(100, 430, 400, 250);
        drive_link.setBackground(Color.white);
        drive_link.setWrapStyleWord(true);
        drive_link.setBorder(blackline);
        drive_link.setMargin(new Insets(10, 20, 10, 10));
        drive_link.setLineWrap(true);
        learningpanel.add(drive_link);

        // String material[][] = { { "1.", "science_material.pdf" } };
        // String mat_column[] = { "S.NO.", "MATERIAL" };
        JTable material_jt = new JTable();
        material_jt.setModel(new DefaultTableModel(new Object[][]{{"S.NO", "MATERIAL"}, {null, null, null},
                {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null},
                {null, null, null}, {null, null, null}, {null, null, null}

        }, new String[]{"S.NO.", "MATERIAL"}));
        material_jt.setRowHeight(jt.getRowHeight() + 20);
        material_jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        material_jt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        material_jt.setBounds(600, 240, 500, 440);
        learningpanel.add(material_jt);

        leaveformpanel = new JPanel();
        leaveformpanel.setBackground(new Color(250, 250, 250));
        leaveformpanel.setBounds(124, 0, 1336, 777);
        leaveformpanel.setLayout(null);
        p.add(leaveformpanel);

        JPanel leave_info = new JPanel();
        leave_info.setBounds(24, 10, 1150, 282);
        leave_info.setBackground(new Color(255, 255, 255));
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


        JLabel tot_req_text = new JLabel("Total Requests");
        tot_req_text.setForeground(Color.WHITE);
        tot_req_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tot_req_text.setBounds(50, 80, 123, 30);
        total_req_panel.add(tot_req_text);

        JLabel no_of_req = new JLabel("...");
        no_of_req.setForeground(Color.WHITE);
        no_of_req.setFont(new Font("Segoe UI", Font.BOLD, 36));
        no_of_req.setBounds(100, 10, 52, 67);
        no_of_req.setText(TeacherDBHelper.getLeaveCount(teacher.getEmail())+"");
        total_req_panel.add(no_of_req);



        JPanel approved_req_panel = new JPanel();
        approved_req_panel.setBackground(new Color(250, 128, 114));
        approved_req_panel.setBounds(658, 102, 219, 131);
        approved_req_panel.setLayout(null);
        leave_info.add(approved_req_panel);

        JLabel no_approved = new JLabel("2");
        no_approved.setForeground(Color.WHITE);
        no_approved.setFont(new Font("Segoe UI", Font.BOLD, 36));
        no_approved.setBounds(100, 10, 52, 67);
        no_approved.setText(TeacherDBHelper.approvedLeaveCount(teacher.getTeacher_id())+"");
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



        JLabel tot_disapproved_text = new JLabel("Pending");
        tot_disapproved_text.setForeground(Color.WHITE);
        tot_disapproved_text.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tot_disapproved_text.setBounds(70, 80, 123, 30);
        disapproved_req_panel.add(tot_disapproved_text);

        JLabel no_disapproved = new JLabel("..");
        no_disapproved.setForeground(Color.WHITE);
        no_disapproved.setFont(new Font("Segoe UI", Font.BOLD, 36));
        no_disapproved.setBounds(100, 10, 52, 67);
        no_disapproved.setText(TeacherDBHelper.PendingLeaveCount(teacher.getEmail())+"");
        disapproved_req_panel.add(no_disapproved);

        JPanel leave_apply_panel = new JPanel();
        leave_apply_panel.setBackground(Color.WHITE);
        leave_apply_panel.setBounds(23, 322, 1150, 445);
        leave_apply_panel.setLayout(null);
        leaveformpanel.add(leave_apply_panel);

        JLabel label2 = new JLabel("Student ID");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label2.setBounds(65, 100, 100, 49);
        leave_apply_panel.add(label2);

        // String s_id[]={"001","002","003","004"};
        cb = new JComboBox<String>();
        cb.setBounds(65, 150, 200, 40);
        cb.setBackground(Color.white);
        cb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        leave_apply_panel.add(cb);

        JLabel label3 = new JLabel("Date");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label3.setBounds(300, 100, 100, 49);
        leave_apply_panel.add(label3);

        // String l_date[]={"21/08/2021","22/08/2021"};
        cb_2 = new JComboBox<String>();
        cb_2.setBounds(300, 150, 200, 40);
        cb_2.setBackground(Color.white);
        cb_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        leave_apply_panel.add(cb_2);
        cb_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = cb_2.getSelectedIndex();
                if (index != -1) {
                    setStudentsLeave(cb_2.getItemAt(index));
                }
            }
        });

        JButton leave_req_view_btn = new JButton("View Leave Request");
        leave_req_view_btn.setBounds(65, 220, 200, 40);
        leave_req_view_btn.setForeground(Color.WHITE);
        leave_req_view_btn.setBackground(new Color(150, 200, 255));
        leave_req_view_btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        leave_req_view_btn.setLayout(null);
        leave_req_view_btn.setFocusPainted(false);
        leave_req_view_btn.setBorder(null);
        leave_apply_panel.add(leave_req_view_btn);
        JTextArea leave_req_ta = new JTextArea();
        leave_req_view_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index1 = cb.getSelectedIndex();
                int index2 = cb_2.getSelectedIndex();
                if (index1 != -1 && index2 != -1) {
                    Leave leave = StudentDBHelper.getSingleLeave(cb.getItemAt(index1), cb_2.getItemAt(index2));
                    leave_req_ta.setText(leave.getReason());
                }
            }
        });

        leave_req_ta.setBounds(600, 100, 500, 200);
        leave_req_ta.setMargin(new Insets(10, 10, 10, 10));
        leave_req_ta.setBackground(Color.WHITE);
        leave_req_ta.setBorder(blackline);
        leave_req_ta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        leave_apply_panel.add(leave_req_ta);

        JLabel label1 = new JLabel("Requests for Leave");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        label1.setBounds(65, 26, 295, 49);
        leave_apply_panel.add(label1);

        JButton d1 = new JButton("Disapprove");
        d1.setForeground(Color.WHITE);
        d1.setBackground(new Color(250, 69, 89));
        d1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        d1.setBounds(750, 320, 138, 41);
        d1.setLayout(null);
        d1.setFocusPainted(false);
        d1.setBorder(null);
        leave_apply_panel.add(d1);

        JButton a1 = new JButton("Approve");
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        a1.setBackground(new Color(46, 185, 115));
        a1.setBounds(600, 320, 138, 41);
        a1.setLayout(null);
        a1.setFocusPainted(false);
        a1.setBorder(null);
        leave_apply_panel.add(a1);

        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index1 = cb.getSelectedIndex();
                int index2 = cb_2.getSelectedIndex();
                if (index1 != -1 && index2 != -1) {
                    Leave leave = StudentDBHelper.getSingleLeave(cb.getItemAt(index1), cb_2.getItemAt(index2));
                    TeacherDBHelper.approveLeave(leave);
                    leave_req_ta.setText("");
                    setLeaveDates();

                    // Clear Text functions
                }
            }
        });
        d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index1 = cb.getSelectedIndex();
                int index2 = cb_2.getSelectedIndex();
                if (index1 != -1 && index2 != -1) {
                    Leave leave = StudentDBHelper.getSingleLeave(cb.getItemAt(index1), cb_2.getItemAt(index2));
                    TeacherDBHelper.RejectLeave(leave);
                    leave_req_ta.setText("");
                    setLeaveDates();
                }
            }
        });

        forumpanel = new JPanel();
        forumpanel.setBackground(Color.white);
        forumpanel.setBounds(124, 0, 1336, 777);
        forumpanel.setLayout(null);
        p.add(forumpanel);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(24, 21, 1100, 130);
        panel_2.setBackground(new Color(250, 250, 250));
        panel_2.setLayout(null);
        forumpanel.add(panel_2);

        JLabel forum_head = new JLabel("Respond to  Student Inquiry");
        forum_head.setFont(new Font("Segoe UI", Font.BOLD, 28));
        forum_head.setBounds(24, 10, 441, 54);
        panel_2.add(forum_head);

        JLabel forum_subhead = new JLabel("Dear Teacher!Manage Student Inquiries here.");
        forum_subhead.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        forum_subhead.setBounds(24, 50, 441, 54);
        forum_subhead.setForeground(Color.GRAY);
        panel_2.add(forum_subhead);

        JPanel forum_response_panel = new JPanel();
        forum_response_panel.setBackground(Color.WHITE);
        forum_response_panel.setBounds(39, 103, 704, 664);
        forumpanel.add(forum_response_panel);
        forum_response_panel.setLayout(null);

        JLabel forum_info_text = new JLabel("All Student Inquiries");
        forum_info_text.setBounds(14, 80, 381, 40);
        forum_info_text.setFont(new Font("Segoe UI", Font.BOLD, 24));
        forum_response_panel.add(forum_info_text);

        JLabel inq_recieved_head = new JLabel("Inquiry ID:");
        inq_recieved_head.setFont(new Font("Segoe UI", Font.BOLD, 17));
        inq_recieved_head.setBounds(14, 155, 89, 20);
        forum_response_panel.add(inq_recieved_head);

        f_id_cb = new JComboBox<String>();
        f_id_cb.setBounds(120, 150, 100, 40);
        f_id_cb.setBackground(Color.white);
        f_id_cb.setFont(new Font("Segoe UI", Font.BOLD, 18));
        forum_response_panel.add(f_id_cb);

        JLabel inq_s_id_head = new JLabel("Student ID:");
        inq_s_id_head.setFont(new Font("Segoe UI", Font.BOLD, 17));
        inq_s_id_head.setBounds(250, 150, 116, 31);
        forum_response_panel.add(inq_s_id_head);

        JTextField t_inq_s_id = new JTextField();
        t_inq_s_id.setFont(new Font("Segoe UI", Font.BOLD, 16));
        t_inq_s_id.setBounds(350, 150, 200, 40);
        forum_response_panel.add(t_inq_s_id);

        JTextArea inquiry_textarea = new JTextArea();
        inquiry_textarea.setBackground(Color.WHITE);
        inquiry_textarea.setWrapStyleWord(true);
        inquiry_textarea.setBorder(blackline);
        inquiry_textarea.setRows(3);
        inquiry_textarea.setMargin(new Insets(30, 30, 10, 10));
        inquiry_textarea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        inquiry_textarea.setBounds(14, 220, 540, 163);
        forum_response_panel.add(inquiry_textarea);

        JTextArea inquiry_textarea_2 = new JTextArea("    Respond to Inquiry here....");
        inquiry_textarea_2.setBackground(Color.WHITE);
        inquiry_textarea_2.setWrapStyleWord(true);
        inquiry_textarea_2.setRows(3);
        inquiry_textarea_2.setBorder(blackline);
        inquiry_textarea_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        inquiry_textarea_2.setForeground(Color.gray);
        inquiry_textarea_2.setMargin(new Insets(30, 30, 10, 10));
        inquiry_textarea_2.setBounds(14, 410, 540, 170);
        inquiry_textarea_2.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                inquiry_textarea_2.setText("");
            }

        });
        forum_response_panel.add(inquiry_textarea_2);

        JButton respond_btn_2 = new JButton("Submit Response");
        respond_btn_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        respond_btn_2.setBackground(new Color(250, 128, 114));
        respond_btn_2.setBounds(14, 600, 200, 40);
        respond_btn_2.setLayout(null);
        respond_btn_2.setForeground(Color.white);
        respond_btn_2.setFocusPainted(false);
        respond_btn_2.setBorder(null);
        forum_response_panel.add(respond_btn_2);
        JPanel inquiry_rec_panel = new JPanel();
        inquiry_rec_panel.setBackground(new Color(255, 160, 122));
        inquiry_rec_panel.setBounds(789, 250, 237, 154);
        inquiry_rec_panel.setLayout(null);
        forumpanel.add(inquiry_rec_panel);



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

        JLabel no_of_inq = new JLabel("0");
        no_of_inq.setForeground(new Color(255, 255, 255));
        no_of_inq.setFont(new Font("Segoe UI", Font.BOLD, 42));
        no_of_inq.setBounds(114, 21, 43, 64);
        no_of_inq.setText(TeacherDBHelper.totalInquiryCount()+"");
        inquiry_rec_panel.add(no_of_inq);


        JLabel responded_inq_text = new JLabel("Inquiries Responded");
        responded_inq_text.setBounds(50, 90, 218, 28);
        inq_responded_panel.add(responded_inq_text);
        responded_inq_text.setForeground(new Color(255, 255, 255));
        responded_inq_text.setFont(new Font("Segoe UI", Font.BOLD, 16));


        JLabel responded_inq = new JLabel("0");
        responded_inq.setBounds(114, 21, 45, 51);
        inq_responded_panel.add(responded_inq);
        responded_inq.setForeground(new Color(255, 255, 255));
        responded_inq.setFont(new Font("Segoe UI", Font.BOLD, 42));
        responded_inq.setText(TeacherDBHelper.respondedInquiryCount()+"");
        f_id_cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index1 = f_id_cb.getSelectedIndex();
                if (index1 != -1) {
                    Forum forum = inquiries.get(index1);
                    t_inq_s_id.setText(forum.getStudent_id());
                    inquiry_textarea.setText(forum.getDescription());
                    inquiry_textarea.setEditable(false);

                }
            }
        });
        respond_btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = f_id_cb.getSelectedIndex();
                if (inquiry_textarea_2.getText().length() < 1) {
                    JOptionPane.showMessageDialog(TeacherGUI.this, "Please Enter Something");
                } else if (index != -1) {
                    Forum forum = inquiries.get(index);
                    forum.setResponse(inquiry_textarea_2.getText());
                    TeacherDBHelper.replyQuestion(forum);
                    setInquiries();
                    JOptionPane.showMessageDialog(TeacherGUI.this, "Replied!");
                    inquiry_textarea_2.setText("");
                    responded_inq.setText(TeacherDBHelper.respondedInquiryCount()+""); no_of_inq.setText(TeacherDBHelper.totalInquiryCount()+"");
                }
            }
        });



        payrollpanel = new JPanel();
        payrollpanel.setBackground(Color.white);
        payrollpanel.setBounds(124, 0, 1336, 777);
        payrollpanel.setLayout(null);
        p.add(payrollpanel);

        JPanel payroll_info = new JPanel();
        payroll_info.setBackground(new Color(250, 250, 250));
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

        setVisible(true);
        JLabel pay_text_1 = new JLabel("Click below to access your payroll");
        pay_text_1.setForeground(Color.black);
        pay_text_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pay_text_1.setBounds(46, 250, 500, 40);
        payrollpanel.add(pay_text_1);

        JButton access_pay_btn = new JButton("Access payroll");
        access_pay_btn.setBackground(new Color(255, 154, 162));
        access_pay_btn.setForeground(Color.white);
        access_pay_btn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        access_pay_btn.setBounds(46, 320, 200, 50);
        access_pay_btn.setLayout(null);
        access_pay_btn.setBorder(null);
        access_pay_btn.setFocusPainted(false);
        payrollpanel.add(access_pay_btn);

        JLabel sal_lbl = new JLabel("Your have been credited with:");
        sal_lbl.setForeground(Color.black);
        sal_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        sal_lbl.setBounds(46, 390, 300, 150);
        sal_lbl.setBorder(null);
        payrollpanel.add(sal_lbl);

        JLabel salary_amt = new JLabel();
        salary_amt.setBackground(new Color(139, 217, 199));
        salary_amt.setForeground(Color.white);
        salary_amt.setFont(new Font("Segoe UI", Font.BOLD, 34));
        salary_amt.setBounds(46, 500, 200, 150);
        salary_amt.setOpaque(true);
        salary_amt.setBorder(null);
        payrollpanel.add(salary_amt);

        JLabel teacher_performance = new JLabel("Your Performance Analysis");
        teacher_performance.setForeground(Color.black);
        teacher_performance.setFont(new Font("Segoe UI", Font.BOLD, 20));
        teacher_performance.setBounds(800, 200, 400, 150);
        teacher_performance.setBorder(null);
        payrollpanel.add(teacher_performance);

        JSeparator sep = new JSeparator();
        sep.setOrientation(SwingConstants.HORIZONTAL);
        sep.setForeground(Color.BLACK);
        sep.setBounds(800, 300, 300, 20);
        payrollpanel.add(sep);

        JLabel teacher_ap_lbl = new JLabel("Attendance Performance");
        teacher_ap_lbl.setForeground(Color.black);
        teacher_ap_lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        teacher_ap_lbl.setBounds(800, 350, 400, 50);
        teacher_ap_lbl.setBorder(null);
        payrollpanel.add(teacher_ap_lbl);

        JLabel teacher_att_percent = new JLabel(" 90%");
        teacher_att_percent.setBackground(new Color(139, 217, 199));
        teacher_att_percent.setForeground(Color.white);
        teacher_att_percent.setFont(new Font("Segoe UI", Font.BOLD, 20));
        teacher_att_percent.setBounds(1060, 350, 50, 40);
        teacher_att_percent.setOpaque(true);
        teacher_att_percent.setBorder(null);
        payrollpanel.add(teacher_att_percent);

        access_pay_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String high_sec_pin = "1234";
                String pin = JOptionPane.showInputDialog("Enter your high security 4-digit pin");

                if (pin.equals(high_sec_pin)) {
                    JOptionPane.showMessageDialog(null,
                            "Congratulations !!! your account isn credited with your new payroll");
                    salary_amt.setText("  $3000.00");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid pin number!!");
                }

            }

        });

        setVisible(true);
        setLayout(null);
        setResizable(false);
        setLeaveDates();
        setInquiries();

        homepanel.setVisible(true);
        attendancepanel.setVisible(false);
        gradespanel.setVisible(false);
        leaveformpanel.setVisible(false);
        studentpanel.setVisible(false);
        learningpanel.setVisible(false);
        forumpanel.setVisible(false);
        payrollpanel.setVisible(false);

    }

    public static void main(String[] args) {

         new TeacherGUI( TeacherDBHelper.getTeacherId("ajai@gmail.com"));

        //Teacher teacher = new Teacher("19eucs005", "12345", "12", "Ajai", "ajai@gmail", 3, "9545454545", 5000000);
        //new TeacherGUI(teacher);
    }

    void setLeaveDates() {
        cb_2.removeAllItems();
        ArrayList<String> dates = TeacherDBHelper.getDistinctDates();
        for (String s : dates) {
            cb_2.addItem(s);
        }
    }

    void setStudentsLeave(String date) {
        cb.removeAllItems();
        ArrayList<Leave> leaves = TeacherDBHelper.getPendingLeavesFromDate(date);
        for (Leave l : leaves) {
            cb.addItem(l.getStudent_id());
        }
    }

    void setInquiries() {
        f_id_cb.removeAllItems();
        inquiries = TeacherDBHelper.allUnrespondedQueries();
        for (int i = 1; i <= inquiries.size(); i++) {
            f_id_cb.addItem(i + "");
        }
    }

    void setStudentRecords() {
        defModel.setRowCount(0);

        defModel.addRow(new Object[]{"ID", "NAME", "STD", "EMAIL", "DOB", "GENDER", "PHONE"});

        ArrayList<Student> studentsAl = StudentDBHelper.allStudentsByClass(teacher.gettClass());
        int i = 1;
        for (Student st : studentsAl) {
            defModel.addRow(new Object[]{i, st.getId(), st.getName(), st.getStd(), st.getEmail(), st.getDob(), st.getGender(), st.getPhone()});
            i++;
        }

    }

    void setTeacher(String email) {
        teacher = TeacherDBHelper.getTeacherId(email);
    }

    void setTeacherComboBox(JComboBox<String> a_stu_id) {
        a_stu_id.removeAllItems();
        for (Student s : StudentDBHelper.allStudentsByClass(teacher.gettClass())) {
            a_stu_id.addItem(s.getId());
        }

    }

    void setDistinctAttendanceDates(JComboBox<String> jc) {
        jc.removeAllItems();
        for (String s : TeacherDBHelper.getDistinctDatesAttendance()) {
            jc.addItem(s);
        }
    }

    void setAllConsolidatedAttendance(String date, String std) {
        dateDefModel.setRowCount(0);
        setConsolidatedAttendanceHeader();
        int i = 1;
        for (Attendance at : TeacherDBHelper.getAttendanceByDate(date, std)) {
            //  System.out.println(at.getStatus());
            dateDefModel.addRow(new Object[]{i, at.getStudent_id(), at.getStatus()});
            i++;
        }

    }

    void setConsolidatedAttendanceHeader() {
        dateDefModel.addRow(new Object[]{"S.NO", "ID", "P/A"});
    }

    void setConsolidatedGradeHeader() {
//    String g_column[] = { "Exam", "ID", "Science", "Maths", "Social", "Grade",
//            "Result" };
        gradeDefModel.addRow(new Object[]{"Exam", "ID", "Science", "Maths", "Social", "Grade",
                "Result"});
    }

    void setConsolidatedGrades() {
        gradeDefModel.setRowCount(0);
        setConsolidatedGradeHeader();
        for (Marks m : TeacherDBHelper.getMarksByClass(teacher.gettClass())) {
            String res = m.calcGrade().equals("F") ? "Fail" : "Pass";
            gradeDefModel.addRow(new Object[]{m.getExam_title(), m.getStudent_id(), m.getSub1(), m.getSub2(), m.getSub3(), m.calcGrade(), res});
        }
    }
}
