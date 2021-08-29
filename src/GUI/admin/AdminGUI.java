package GUI.admin;

import database.AdminDBHelper;
import database.TeacherDBHelper;
import models.Attendance;
import models.Exam;
import models.Forum;
import models.Teacher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;


public class AdminGUI extends JFrame {

    TeacherDBHelper teacherDBHelper = new TeacherDBHelper();
    JComboBox<String> cb_2;
    JComboBox<String> cb;
    JComboBox<String> std;
    JPanel contentPane;
    JPanel homepanel, p;
    JPanel notification_panel;
    JPanel exampanel;
    //JPanel leaveformpanel;
    JPanel teacherpanel;
//    JPanel learningpanel;
   // JPanel forumpanel;
    JPanel payrollpanel;
    JPanel total_studentspanel;
    JPanel total_teacherspanel;
    JTextField Title_text, Start_text, End_Text, viewStart, viewEnd, txt_Toaddr, txtSubject, txt_event_Title;
    JTextArea txt_Body, txt_desc;
    JPanel select_ToOptionpanel;
    JLabel performance_lbl, pay_calculatedlbl;
    ButtonGroup bg = new ButtonGroup();
    JRadioButton specific_radiobtn, Toall_radiobtn, rdbtnToAllTeachers, rdbtnBoth;
    ArrayList<Forum> inquiries;
    String[][] teacherRecordArray;
    JComboBox<String> f_id_cb;
    ArrayList<Exam> alExams = new ArrayList<>();
    AdminDBHelper AdminDBHelper = new AdminDBHelper();
    Teacher teacher = null;
    Attendance attendance = null;
    Color BG_COLOR = new Color(176, 0, 32);
    Color BG_GREEN = new Color(11, 138, 62);
    Color BG_BLUE = new Color(28, 133, 232);
    JList<String> a = new JList<>();
    DefaultTableModel defModel = new DefaultTableModel();
    JTable s_jt;
    private JTextField a_stu_name;
    private JTextField a_student_date;

    public AdminGUI(Teacher teacher) {
        this.teacher = teacher;
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

                teacherpanel.setVisible(false);

                payrollpanel.setVisible(false);

            }
        });

        JButton mail = new JButton();
        mail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homepanel.setVisible(false);
                notification_panel.setVisible(true);
                exampanel.setVisible(false);

                teacherpanel.setVisible(false);

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

                teacherpanel.setVisible(false);

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
                teacherpanel.setVisible(true);
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


        homepanel = new JPanel();
        homepanel.setBounds(124, 0, 1336, 1000);
        homepanel.setBackground(Color.WHITE);
        homepanel.setLayout(null);
        p.add(homepanel);
        dashboardComponents();
        examComponents();
        mailComponents();
        payrollComponents();


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
                new AddTeacher(AdminGUI.this);
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

                new ModTeacher(AdminGUI.this);
            }
        });


        s_jt = new JTable();
        s_jt.setModel(defModel);
        String[] s_column = {"S.NO", "ID", "NAME", "CLASS", "EMAIL", "EXP", "PHONE", "SALARY"};
        for (String s : s_column) {
            defModel.addColumn(s);
        }
        setTableRecords();
        s_jt.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        s_jt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        s_jt.setBounds(60, 312, 1100, 421);
        s_jt.setBackground(Color.white);
        s_jt.setRowHeight(s_jt.getRowHeight() + 20);
        teacherpanel.add(s_jt);

////pay
        JButton payroll = new JButton();
        payroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homepanel.setVisible(false);
                notification_panel.setVisible(false);
                exampanel.setVisible(false);

                teacherpanel.setVisible(false);

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


        setVisible(true);
        setLayout(null);
        setResizable(false);

        defaultVisible();

    }


    public static void main(String[] args) {

        new AdminGUI(new TeacherDBHelper().getTeacherId("ajai@gmail.com"));

    }


    void addTeacherRecords() {
        ArrayList<Teacher> al = teacherDBHelper.allTeachers();
        System.out.println("Count INside all teacher records"+al.size());
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

    void dashboardComponents() {
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
        total_studentspanel.setBackground(new Color(255, 109, 106));
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
        total_teacherspanel.setBackground(new Color(138, 43, 226));
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
        class_panel.setBackground(new Color(255, 109, 106));
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

        for (String s : AdminDBHelper.getAllClass()) {
            //   System.out.println(s);
            comboBox.addItem(s);
        }
        int studentCount = AdminDBHelper.getTotalStudentCount();
        int teacherCount = AdminDBHelper.getTeacherCount();
        tot_students.setText(studentCount + "");
        teacher_count.setText(teacherCount + "");


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();
                if (index != -1) {
                    int classStudentCount = AdminDBHelper.getStudentCountByClass(comboBox.getItemAt(index));
                    int presentTodayCount = AdminDBHelper.getPresentToday("23-08-2021", comboBox.getItemAt(index));
                    double performanceCount = AdminDBHelper.attendancePercentage("23-08-2021", comboBox.getItemAt(index));
                    lblNewLabel.setText(classStudentCount + "");
                    present_count.setText(presentTodayCount + "");
                    percentage.setText(performanceCount + "");

                }

            }
        });

    }

    void defaultVisible() {
        homepanel.setVisible(true);
        notification_panel.setVisible(false);
        exampanel.setVisible(false);

        teacherpanel.setVisible(false);

        payrollpanel.setVisible(false);
    }

    void examComponents() {
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
                            if (AdminDBHelper.createExam(exam)) {
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
                    if (AdminDBHelper.updateExam(exam)) {
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
                    if (AdminDBHelper.deleteExam(exams_combobox.getItemAt(exams_combobox.getSelectedIndex()))) {
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
        alExams = AdminDBHelper.getExams();
        combo.removeAllItems();
        for (Exam ex : alExams) {
            combo.addItem(ex.getTitle());
        }

    }

    void mailComponents() {
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
        select_ToOptionpanel.setBackground(new Color(244, 250, 221));
        notification_panel.add(select_ToOptionpanel);
        select_ToOptionpanel.setLayout(null);

        specific_radiobtn = new JRadioButton("Specific");
        specific_radiobtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(specific_radiobtn);
        specific_radiobtn.setFocusPainted(false);
        specific_radiobtn.setBackground(new Color(244, 250, 221));
        specific_radiobtn.setBounds(62, 62, 239, 36);
        select_ToOptionpanel.add(specific_radiobtn);

        Toall_radiobtn = new JRadioButton("To all Students");
        Toall_radiobtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(Toall_radiobtn);
        Toall_radiobtn.setBounds(62, 145, 239, 36);
        Toall_radiobtn.setFocusPainted(false);
        Toall_radiobtn.setBackground(new Color(244, 250, 221));
        select_ToOptionpanel.add(Toall_radiobtn);

        rdbtnToAllTeachers = new JRadioButton("To all Teachers");
        rdbtnToAllTeachers.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(rdbtnToAllTeachers);
        rdbtnToAllTeachers.setBounds(62, 229, 239, 36);
        rdbtnToAllTeachers.setBackground(new Color(244, 250, 221));
        rdbtnToAllTeachers.setFocusPainted(false);
        select_ToOptionpanel.add(rdbtnToAllTeachers);

        rdbtnBoth = new JRadioButton("Both");
        rdbtnBoth.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        bg.add(rdbtnBoth);
        rdbtnBoth.setBounds(62, 317, 239, 36);
        rdbtnBoth.setBackground(new Color(244, 250, 221));
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
                if (!specific_radiobtn.isSelected()) {
                    txt_Toaddr.setEditable(false);
                    txt_Toaddr.setText("To");
                    txt_Toaddr.setForeground(Color.LIGHT_GRAY);
                } else {
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

    void payrollComponents() {
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

    void setTableRecords() {
        clearAllRecords();

        setTeachersTableHeader();
        ArrayList<Teacher> alTeacher = TeacherDBHelper.allTeachers();
        int i = 1;
        for (Teacher teach : alTeacher) {
            defModel.addRow(new Object[]{i, teach.getTeacher_id(), teach.getName(), teach.gettClass(), teach.getEmail(), teach.getExperience(), teach.getPhone(), teach.getSalary()});
            i++;
        }
    }

    void clearAllRecords() {
        defModel.setRowCount(0);

    }

    void setTeachersTableHeader() {
        defModel.addRow(new Object[]{"S.NO", "ID", "NAME", "CLASS", "EMAIL", "EXP", "PHONE", "SALARY"});
    }
}
