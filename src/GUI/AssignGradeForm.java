package GUI;

import database.AdminDBHelper;
import database.StudentDBHelper;
import database.TeacherDBHelper;
import models.Exam;
import models.Marks;
import models.Student;
import models.Teacher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignGradeForm extends JFrame {

    TeacherGUI teacherGUI;
    Teacher teacher;
    private JComboBox<String> student_id_lbl;

    public AssignGradeForm(
            TeacherGUI teacherGUI, Teacher teacher
    ) {
        this.teacherGUI = teacherGUI;
        this.teacher = teacher;
        formComponents();
    }

    void formComponents() {

        setTitle("School Management System");
        JPanel p = new JPanel();
        p.setBackground(new Color(255, 255, 255));
        p.setBounds(0, 0, 830, 640);

        JPanel view_gradePanel = new JPanel();
        view_gradePanel.setBackground(new Color(250, 235, 215));
        view_gradePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        view_gradePanel.setBounds(10, 30, 795, 559);
        p.add(view_gradePanel);
        view_gradePanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Examination Name:");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel.setBounds(36, 37, 199, 28);
        view_gradePanel.add(lblNewLabel);

        JLabel lblStudentid = new JLabel("Student_Id:");
        lblStudentid.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblStudentid.setBounds(476, 37, 106, 28);
        view_gradePanel.add(lblStudentid);


        JComboBox<String> exam_namelbl = new JComboBox<String>();
        exam_namelbl.setBounds(231, 39, 199, 40);
        exam_namelbl.setBackground(Color.white);
        view_gradePanel.add(exam_namelbl);
        setExamCombo(exam_namelbl);


        student_id_lbl = new JComboBox<String>();
//        setStudentCombo(student_id_lbl);
        student_id_lbl.setBounds(592, 37, 170, 40);
        student_id_lbl.setBackground(Color.white);
        view_gradePanel.add(student_id_lbl);
        exam_namelbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=exam_namelbl.getSelectedIndex();
                if(index!=-1){
                    setStudentCombo(student_id_lbl,exam_namelbl.getItemAt(exam_namelbl.getSelectedIndex()));
                }
            }
        });

        JLabel lblSno = new JLabel("S.No.");
        lblSno.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblSno.setBounds(36, 157, 52, 28);
        view_gradePanel.add(lblSno);

        JLabel lblSubjectName = new JLabel("Subject Name");
        lblSubjectName.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblSubjectName.setBounds(136, 157, 150, 28);
        view_gradePanel.add(lblSubjectName);

        JLabel lblGrades = new JLabel("Grades");
        lblGrades.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblGrades.setBounds(326, 157, 150, 28);
        view_gradePanel.add(lblGrades);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.BLACK);
        separator.setBounds(23, 204, 407, 11);
        view_gradePanel.add(separator);

        JLabel lblScience = new JLabel("1.                 Science  :");
        lblScience.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblScience.setBounds(36, 237, 250, 28);
        view_gradePanel.add(lblScience);

        JLabel lblMaths = new JLabel("2.                 Maths    :");
        lblMaths.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblMaths.setBounds(36, 300, 250, 28);
        view_gradePanel.add(lblMaths);

        JLabel lblSocial = new JLabel("3.                 Social    :");
        lblSocial.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblSocial.setBounds(36, 356, 250, 28);
        view_gradePanel.add(lblSocial);

        JTextField science_txt = new JTextField();
        science_txt.setToolTipText("Science");
        science_txt.setBounds(296, 237, 134, 30);
        view_gradePanel.add(science_txt);

        JTextField maths_txt = new JTextField();
        maths_txt.setToolTipText("Maths");
        maths_txt.setBounds(296, 300, 134, 30);
        view_gradePanel.add(maths_txt);

        JTextField social_txt = new JTextField();
        social_txt.setToolTipText("Social");
        social_txt.setBounds(296, 356, 134, 30);
        view_gradePanel.add(social_txt);

        JButton assign_grade_btn = new JButton("Assign");
        assign_grade_btn.setBackground(new Color(233, 150, 122));
        assign_grade_btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        assign_grade_btn.setForeground(Color.WHITE);
        assign_grade_btn.setBounds(187, 443, 150, 40);
        assign_grade_btn.setBorder(null);
        view_gradePanel.add(assign_grade_btn);


        assign_grade_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sci = science_txt.getText();
                String maths=maths_txt.getText();
                String soc = social_txt.getText();

                if(sci!="" && maths!="" && soc!=""){
                    Marks mark=new Marks(student_id_lbl.getSelectedItem().toString(),exam_namelbl.getSelectedItem().toString(),sci,maths,soc,"");
                    TeacherDBHelper.addGrades(mark);
                    JOptionPane.showMessageDialog(AssignGradeForm.this,"Added");
                    if(student_id_lbl.getSelectedIndex()==0){
                        student_id_lbl.removeAllItems();
                    }
                    else{
                        student_id_lbl.remove(student_id_lbl.getSelectedIndex());
                        science_txt.setText("");
                        maths_txt.setText("");
                        social_txt.setText("");
                        teacherGUI.setConsolidatedGrades();
                    }
                }else{
                    JOptionPane.showMessageDialog(AssignGradeForm.this,"Enter all values");
                }

            }
        });


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(p);
        p.setLayout(null);
        setBounds(300, 100, 830, 640);
        setVisible(true);
        setLayout(null);
        setResizable(false);

    }

    void setStudentCombo(JComboBox<String> cbx,String examtitle) {
        cbx.removeAllItems();
        for (String s : StudentDBHelper.getStudents(teacher.gettClass(),examtitle)) {
            cbx.addItem(s);
        }
    }

    void setExamCombo(JComboBox<String> cbx) {
        for (Exam exam : AdminDBHelper.getExams()) {
            cbx.addItem(exam.getTitle());

        }
    }

}
