package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//Util Input Box function
class InputPanel extends JPanel {

    public InputPanel(String name) {
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxlayout);

        JLabel l_name = new JLabel(name + ":");
        l_name.setFont(new Font("Arial", Font.BOLD, 15));
        l_name.setForeground(Color.BLACK);
        l_name.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JTextField t_name = new JTextField(" Enter " + name);
        t_name.setMaximumSize(new Dimension(200, 30));
        t_name.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        t_name.setFont(new Font("Arial", Font.PLAIN, 13));
        t_name.setForeground(Color.decode("#808080"));
        t_name.setBackground(Color.decode("#ebe8e8"));

        t_name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                t_name.setText("");
                t_name.setForeground(Color.BLACK);
            }

            public void focusLost(FocusEvent e) {
                if (t_name.getText().trim().equals("")) {
                    t_name.setText(" Enter " + name);
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

    public AddStudentForm() {

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

        JPanel id = new InputPanel("ID");
        JPanel name = new InputPanel("Name");
        JPanel std = new InputPanel("STD");
        JPanel email = new InputPanel("Email");
        JPanel DOB = new InputPanel("DOB");
        JPanel gender = new InputPanel("Gender");
        JPanel phone = new InputPanel("Phone");

        panel.add(id);
        panel.add(new JLabel());
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
    }

    public static void main(String[] args) {
        AddStudentForm t = new AddStudentForm();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
