package GUI.teacherscreen;

import javax.swing.*;
import java.awt.*;

//24, 500, 200, 40
class SubjectRow extends JPanel {
    JLabel l_sub_name;
    JTextField t_grade;

    SubjectRow(String subjectName, int[] coords) {
        this.setLayout(new FlowLayout(0, 100, 0));
        this.setBounds(coords[0], coords[1], 700, 100);

        l_sub_name = new JLabel(subjectName);
        l_sub_name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.add(l_sub_name);

        t_grade = new JTextField();
        t_grade.setColumns(5);
        t_grade.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        t_grade.setMargin(new Insets(10, 10, 10, 10));
        this.add(t_grade);

    }
}

public class ViewGrades extends JFrame {
    public ViewGrades() {
        setTitle("View Grades");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);

        JLabel subject_name_lbl = new JLabel("S.no.   Subject Name              Grades");
        subject_name_lbl.setBounds(40, 10, 500, 40);
        subject_name_lbl.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.add(subject_name_lbl);

        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        s.setForeground(Color.BLACK);
        s.setBounds(30, 50, 500, 40);
        this.add(s);

        SubjectRow sub_science = new SubjectRow("1.        Science", new int[] { -50, 70 });
        this.add(sub_science);

        SubjectRow sub_math = new SubjectRow("2.        Math    ", new int[] { -50, 150 });
        this.add(sub_math);

        SubjectRow sub_english = new SubjectRow("3.       English  ", new int[] { -50, 240 });
        this.add(sub_english);

        SubjectRow sub_social = new SubjectRow("4.       Social    ", new int[] { -50, 330 });
        this.add(sub_social);

        JButton assign_grades_btn = new JButton("Assign Grade");
        assign_grades_btn.setBounds(50, 420, 160, 60);
        assign_grades_btn.setForeground(Color.white);
        assign_grades_btn.setBackground(new Color(252, 132, 116));
        assign_grades_btn.setFocusPainted(false);
        assign_grades_btn.setLayout(null);
        assign_grades_btn.setBorder(null);
        assign_grades_btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.add(assign_grades_btn);

    }

    public static void main(String[] args) {
        new ViewGrades();
    }

}
