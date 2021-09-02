package GUI;

import database.StudentDBHelper;
import database.ValidationHelper;
import models.Student;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//Util Input Box function
class InputPanel extends JPanel {

    JLabel l_name;
    JTextField t_name;

    public InputPanel(String name) {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);

        l_name = new JLabel(name + ":");
        l_name.setFont(new Font("Arial", Font.BOLD, 15));
        l_name.setForeground(Color.BLACK);
        l_name.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        t_name = new JTextField();
//         t_name = new JTextField(" Enter " + name);
        t_name.setMaximumSize(new Dimension(200, 30));
        t_name.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        t_name.setFont(new Font("Arial", Font.PLAIN, 13));
        t_name.setForeground(Color.decode("#808080"));
        t_name.setBackground(Color.decode("#ebe8e8"));

        t_name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
//                t_name.setText("");
                t_name.setForeground(Color.BLACK);
            }

            public void focusLost(FocusEvent e) {
                if (t_name.getText().trim().equals("")) {
//                    t_name.setText(" Enter " + name);
                    t_name.setForeground(Color.decode("#808080"));
                }
            }
        });

        this.add(l_name);
        this.add(t_name);
        this.setBackground(Color.white);
    }

}

class CoolButton extends JButton {
    CoolButton(String name, Color bgcolor) {
        this.setText(name);
        this.setFont(new Font("Segoe UI", Font.BOLD, 18));
        this.setForeground(Color.WHITE);
        this.setBackground(bgcolor);
        this.setPreferredSize(new Dimension(170, 50));
    }

}

class bottomPanel extends JPanel {
}

class AddStudentForm extends JFrame {
    Student student=null;
    TeacherGUI teacherGUI=null;
    public AddStudentForm(TeacherGUI teacherGUI) {
this.teacherGUI=teacherGUI;
        this.setTitle("Add form");

        JPanel main_panel = new JPanel();
        main_panel.setBackground(Color.white);
        main_panel.setLayout(new BorderLayout());

        JLabel header = new JLabel("Add/Edit/Delete a new student");
        header.setForeground(new Color(52, 52, 52));
        header.setFont(new Font("Segoe UI", Font.BOLD, 27));
        header.setBorder(BorderFactory.createEmptyBorder(20, 30, 0, 0));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(Color.white);

        InputPanel id = new InputPanel("ID");
        InputPanel pwd =new InputPanel("Password");
        InputPanel name = new InputPanel("Name");
        InputPanel std = new InputPanel("STD");
        InputPanel email = new InputPanel("Email");
        InputPanel DOB = new InputPanel("DOB");
        InputPanel gender = new InputPanel("Gender");
        InputPanel phone = new InputPanel("Phone");


        panel.add(id);
        panel.add(pwd);
        panel.add(name);
        panel.add(std);
        panel.add(email);
        panel.add(DOB);
        panel.add(gender);
        panel.add(phone);

        JPanel btn_panel = new JPanel();
        JButton find = new CoolButton("Find Student", Color.decode("#e8bf3a"));
        JButton delete = new CoolButton("Delete Student", Color.decode("#fc584c"));
        JButton save = new CoolButton("Save Student", new Color(29, 217, 171));

        btn_panel.add(find);
        btn_panel.add(save);
        btn_panel.add(delete);

        btn_panel.setBackground(Color.white);
        btn_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        btn_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        main_panel.add(btn_panel, BorderLayout.PAGE_END);

        Border padding = BorderFactory.createEmptyBorder(30, 30, 10, 10);
        panel.setBorder(padding);

        main_panel.add(header, BorderLayout.NORTH);
        main_panel.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.SOUTH);
        main_panel.add(panel, BorderLayout.CENTER);

        setContentPane(main_panel);
        setBounds(100, 100, 640, 500);
        setVisible(true);


        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!id.t_name.getText().equals("")) {
                     student = StudentDBHelper.viewProfile(id.t_name.getText());
                    if (student != null) {
                        name.t_name.setText(student.getName());
                        std.t_name.setText(student.getStd());
                        pwd.t_name.setText(student.getPassword());
                        email.t_name.setText(student.getEmail());
                        gender.t_name.setText(student.getGender());
                        std.t_name.setText(student.getStd());
                        DOB.t_name.setText(student.getDob());
                        phone.t_name.setText(student.getPhone());
                    }else{
                        name.t_name.setText("");
                        std.t_name.setText("");
                        pwd.t_name.setText("");
                        email.t_name.setText("");
                        gender.t_name.setText("");
                        std.t_name.setText("");
                        DOB.t_name.setText("");
                        phone.t_name.setText("");
                    }
                }

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!id.t_name.getText().equals("") && !name.t_name.getText().equals("") && DOB.t_name.getText().length()!=10 && gender.t_name.getText()!="" && phone.t_name.getText().length()!=10 && std.t_name.getText()!="" && !email.t_name.getText().matches(".*@skcet\\.ac\\.in$")){
                    JOptionPane.showMessageDialog(AddStudentForm.this,"Enter valid values");
                }
                else{
                   if(StudentDBHelper.checkStudentExists(id.t_name.getText())){
                      Student st=new Student(student.getId(),student.getPassword(),name.t_name.getText(),std.t_name.getText(),email.t_name.getText(),gender.t_name.getText(),DOB.t_name.getText(),phone.t_name.getText(),student.getFees());
                      if(StudentDBHelper.updateStudent(st)){
                          JOptionPane.showMessageDialog(AddStudentForm.this,"Updated !");
                          teacherGUI.setStudentRecords();
                      }
                      else{
                          JOptionPane.showMessageDialog(AddStudentForm.this,"Update failed !");
                      }
                   }
                   else{
                       Student st=new Student(id.t_name.getText(),pwd.t_name.getText(),name.t_name.getText(),std.t_name.getText(),email.t_name.getText(),gender.t_name.getText(),DOB.t_name.getText(),phone.t_name.getText(),70000);
                       if(StudentDBHelper.createStudent(st)){
                           JOptionPane.showMessageDialog(AddStudentForm.this,"Created !");
                           teacherGUI.setStudentRecords();
                       }
                       else{
                           JOptionPane.showMessageDialog(AddStudentForm.this,"Create failed !");
                       }
                   }

                }

            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!id.t_name.getText().equals("")){
                    String id_Student = id.t_name.getText();
                    if(StudentDBHelper.checkStudentExists(id_Student)){
                        if(StudentDBHelper.deleteStudent(id_Student)){
                            JOptionPane.showMessageDialog(AddStudentForm.this, "Deleted!");
                            teacherGUI.setStudentRecords();
                        }
                        else{
                            JOptionPane.showMessageDialog(AddStudentForm.this, "Error in deleting !");
                        }
                    }else{
                            JOptionPane.showMessageDialog(AddStudentForm.this, "Student doesn't exist!");
                    }
                }
            }
        });


    }

//    public static void main(String[] args) {
//        AddStudentForm t = new AddStudentForm();
//        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

}
