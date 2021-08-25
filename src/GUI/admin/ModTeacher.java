package GUI.admin;

import GUI.LoginGUI;
import database.TeacherDBHelper;
import models.Teacher;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ModTeacher extends JFrame {

    JLabel l_id, l_pwd, l_class, l_name, l_email, l_exp, l_phone, l_salary;
    JTextField t_pwd, t_class, t_name, t_email, t_exp, t_phone, t_salary;
    Font font = new Font("Times New Roman", 1, 21);
    JComboBox<String> teacher_box;
    JPanel panel=new JPanel();
    JButton editButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    TeacherDBHelper teacherDBHelper = new TeacherDBHelper();
    ArrayList<Teacher> alTeachers;

    public ModTeacher() {

        setBounds(50, 50, 500, 600);
        setVisible(true);
        setLayout(null);
        panel.setBounds(0, 0, 500, 600);
        panel.setBackground(Color.white);
        panel.setBorder(new LineBorder(Color.white));
        panel.setBorder(new LineBorder(Color.blue));
        panel.setLayout(null);
        add(panel);
        setLabelBounds();
        setTextFields();

        setButton();
        setTeacherBox();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new ModTeacher();
    }

    void setLabelBounds() {
        l_id = new JLabel("ID ");
        l_id.setFont(font);
        l_id.setBounds(70, 50, 120, 30);
        panel.add(l_id);

        l_pwd = new JLabel("Password ");
        l_pwd.setFont(font);
        l_pwd.setBounds(70, 100, 120, 30);
        panel.add(l_pwd);

        l_name = new JLabel("Name");
        l_name.setFont(font);
        l_name.setBounds(70, 150, 120, 30);
        panel.add(l_name);

        l_class = new JLabel("Class");
        l_class.setFont(font);
        l_class.setBounds(70, 200, 120, 30);
        panel.add(l_class);

        l_email = new JLabel("Email");
        l_email.setFont(font);
        l_email.setBounds(70, 250, 120, 30);
        panel.add(l_email);

        l_exp = new JLabel("Experience");
        l_exp.setFont(font);
        l_exp.setBounds(70, 300, 250, 30);
        panel.add(l_exp);

        l_phone = new JLabel("Phone");
        l_phone.setFont(font);
        l_phone.setBounds(70, 350, 200, 30);
        panel.add(l_phone);

        l_salary = new JLabel("Salary");
        l_salary.setFont(font);
        l_salary.setBounds(70, 400, 120, 30);
        panel.add(l_salary);

    }

    void setTextFields() {
//        t_id = new JTextField();
//        t_id.setBounds(240, 50, 150, 30);
//        add(t_id);
        teacher_box = new JComboBox<String>();
        teacher_box.setBounds(240, 50, 150, 30);
        teacher_box.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(teacher_box);
        t_pwd = new JTextField();
        t_pwd.setBounds(240, 100, 150, 30);
        t_pwd.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_pwd);
        t_name = new JTextField();
        t_name.setBounds(240, 150, 150, 30);
        t_name.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_name);
        t_class = new JTextField();
        t_class.setBounds(240, 200, 150, 30);
        t_class.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_class);

        t_email = new JTextField();
        t_email.setBounds(240, 250, 150, 30);
        t_email.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_email);

        t_exp = new JTextField();
        t_exp.setBounds(240, 300, 150, 30);
        t_exp.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_exp);

        t_phone = new JTextField();
        t_phone.setBounds(240, 350, 150, 30);
        t_phone.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_phone);

        t_salary = new JTextField();
        t_salary.setBounds(240, 400, 150, 30);
        t_salary.setBorder(new BasicBorders.FieldBorder(Color.gray,Color.gray,Color.gray,Color.gray));
        panel.add(t_salary);
    }

    void setButton() {
        editButton.setBounds(100, 460, 100, 30);
        editButton.setBorder(new EtchedBorder());
        editButton.setForeground(Color.white);
        editButton.setBackground(new Color(28, 133, 232));
        panel.add(editButton);


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validatempty()) {
                    JOptionPane.showMessageDialog(ModTeacher.this, "Enter all Details");
                } else {
                    setColor();
                    if (validateEmail() && validatePhone() && validatePwd() && validateName()) {

                        int index = teacher_box.getSelectedIndex();
                        Teacher teacher = alTeachers.get(index);
                        Teacher user = new Teacher(teacher.getTeacher_id(), t_pwd.getText(), t_class.getText(), t_name.getText(), t_email.getText(), Integer.parseInt(t_exp.getText()), t_phone.getText(), Integer.parseInt(t_salary.getText()));

                        if (new TeacherDBHelper().updateTeacher(user)) {
                            JOptionPane.showMessageDialog(ModTeacher.this, "Teacher Updated successfully");
                            setTeacherBox();
                            //dispose();
                        } else {
                            JOptionPane.showMessageDialog(ModTeacher.this, "Failure updating teacher");
                            //dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(ModTeacher.this, "Enter valid values");
                    }
                }
            }
        });

        deleteButton.setBounds(250, 460, 100, 30);
        deleteButton.setBorder(new EtchedBorder());
        deleteButton.setBackground(new Color(176, 0, 32));
        deleteButton.setForeground(Color.white);
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = teacher_box.getSelectedIndex();
                if (index != -1) {
                    int logout_result = JOptionPane.showConfirmDialog(panel,"Are you sure want to Delete?","",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(logout_result == JOptionPane.YES_OPTION){
                        if(teacherDBHelper.deleteTeacher(alTeachers.get(index).getTeacher_id())){
                            JOptionPane.showMessageDialog(ModTeacher.this,"Deleted Succesfully");
                            setEmpty();
                        }else{
                            JOptionPane.showMessageDialog(ModTeacher.this,"Deletion Failed");
                        }
                    }


                    setTeacherBox();
                }
            }
        });
    }

    public void setColor() {
        l_id.setForeground(Color.BLACK);
        l_pwd.setForeground(Color.BLACK);
        l_name.setForeground(Color.BLACK);
        l_class.setForeground(Color.BLACK);
        l_phone.setForeground(Color.BLACK);
        l_salary.setForeground(Color.BLACK);
        l_email.setForeground(Color.BLACK);
        l_exp.setForeground(Color.BLACK);
    }
    public void setEmpty(){
        t_salary.setText("");t_name.setText("");
        t_email.setText("");t_exp.setText("");
        t_class.setText("");t_phone.setText("");t_pwd.setText("");
    }

    public boolean validatempty() {

        if (t_pwd.getText().length() == 0) {
            l_pwd.setForeground(Color.red);
            return true;
        }
        if (t_name.getText().length() == 0) {
            l_name.setForeground(Color.red);
            return true;
        }
        if (t_class.getText().length() == 0) {
            l_class.setForeground(Color.red);
            return true;
        }
        if (t_email.getText().length() == 0) {
            l_email.setForeground(Color.red);
            return true;
        }
        if (t_exp.getText().length() == 0) {
            l_exp.setForeground(Color.red);
            return true;
        }
        if (t_phone.getText().length() == 0) {
            l_phone.setForeground(Color.red);
            return true;
        }
        if (t_salary.getText().length() == 0) {
            l_salary.setForeground(Color.red);
            return true;
        }
        return false;
    }

    public boolean validatePwd() {
        if (t_pwd.getText().length() < 16) {

            return true;
        }
        l_pwd.setForeground(Color.red);
        JOptionPane.showMessageDialog(this, "Invalid Password!");
        return false;
    }

    public boolean validateName() {
        if (Pattern.matches("[a-z A-Z]+", t_name.getText())) {

            return true;
        }
        l_name.setForeground(Color.red);
        JOptionPane.showMessageDialog(this, "Invalid Name!");
        return false;
    }

    public boolean validatePhone() {
        if (Pattern.matches("[+-]?[0-9]+", t_phone.getText()) && t_phone.getText().length() == 10) {
            return true;
        }
        l_phone.setForeground(Color.red);
        JOptionPane.showMessageDialog(this, "Invalid Mobile No!");
        return false;
    }

    public boolean validateEmail() {
        if (Pattern.matches(".+\\@.+\\..+", t_email.getText())) {
            return true;
        }
        l_email.setForeground(Color.red);
        JOptionPane.showMessageDialog(this, "Invalid Email!");
        return false;
    }

    void setTeacherBox() {
        teacher_box.removeAllItems();
        alTeachers = teacherDBHelper.allTeachers();
        for (Teacher t : alTeachers) {
            teacher_box.addItem(t.getTeacher_id());
        }
        teacher_box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = teacher_box.getSelectedIndex();
                if (index != -1) {
                    setAllFields(alTeachers.get(index));
                }
            }
        });
    }

    void setAllFields(Teacher teacher) {
        t_pwd.setText(teacher.getPassword());
        t_class.setText(teacher.gettClass());
        t_name.setText(teacher.getName());
        t_email.setText(teacher.getEmail());
        t_exp.setText(String.valueOf(teacher.getExperience()));
        t_phone.setText(teacher.getPhone());
        t_salary.setText(String.valueOf(teacher.getSalary()));
    }

}
